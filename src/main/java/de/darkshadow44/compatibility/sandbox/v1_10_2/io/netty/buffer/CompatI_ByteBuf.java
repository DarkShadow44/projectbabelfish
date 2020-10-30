package de.darkshadow44.compatibility.sandbox.v1_10_2.io.netty.buffer;

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
}
