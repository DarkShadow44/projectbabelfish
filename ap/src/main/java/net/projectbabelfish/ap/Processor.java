package net.projectbabelfish.ap;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

@SupportedAnnotationTypes("net.projectbabelfish.ap.TestAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement annotation : annotations) {
			for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generating class for " + element);
				try {
					generateClass((TypeElement) element);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	private void generateClass(TypeElement typeIface) throws IOException {
		String className = typeIface.getSimpleName().toString();
		className = className.substring(1) + "Impl";

		TypeSpec.Builder builderClass = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC);
		builderClass.addSuperinterface(typeIface.asType());

		for (Element method : typeIface.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			builderClass.addMethod(generateMethod((ExecutableElement)method));
		}

		String packageName = ((PackageElement) typeIface.getEnclosingElement()).getQualifiedName().toString();
		packageName = "generated." + packageName;
		JavaFile javaFile = JavaFile.builder(packageName, builderClass.build()).build();

		javaFile.writeTo(System.out);
		javaFile.writeTo(processingEnv.getFiler());
	}

	private MethodSpec generateMethod(ExecutableElement method) {

		MethodSpec.Builder builderMethod = MethodSpec.overriding(method);
		builderMethod.addStatement("return 0");

		return builderMethod.build();
	}
}
