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

	public static class FieldMethodInfo {
		public short access_flags;
		public short name_index;
		public short descriptor_index;
		AttributeInfo[] attributes;
	}

	public static class AttributeInfo {
		public short attribute_name_index;
		public byte[] info;
	}

	byte[] classData;

	int magic;
	short minor_version;
	short major_version;
	public ConstantInfo[] constants;
	short access_flags;
	short this_class;
	short super_class;
	short[] interfaces;
	public FieldMethodInfo[] fields;
	public FieldMethodInfo[] methods;
	AttributeInfo[] attributes;

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

	AttributeInfo[] ParseAttributeInfo(DataInputStream inputstream) throws IOException {
		int info_len = inputstream.readShort();
		AttributeInfo[] info = new AttributeInfo[info_len];

		for (int i = 0; i < info_len; i++) {
			AttributeInfo attribute = new AttributeInfo();
			info[i] = attribute;

			attribute.attribute_name_index = inputstream.readShort();
			int attribute_length = inputstream.readInt();
			attribute.info = new byte[attribute_length];
			inputstream.read(attribute.info, 0, attribute.info.length);
		}
		return info;
	}

	FieldMethodInfo[] ParseFieldMethodInfo(DataInputStream inputstream) throws IOException {
		int info_len = inputstream.readShort();
		FieldMethodInfo[] info = new FieldMethodInfo[info_len];
		for (int i = 0; i < info_len; i++) {
			FieldMethodInfo entry = new FieldMethodInfo();
			info[i] = entry;

			entry.access_flags = inputstream.readShort();
			entry.name_index = inputstream.readShort();
			entry.descriptor_index = inputstream.readShort();
			entry.attributes = ParseAttributeInfo(inputstream);
		}
		return info;
	}

	public void Parse(byte[] classData) {
		this.classData = classData;
		byte[] buffer = new byte[1024];
		DataInputStream inputstream = new DataInputStream(new ByteArrayInputStream(classData));

		try {
			this.magic = inputstream.readInt();
			this.minor_version = inputstream.readShort();
			this.major_version = inputstream.readShort();

			int constant_len = inputstream.readShort();
			this.constants = new ConstantInfo[constant_len];
			for (int i = 1; i < constant_len; i++) {
				ConstantInfo constant = new ConstantInfo();
				this.constants[i] = constant;
				constant.tag = inputstream.readByte();
				switch (constant.tag) {
				case CONSTANT_String:
				case CONSTANT_MethodType:
				case CONSTANT_Class:
					constant.data1 = inputstream.readShort();
					break;
				case CONSTANT_Fieldref:
				case CONSTANT_Methodref:
				case CONSTANT_InterfaceMethodref:
				case CONSTANT_InvokeDynamic:
				case CONSTANT_NameAndType:
					constant.data1 = inputstream.readShort();
					constant.data2 = inputstream.readShort();
					break;
				case CONSTANT_Integer:
				case CONSTANT_Float:
					constant.data1 = inputstream.readInt();
					break;
				case CONSTANT_Long:
				case CONSTANT_Double:
					constant.data1 = inputstream.readInt();
					constant.data2 = inputstream.readInt();
					i++;
					break;
				case CONSTANT_Utf8:
					int length = inputstream.readShort();
					inputstream.read(buffer, 0, length);
					constant.str = new String(buffer, 0, length, "UTF8");
					break;
				case CONSTANT_MethodHandle:
					constant.data1 = inputstream.readByte();
					constant.data2 = inputstream.readShort();
					break;
				}
			}

			this.access_flags = inputstream.readShort();
			this.this_class = inputstream.readShort();
			this.super_class = inputstream.readShort();

			int interface_len = inputstream.readShort();
			this.interfaces = new short[interface_len];
			for (int i = 0; i < interface_len; i++) {
				this.interfaces[i] = inputstream.readShort();
			}

			this.fields = ParseFieldMethodInfo(inputstream);
			this.methods = ParseFieldMethodInfo(inputstream);
			this.attributes = ParseAttributeInfo(inputstream);
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
		for (int i = 0; i < ret.length; i++) {
			int classIndex = constants[interfaces[i]].data1;
			ret[i] = constants[classIndex].str;
		}
		return ret;
	}

	void WriteAttributeInfo(DataOutputStream outputstream, AttributeInfo[] info) throws IOException {
		outputstream.writeShort(info.length);
		for (int i = 0; i < info.length; i++) {
			AttributeInfo attribute = info[i];

			outputstream.writeShort(attribute.attribute_name_index);
			outputstream.writeInt(attribute.info.length);
			outputstream.write(attribute.info, 0, attribute.info.length);
		}
	}

	void WriteFieldMethodInfo(DataOutputStream outputstream, FieldMethodInfo[] info) throws IOException {
		outputstream.writeShort(info.length);
		for (int i = 0; i < info.length; i++) {
			FieldMethodInfo entry = info[i];

			outputstream.writeShort(entry.access_flags);
			outputstream.writeShort(entry.name_index);
			outputstream.writeShort(entry.descriptor_index);
			WriteAttributeInfo(outputstream, entry.attributes);
		}
	}

	public byte[] GetChangedClass() {
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		DataOutputStream outputstream = new DataOutputStream(output);

		try {
			outputstream.writeInt(this.magic);
			outputstream.writeShort(this.minor_version);
			outputstream.writeShort(this.major_version);

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

			outputstream.writeShort(this.access_flags);
			outputstream.writeShort(this.this_class);
			outputstream.writeShort(this.super_class);

			outputstream.writeShort(this.interfaces.length);
			for (int i = 0; i < this.interfaces.length; i++) {
				outputstream.writeShort(this.interfaces[i]);
			}

			WriteFieldMethodInfo(outputstream, this.fields);
			WriteFieldMethodInfo(outputstream, this.methods);
			WriteAttributeInfo(outputstream, this.attributes);

			outputstream.flush();
			return output.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
