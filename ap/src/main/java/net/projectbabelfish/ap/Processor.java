package net.projectbabelfish.ap;

import java.io.IOException;
import java.util.Set;

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

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement annotation : annotations) {
			for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
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
		}
		return true;
	}

	private void generateCompatClasses(CompatClass compatClass, TypeElement typeSource) throws IOException {
		generateCompatClass(CompatClassType.INTERFACE, compatClass, typeSource);
		generateCompatClass(CompatClassType.PROXY, compatClass, typeSource);
		generateCompatClass(CompatClassType.REAL, compatClass, typeSource);
	}

	private void generateCompatClass(CompatClassType compatClassType, CompatClass compatClass, TypeElement typeSource) throws IOException {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generating class type " + compatClassType.getPrefix());

		TypeElement compatTarget = getCompatClassTarget(compatClass);

		GeneratorCompatClass generator = new GeneratorCompatClass(processingEnv, compatClassType, compatTarget, typeSource);
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
