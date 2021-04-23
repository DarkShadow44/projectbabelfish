package compat.sandbox.io.netty.buffer;

import io.netty.buffer.ByteBuf;

public interface CompatI_ByteBuf {
	public ByteBuf get();

	public byte[] arraySuper();

	public ByteBuf writeBooleanSuper(boolean value);

	public boolean readBooleanSuper();

	public ByteBuf writeFloatSuper(float value);

	public ByteBuf writeIntSuper(int value);

	public float readFloatSuper();

	public int readIntSuper();

	public ByteBuf writeLongSuper(long value);

	public long readLongSuper();

	public ByteBuf clearSuper();

	public ByteBuf writeMediumSuper(int value);

	public ByteBuf writeBytesSuper(byte[] value);

	public int readUnsignedMediumSuper();

	public ByteBuf readBytesSuper(byte[] data, int start, int len);

	public byte readByteSuper();

	public double readDoubleSuper();

	public ByteBuf writeByteSuper(int value);

	public ByteBuf writeDoubleSuper(double value);
}
