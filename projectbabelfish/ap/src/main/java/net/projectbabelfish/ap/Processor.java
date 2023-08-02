package net.projectbabelfish.ap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.tools.Diagnostic;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

@SupportedAnnotationTypes({ "net.projectbabelfish.ap.CompatClass" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

	private ProcessingEnvironment processingEnv;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		this.processingEnv = processingEnv;
		super.init(processingEnv);
	}

	private List<TypeElement> allClasses;

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Process!");
		allClasses = new ArrayList<>();
		for (TypeElement annotation : annotations) {
			for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
				allClasses.add((TypeElement) element);
			}
		}

		for (Element element : allClasses) {
			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generating class for " + element);
			try {
				CompatClass compatClass = element.getAnnotation(CompatClass.class);
				if (compatClass != null) {
					generateCompatClasses(compatClass, (TypeElement) element);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private List<TypeElement> getChildrenFor(TypeElement typeSource) {
		Predicate<TypeElement> subtype = element -> processingEnv.getTypeUtils().isSubtype(element.asType(), typeSource.asType()) && !element.equals(typeSource);
		return allClasses.stream().filter(element -> subtype.test(element)).collect(Collectors.toList());
	}

	private void generateCompatClasses(CompatClass compatClass, TypeElement typeSource) throws IOException {
		List<TypeElement> children = getChildrenFor(typeSource);
		generateCompatClass(CompatClassType.INTERFACE, compatClass, typeSource, children);
		generateCompatClass(CompatClassType.PROXY, compatClass, typeSource, children);
		generateCompatClass(CompatClassType.REAL, compatClass, typeSource, children);
	}

	private void generateCompatClass(CompatClassType compatClassType, CompatClass compatClass, TypeElement typeSource, List<TypeElement> children) throws IOException {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generating class type " + compatClassType.getPrefix());

		TypeElement compatTarget = getCompatClassTarget(compatClass);

		GeneratorCompatClass generator = new GeneratorCompatClass(processingEnv, compatClassType, compatTarget, typeSource, children);
		TypeSpec builderClass = generator.generateClass();

		String packageName = ((PackageElement) typeSource.getEnclosingElement()).getQualifiedName().toString();
		packageName = "generated." + packageName;
		JavaFile javaFile = JavaFile.builder(packageName, builderClass).build();

		javaFile.writeTo(processingEnv.getFiler());
	}

	private TypeElement getCompatClassTarget(CompatClass compatClass) {
		try {
			compatClass.target();
			throw new RuntimeException("unreachable");
		} catch (MirroredTypeException e) {
			return (TypeElement) processingEnv.getTypeUtils().asElement(e.getTypeMirror());
		}
	}
}
