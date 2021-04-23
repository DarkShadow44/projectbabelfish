package compat.sandbox.io.netty.buffer;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import io.netty.buffer.ByteBuf;

public class Compat_ByteBuf {
	private CompatI_ByteBuf wrapper;

	// When called from Mod
	public Compat_ByteBuf() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ByteBuf.class, this));
	}

	// When called from child
	protected Compat_ByteBuf(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ByteBuf(ByteBuf original) {
		this.initialize(Factory.createWrapper(CompatI_ByteBuf.class, original));
	}

	protected void initialize(CompatI_ByteBuf wrapper) {
		this.wrapper = wrapper;
	}

	public ByteBuf getReal() {
		return wrapper.get();
	}

	public byte[] Compat_array() {
		return wrapper.arraySuper();
	}

	public Compat_ByteBuf Compat_writeBoolean(boolean value) {
		wrapper.writeBooleanSuper(value);
		return this;
	}

	public boolean Compat_readBoolean() {
		return wrapper.readBooleanSuper();
	}

	public Compat_ByteBuf Compat_writeFloat(float value) {
		wrapper.writeFloatSuper(value);
		return this;
	}

	public Compat_ByteBuf Compat_writeInt(int value) {
		wrapper.writeIntSuper(value);
		return this;
	}

	public float Compat_readFloat() {
		return wrapper.readFloatSuper();
	}

	public int Compat_readInt() {
		return wrapper.readIntSuper();
	}

	public Compat_ByteBuf Compat_writeLong(long value) {
		wrapper.writeLongSuper(value);
		return this;
	}

	public long Compat_readLong() {
		return wrapper.readLongSuper();
	}

	public Compat_ByteBuf Compat_clear() {
		wrapper.clearSuper();
		return this;
	}

	public Compat_ByteBuf Compat_writeMedium(int value) {
		wrapper.writeMediumSuper(value);
		return this;
	}

	public Compat_ByteBuf Compat_writeBytes(byte[] value) {
		wrapper.writeBytesSuper(value);
		return this;
	}

	public int Compat_readUnsignedMedium() {
		return wrapper.readUnsignedMediumSuper();
	}

	public Compat_ByteBuf Compat_readBytes(byte[] data, int start, int len) {
		wrapper.readBytesSuper(data, start, len);
		return this;
	}

	public byte Compat_readByte() {
		return wrapper.readByteSuper();
	}

	public double Compat_readDouble() {
		return wrapper.readDoubleSuper();
	}

	public Compat_ByteBuf Compat_writeByte(int value) {
		wrapper.writeByteSuper(value);
		return this;
	}

	public Compat_ByteBuf Compat_writeDouble(double value) {
		wrapper.writeDoubleSuper(value);
		return this;
	}

}
