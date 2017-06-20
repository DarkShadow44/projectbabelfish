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

import scala.Console;

public class ClassConstantTransformer {
	final int CONSTANT_Class = 7;
	final int CONSTANT_Fieldref = 9;
	final int CONSTANT_Methodref = 10;
	final int CONSTANT_InterfaceMethodref = 11;
	final int CONSTANT_String = 8;
	final int CONSTANT_Integer = 3;
	final int CONSTANT_Float = 4;
	final int CONSTANT_Long = 5;
	final int CONSTANT_Double = 6;
	final int CONSTANT_NameAndType = 12;
	final int CONSTANT_Utf8 = 1;
	final int CONSTANT_MethodHandle = 15;
	final int CONSTANT_MethodType = 16;
	final int CONSTANT_InvokeDynamic = 18;

	String classPrefix = "darkshadow44/compatibility/version/v1_2_5/sandbox/";

	boolean IsException(String name) {
		if (name.startsWith("java/"))
			return true;

		return false;
	}

	String TransformNormal(String desc) {
		if (desc.startsWith("["))
			return TransformDescriptor(desc);

		if (!IsException(desc))
			return classPrefix + desc;

		return desc;
	}

	String TransformDescriptor(String desc) {
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
				if (!IsException(substr))
					sb.append(classPrefix);
				sb.append(substr);
				sb.append(';');
				break;

			}
		}
		return sb.toString();

	}

	public byte[] TransformClass(byte[] data) {
		try {
			DataInputStream inputstream = new DataInputStream(new ByteArrayInputStream(data));
			byte[] buffer = new byte[1024];

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			DataOutputStream outputstream = new DataOutputStream(output);

			inputstream.mark(0);
			inputstream.read(buffer, 0, 8);

			int constantLength = inputstream.readShort();

			List<Integer> utf8_check = new ArrayList<Integer>();
			List<Integer> utf8_check_descriptor = new ArrayList<Integer>();
			HashMap<Integer, String> utf8 = new HashMap<Integer, String>();

			for (int i = 1; i < constantLength; i++) {
				int tag = inputstream.readByte();
				int length;
				switch (tag) {
				case CONSTANT_Class:
					utf8_check.add((int) inputstream.readShort());
					break;
				case CONSTANT_Fieldref:
				case CONSTANT_Methodref:
				case CONSTANT_InterfaceMethodref:
					inputstream.readShort();
					inputstream.readShort();
					break;
				case CONSTANT_String:
					inputstream.readShort();
					break;
				case CONSTANT_Integer:
				case CONSTANT_Float:
					inputstream.readInt();
					break;
				case CONSTANT_Long:
				case CONSTANT_Double:
					inputstream.readLong();
					i++;
					break;
				case CONSTANT_NameAndType:
					inputstream.readShort();
					utf8_check_descriptor.add((int) inputstream.readShort());
					break;
				case CONSTANT_Utf8:
					length = inputstream.readShort();
					inputstream.read(buffer, 0, length);
					utf8.put(i, new String(buffer, 0, length, "UTF8"));
					Console.out().println(new String(buffer, 0, length, "UTF8"));
					break;
				case CONSTANT_MethodHandle:
					inputstream.readByte();
					inputstream.readShort();
					break;
				case CONSTANT_MethodType:
					utf8_check_descriptor.add((int) inputstream.readShort());
					break;
				case CONSTANT_InvokeDynamic:
					inputstream.readShort();
					inputstream.readShort();
					break;
				}
			}

			utf8_check = utf8_check.stream().distinct().collect(Collectors.toList());
			utf8_check_descriptor = utf8_check_descriptor.stream().distinct().collect(Collectors.toList());

			Console.out().println("Normal:");
			for (int i : utf8_check) {
				String str = utf8.get(i);
				Console.out().println("Before:");
				Console.out().println(str);
				str = TransformNormal(str);
				Console.out().println("After:");
				Console.out().println(str);
				utf8.put(i, str);
			}
			Console.out().println("Descriptor:");
			for (int i : utf8_check_descriptor) {
				String str = utf8.get(i);
				Console.out().println("Before:");
				Console.out().println(str);
				str = TransformDescriptor(str);
				Console.out().println("After:");
				Console.out().println(str);
				utf8.put(i, str);
			}

			inputstream.reset();

			inputstream.read(buffer, 0, 10);
			outputstream.write(buffer, 0, 10);

			for (int i = 1; i < constantLength; i++) {
				int tag = inputstream.readByte();
				outputstream.writeByte(tag);

				int length;
				byte[] newStr;
				switch (tag) {

				case CONSTANT_Fieldref:
				case CONSTANT_Methodref:
				case CONSTANT_InterfaceMethodref:
				case CONSTANT_NameAndType:
				case CONSTANT_Integer:
				case CONSTANT_Float:
				case CONSTANT_InvokeDynamic:
					inputstream.read(buffer, 0, 4);
					outputstream.write(buffer, 0, 4);
					break;
				case CONSTANT_String:
				case CONSTANT_Class:
				case CONSTANT_MethodType:
					inputstream.read(buffer, 0, 2);
					outputstream.write(buffer, 0, 2);
					break;
				case CONSTANT_Long:
				case CONSTANT_Double:
					inputstream.read(buffer, 0, 8);
					outputstream.write(buffer, 0, 8);
					i++;
					break;
				case CONSTANT_Utf8:
					length = inputstream.readShort();
					inputstream.read(buffer, 0, length);
					newStr = utf8.get(i).getBytes("UTF8");
					outputstream.writeShort(newStr.length);
					outputstream.write(newStr);
					break;
				case CONSTANT_MethodHandle:
					inputstream.read(buffer, 0, 3);
					outputstream.write(buffer, 0, 3);
					break;
				}
			}
			int count;
			while ((count = inputstream.read(buffer)) > 0) {
				outputstream.write(buffer, 0, count);
			}

			outputstream.flush();
			return output.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
