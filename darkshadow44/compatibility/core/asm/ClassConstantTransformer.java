package darkshadow44.compatibility.core.asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.primitives.Bytes;

import darkshadow44.compatibility.core.asm.ClassParser.ConstantInfo;
import darkshadow44.compatibility.core.asm.ClassParser.FieldMethodInfo;
import scala.Console;

public class ClassConstantTransformer {

	TransformConfig transformConfig;

	public ClassConstantTransformer(TransformConfig transformConfig) {
		this.transformConfig = transformConfig;
	}

	String TransformNormal(String desc, List<String> outDependencies) {
		if (desc.startsWith("["))
			return TransformDescriptor(desc, outDependencies);

		if (!transformConfig.IsException(desc)) {
			desc = transformConfig.GetPrefix() + desc;
			outDependencies.add(desc);
		}

		return desc;
	}

	String TransformDescriptor(String desc, List<String> outDependencies) {
		if (desc == null) {
			return null;
		}
		String substr;
		int posOld;
		StringBuilder sb = new StringBuilder();
		List<String> parts = new ArrayList<String>();
		for (int pos = 0; pos < desc.length(); pos++) {
			switch (desc.charAt(pos)) {
			case 'B':
			case 'C':
			case 'D':
			case 'F':
			case 'I':
			case 'J':
			case 'S':
			case 'V':
			case 'Z':
			case '[':
			case '(':
			case ')':
				sb.append(desc.charAt(pos));
				break;
			case 'L':
				sb.append(desc.charAt(pos));
				posOld = pos + 1;
				while (desc.charAt(pos) != ';')
					pos++;
				substr = desc.substring(posOld, pos);
				if (!transformConfig.IsException(substr)) {
					outDependencies.add(transformConfig.GetPrefix() + substr);
					sb.append(transformConfig.GetPrefix());
				}
				sb.append(substr);
				sb.append(';');
				break;

			}
		}
		return sb.toString();
	}

	byte[] TransformAndGetDependencies(byte[] data, List<String> outDependencies) {

		ClassParser parser = new ClassParser();
		parser.Parse(data);

		List<Integer> check_normal = new ArrayList<Integer>();
		List<Integer> check_descriptor = new ArrayList<Integer>();

		for (int i = 1; i < parser.constants.length; i++) {
			ConstantInfo constant = parser.constants[i];
			switch (constant.tag) {
			case ClassParser.CONSTANT_Class:
				check_normal.add(constant.data1);
				break;
			case ClassParser.CONSTANT_Long:
			case ClassParser.CONSTANT_Double:
				i++;
				break;
			case ClassParser.CONSTANT_NameAndType:
				check_descriptor.add(constant.data2);
				break;
			case ClassParser.CONSTANT_MethodType:
				check_descriptor.add(constant.data1);
				break;
			}
		}

		for (FieldMethodInfo field : parser.fields)
			check_descriptor.add((int) field.descriptor_index);

		for (FieldMethodInfo method : parser.methods)
			check_descriptor.add((int) method.descriptor_index);

		check_normal = check_normal.stream().distinct().collect(Collectors.toList());
		check_descriptor = check_descriptor.stream().distinct().collect(Collectors.toList());

		for (int i : check_normal) {
			String str = parser.constants[i].str;
			str = TransformNormal(str, outDependencies);
			parser.constants[i].str = str;
		}
		for (int i : check_descriptor) {
			String str = parser.constants[i].str;
			str = TransformDescriptor(str, outDependencies);
			parser.constants[i].str = str;
		}

		List<String> outDependenciesDedup = outDependencies.stream().distinct().collect(Collectors.toList());
		outDependencies.clear();
		outDependencies.addAll(outDependenciesDedup);

		return parser.GetChangedClass();
	}

}
