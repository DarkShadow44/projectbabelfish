package darkshadow44.compatibility.core.asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassParser {

	public static class ConstantInfo {
		public byte tag;
		public String str;
		public int data1;
		public int data2;
	}

	public ConstantInfo[] constants;
	short this_class;
	short super_class;
	short[] interfaces;

	int pos_afterConstants = -1;

	public final static int CONSTANT_Utf8 = 1;
	public final static int CONSTANT_Integer = 3;
	public final static int CONSTANT_Float = 4;
	public final static int CONSTANT_Long = 5;
	public final static int CONSTANT_Double = 6;
	public final static int CONSTANT_Class = 7;
	public final static int CONSTANT_String = 8;
	public final static int CONSTANT_Fieldref = 9;
	public final static int CONSTANT_Methodref = 10;
	public final static int CONSTANT_InterfaceMethodref = 11;
	public final static int CONSTANT_NameAndType = 12;
	public final static int CONSTANT_MethodHandle = 15;
	public final static int CONSTANT_MethodType = 16;
	public final static int CONSTANT_InvokeDynamic = 18;

	byte[] classData;

	public void Parse(byte[] classData) {
		this.classData = classData;

		byte[] buffer = new byte[1024];
		DataInputStream inputstream = new DataInputStream(new ByteArrayInputStream(classData));

		try {
			inputstream.read(buffer, 0, 8);

			int constant_len = inputstream.readShort();
			this.constants = new ConstantInfo[constant_len];
			pos_afterConstants = 10;
			for (int i = 1; i < constant_len; i++) {
				ConstantInfo constant = new ConstantInfo();
				this.constants[i] = constant;
				constant.tag = inputstream.readByte();
				pos_afterConstants++;
				switch (constant.tag) {
				case CONSTANT_String:
				case CONSTANT_MethodType:
				case CONSTANT_Class:
					constant.data1 = inputstream.readShort();
					pos_afterConstants += 2;
					break;
				case CONSTANT_Fieldref:
				case CONSTANT_Methodref:
				case CONSTANT_InterfaceMethodref:
				case CONSTANT_InvokeDynamic:
				case CONSTANT_NameAndType:
					constant.data1 = inputstream.readShort();
					constant.data2 = inputstream.readShort();
					pos_afterConstants += 4;
					break;
				case CONSTANT_Integer:
				case CONSTANT_Float:
					constant.data1 = inputstream.readInt();
					pos_afterConstants += 4;
					break;
				case CONSTANT_Long:
				case CONSTANT_Double:
					constant.data1 = inputstream.readInt();
					constant.data2 = inputstream.readInt();
					pos_afterConstants += 8;
					i++;
					break;
				case CONSTANT_Utf8:
					int length = inputstream.readShort();
					inputstream.read(buffer, 0, length);
					constant.str = new String(buffer, 0, length, "UTF8");
					pos_afterConstants += 2 + length;
					break;
				case CONSTANT_MethodHandle:
					constant.data1 = inputstream.readByte();
					constant.data2 = inputstream.readShort();
					pos_afterConstants += 3;
					break;
				}
			}

			short access_flags = inputstream.readShort();
			this.this_class = inputstream.readShort();
			this.super_class = inputstream.readShort();

			int interface_len = inputstream.readShort();
			this.interfaces = new short[interface_len];
			for (int i = 0; i < interface_len; i++) {
				this.interfaces[i] = inputstream.readShort();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String GetSuperclass() {
		int classIndex = constants[super_class].data1;
		return constants[classIndex].str;
	}

	public String GetThisclass() {
		int classIndex = constants[this_class].data1;
		return constants[classIndex].str;
	}

	public byte[] GetData() {
		return classData;
	}

	public String[] GetInterfaces() {
		String[] ret = new String[interfaces.length];
		for (int i = 0; i < ret.length; i++)
		{
			int classIndex = constants[interfaces[i]].data1;
			ret[i] = constants[classIndex].str;
		}
		return ret;
	}

	public byte[] GetChangedClass() {
		byte[] buffer = new byte[1024];
		DataInputStream inputstream = new DataInputStream(new ByteArrayInputStream(classData));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		DataOutputStream outputstream = new DataOutputStream(output);

		try {
			inputstream.read(buffer, 0, 8);
			outputstream.write(buffer, 0, 8);
			outputstream.writeShort(constants.length);

			for (int i = 1; i < constants.length; i++) {
				ConstantInfo constant = constants[i];
				outputstream.writeByte(constant.tag);
				switch (constant.tag) {
				case CONSTANT_String:
				case CONSTANT_MethodType:
				case CONSTANT_Class:
					outputstream.writeShort(constant.data1);
					break;
				case CONSTANT_Fieldref:
				case CONSTANT_Methodref:
				case CONSTANT_InterfaceMethodref:
				case CONSTANT_InvokeDynamic:
				case CONSTANT_NameAndType:
					outputstream.writeShort(constant.data1);
					outputstream.writeShort(constant.data2);
					break;
				case CONSTANT_Integer:
				case CONSTANT_Float:
					outputstream.writeInt(constant.data1);
					break;
				case CONSTANT_Long:
				case CONSTANT_Double:
					outputstream.writeInt(constant.data1);
					outputstream.writeInt(constant.data2);
					i++;
					break;
				case CONSTANT_Utf8:
					byte[] newString = constant.str.getBytes("UTF8");
					outputstream.writeShort(newString.length);
					outputstream.write(newString);
					break;
				case CONSTANT_MethodHandle:
					outputstream.writeByte(constant.data1);
					outputstream.writeShort(constant.data2);
					break;
				}
			}

			buffer = new byte[pos_afterConstants];
			inputstream.read(buffer, 0, pos_afterConstants - 8);

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
