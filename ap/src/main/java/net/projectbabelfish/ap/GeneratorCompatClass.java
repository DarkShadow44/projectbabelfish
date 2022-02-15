package net.projectbabelfish.ap;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class GeneratorCompatClass {
	private final CompatClassType compatClassType;
	private TypeName compatTarget;
	private final TypeElement compatTargetElement;
	private final TypeElement typeSource;
	private final TypeSpec.Builder builderClass;
	private final ProcessingEnvironment processingEnv;

	public GeneratorCompatClass(ProcessingEnvironment processingEnv, CompatClassType compatClassType, TypeElement compatTarget, TypeElement typeSource) {
		this.compatClassType = compatClassType;
		this.compatTargetElement = compatTarget;
		this.compatTarget = TypeName.get(compatTargetElement.asType());
		this.typeSource = typeSource;
		this.processingEnv = processingEnv;

		String className = typeSource.getSimpleName().toString();
		className = className.replace("Compat_", compatClassType.getPrefix());

		if (compatClassType == CompatClassType.INTERFACE) {
			builderClass = TypeSpec.interfaceBuilder(className).addModifiers(Modifier.PUBLIC);
		} else {
			builderClass = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC);
		}
	}

	public TypeSpec generateClass() {
		// Add CompatSource to link to original class
		AnnotationSpec compatSource = AnnotationSpec.builder(CompatSource.class).addMember("source", "$T.class", typeSource.asType()).build();
		builderClass.addAnnotation(compatSource);

		addMethodGet();
		generateAllMethodSuper();
		generateAllMethodGetter();
		switch (compatClassType) {
		case INTERFACE:
			generateCompatClassInterface();
			break;
		case PROXY:
			generateCompatClassProxy();
			break;
		case REAL:
			generateCompatClassReal();
			break;
		default:
			break;
		}

		return builderClass.build();
	}

	private void generateCompatClassInterface() {

		TypeMirror superClass = typeSource.getSuperclass();
		if (superClass.getKind() != TypeKind.NONE) {
			String name = processingEnv.getTypeUtils().asElement(superClass).getSimpleName().toString();
			name = name.replace("Compat_", "CompatI_");
			processingEnv.getMessager().printMessage(Kind.NOTE, "Making super: " + name);
			builderClass.addSuperinterface(ClassName.bestGuess(name));
		}
	}

	private void generateCompatClassProxy() {
		addCompatI();

		// Add "original" field
		FieldSpec fieldOriginal = FieldSpec.builder(compatTarget, "original", Modifier.PRIVATE).build();
		builderClass.addField(fieldOriginal);

		// Add constructor
		MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addParameter(compatTarget, "original");
		constructor.addCode("this.original = original;");
		builderClass.addMethod(constructor.build());
	}

	private void generateCompatClassReal() {
		addCompatI();

		// Inherit from Minecraft class
		builderClass.superclass(compatTarget);
	}

	private void addCompatI() {
		String classNameInterface = typeSource.getSimpleName().toString().replace("Compat_", "CompatI_");
		builderClass.addSuperinterface(ClassName.bestGuess(classNameInterface));
	}

	private void addMethodGet() {
		MethodSpec.Builder methodGet = MethodSpec.methodBuilder("get");
		methodGet.returns(compatTarget);
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

	private Element findMcElement(String name, ElementKind kind) {
		for (Element element : compatTargetElement.getEnclosedElements()) {
			if (element.getKind() != kind)
				continue;

			if (element.getSimpleName().toString().equals(name)) {
				return element;
			}
		}

		throw new RuntimeException("Can't find element " + name);
	}

	private void generateAllMethodSuper() {
		for (Element method : typeSource.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			CompatMethod compatMethod = method.getAnnotation(CompatMethod.class);
			if (compatMethod != null) {
				if (compatMethod.generation() == MethodGeneration.NONE)
					continue;
				builderClass.addMethod(generateMethodSuper(compatMethod, (ExecutableElement) method));
			}
		}
	}

	private MethodSpec generateMethodSuper(CompatMethod compatMethod, ExecutableElement method) {
		ExecutableElement methodMc = (ExecutableElement) findMcElement(method.getSimpleName().toString(), ElementKind.METHOD);

		MethodSpec.Builder builderMethod = MethodSpec.overriding(methodMc);
		builderMethod.annotations.clear();
		builderMethod.setName(methodMc.getSimpleName().toString() + "Super");
		if (compatClassType == CompatClassType.INTERFACE) {
			builderMethod.addModifiers(Modifier.ABSTRACT);
		} else {
			if (compatMethod.generation() == MethodGeneration.ONLY_CHILD && compatClassType == CompatClassType.PROXY) {
				builderMethod.addStatement("throw new RuntimeException(\"Invalid operation\")");
			} else {
				CodeBlock.Builder copyCode = CodeBlock.builder();
				List<CodeBlock> params = methodMc.getParameters().stream().map(param -> CodeBlock.of("$N", param.getSimpleName())).collect(Collectors.toList());
				CodeBlock paramList = CodeBlock.join(params, ",");
				copyCode.addStatement("super.$N($L)", methodMc.getSimpleName(), paramList);
				builderMethod.addCode(copyCode.build());
			}
		}

		return builderMethod.build();
	}

	private void generateAllMethodGetter() {
		for (Element method : typeSource.getEnclosedElements()) {
			if (method.getKind() != ElementKind.METHOD)
				continue;

			CompatGetter compatGetter = method.getAnnotation(CompatGetter.class);
			if (compatGetter != null) {
				builderClass.addMethod(generateMethodGetter(compatGetter, (ExecutableElement) method));
			}
		}
	}

	private MethodSpec generateMethodGetter(CompatGetter compatGetter, ExecutableElement method) {
		String fieldName = method.getSimpleName().toString().substring(4);
		VariableElement fieldMc = (VariableElement) findMcElement(fieldName, ElementKind.FIELD);

		MethodSpec.Builder builderMethod = MethodSpec.methodBuilder(method.getSimpleName().toString());
		builderMethod.returns(TypeName.get(fieldMc.asType()));
		builderMethod.addModifiers(Modifier.PUBLIC);
		if (compatClassType == CompatClassType.INTERFACE) {
			builderMethod.addModifiers(Modifier.ABSTRACT);
		} else {
			if (/* compatGetter.generation() == MethodGeneration.ONLY_CHILD && */ compatClassType == CompatClassType.PROXY) {
				builderMethod.addStatement("throw new RuntimeException(\"Invalid operation\")");
			} else {
				builderMethod.addStatement("return $N", fieldMc.getSimpleName());
			}
		}

		return builderMethod.build();
	}
}
