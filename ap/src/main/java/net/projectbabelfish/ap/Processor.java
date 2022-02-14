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
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

@SupportedAnnotationTypes({ "net.projectbabelfish.ap.CompatClass" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

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
		String className = typeSource.getSimpleName().toString();
		className = className.replace("Compat_", compatClassType.getPrefix());

		TypeSpec.Builder builderClass;
		if (compatClassType == CompatClassType.INTERFACE) {
			builderClass = TypeSpec.interfaceBuilder(className).addModifiers(Modifier.PUBLIC);
		} else {
			builderClass = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC);
		}

		// Add CompatSource to link to original class
		AnnotationSpec compatSource = AnnotationSpec.builder(CompatSource.class).addMember("source", "$T.class", typeSource.asType()).build();
		builderClass.addAnnotation(compatSource);

		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generating class type " + compatClassType.getPrefix());

		addMethodGet(compatClassType, builderClass, compatClass, typeSource);
		switch (compatClassType) {
		case INTERFACE:
			generateCompatClassInterface(builderClass, compatClass, typeSource);
			break;
		case PROXY:
			generateCompatClassProxy(builderClass, compatClass, typeSource);
			break;
		case REAL:
			generateCompatClassReal(builderClass, compatClass, typeSource);
			break;
		default:
			break;
		}

		String packageName = ((PackageElement) typeSource.getEnclosingElement()).getQualifiedName().toString();
		packageName = "generated." + packageName;
		JavaFile javaFile = JavaFile.builder(packageName, builderClass.build()).build();

		javaFile.writeTo(processingEnv.getFiler());
	}

	private void generateCompatClassInterface(TypeSpec.Builder builderClass, CompatClass compatClass, TypeElement typeSource) {
		for (Element method : typeSource.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			// builderClass.addMethod(generateMethod((ExecutableElement) method));
		}
	}

	private void generateCompatClassProxy(TypeSpec.Builder builderClass, CompatClass compatClass, TypeElement typeSource) {
		addCompatI(builderClass, typeSource);

		// Add "original" field
		FieldSpec fieldOriginal = FieldSpec.builder(getCompatClassTarget(compatClass), "original", Modifier.PRIVATE).build();
		builderClass.addField(fieldOriginal);

		// Add constructor
		MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addParameter(getCompatClassTarget(compatClass), "original");
		constructor.addCode("this.original = original;");
		builderClass.addMethod(constructor.build());

		for (Element method : typeSource.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			builderClass.addMethod(generateMethod((ExecutableElement) method));
		}
	}

	private void generateCompatClassReal(TypeSpec.Builder builderClass, CompatClass compatClass, TypeElement typeSource) {
		addCompatI(builderClass, typeSource);

		// Inherit from Minecraft class
		builderClass.superclass(getCompatClassTarget(compatClass));

		for (Element method : typeSource.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			builderClass.addMethod(generateMethod((ExecutableElement) method));
		}
	}

	private void addCompatI(TypeSpec.Builder builderClass, TypeElement typeSource) {
		String classNameInterface = typeSource.getSimpleName().toString().replace("Compat_", "CompatI_");
		builderClass.addSuperinterface(ClassName.bestGuess(classNameInterface));
	}

	private void addMethodGet(CompatClassType compatClassType, TypeSpec.Builder builderClass, CompatClass compatClass, TypeElement typeSource) {
		MethodSpec.Builder methodGet = MethodSpec.methodBuilder("get");
		methodGet.returns(getCompatClassTarget(compatClass));
		methodGet.addModifiers(Modifier.PUBLIC);
		if (compatClassType == CompatClassType.INTERFACE) {
			methodGet.addModifiers(Modifier.ABSTRACT);
		} else if (compatClassType == CompatClassType.REAL) {
			methodGet.addAnnotation(Override.class);
			methodGet.addCode("return this;");
		} else {
			methodGet.addAnnotation(Override.class);
			methodGet.addCode("return original;");
		}

		builderClass.addMethod(methodGet.build());
	}

	private MethodSpec generateMethod(ExecutableElement method) {
		MethodSpec.Builder builderMethod = MethodSpec.overriding(method);
		builderMethod.addStatement("return s2");

		return builderMethod.build();
	}

	private TypeName getCompatClassTarget(CompatClass compatClass) {
		try {
			compatClass.target();
			throw new RuntimeException("unreachable");
		} catch (MirroredTypeException e) {
			return TypeName.get(e.getTypeMirror());
		}
	}
}
