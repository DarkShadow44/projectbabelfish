package de.darkshadow44.compatibility.sandbox.v1_10_2.io.netty.buffer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import io.netty.buffer.ByteBuf;

public class Compat_ByteBuf {
	private ByteBuf original;
	private CompatI_ByteBuf thisReal;

	// When called from Mod
	public Compat_ByteBuf() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ByteBuf.class, this), null);
	}

	// When called from child
	protected Compat_ByteBuf(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ByteBuf(ByteBuf original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ByteBuf thisReal, ByteBuf original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ByteBuf getReal() {
		return original == null ? thisReal.get() : original;
	}

	public byte[] Compat_array() {
		if (original == null)
			return thisReal.arraySuper();
		else
			return original.array();
	}

	public Compat_ByteBuf Compat_writeBoolean(boolean value) {
		if (original == null)
			thisReal.writeBooleanSuper(value);
		else
			original.writeBoolean(value);
		return this;
	}

	public boolean Compat_readBoolean() {
		if (original == null)
			return thisReal.readBooleanSuper();
		else
			return original.readBoolean();
	}

	public Compat_ByteBuf Compat_writeFloat(float value) {
		if (original == null)
			thisReal.writeFloatSuper(value);
		else
			original.writeFloat(value);
		return this;
	}

	public Compat_ByteBuf Compat_writeInt(int value) {
		if (original == null)
			thisReal.writeIntSuper(value);
		else
			original.writeInt(value);
		return this;
	}

	public float Compat_readFloat() {
		if (original == null)
			return thisReal.readFloatSuper();
		else
			return original.readFloat();
	}

	public int Compat_readInt() {
		if (original == null)
			return thisReal.readIntSuper();
		else
			return original.readInt();
	}

	public Compat_ByteBuf Compat_writeLong(long value) {
		if (original == null)
			thisReal.writeLongSuper(value);
		else
			original.writeLong(value);
		return this;
	}

	public long Compat_readLong() {
		if (original == null)
			return thisReal.readLongSuper();
		else
			return original.readLong();
	}

	public Compat_ByteBuf Compat_clear() {
		if (original == null)
			thisReal.clearSuper();
		else
			original.clear();
		return this;
	}

	public Compat_ByteBuf Compat_writeMedium(int value) {
		if (original == null)
			thisReal.writeMediumSuper(value);
		else
			original.writeMedium(value);
		return this;
	}

	public Compat_ByteBuf Compat_writeBytes(byte[] value) {
		if (original == null)
			thisReal.writeBytesSuper(value);
		else
			original.writeBytes(value);
		return this;
	}

	public int Compat_readUnsignedMedium() {
		if (original == null)
			return thisReal.readUnsignedMediumSuper();
		else
			return original.readUnsignedMedium();
	}

	public Compat_ByteBuf Compat_readBytes(byte[] data, int start, int len) {
		if (original == null)
			thisReal.readBytesSuper(data, start, len);
		else
			original.readBytes(data, start, len);
		return this;
	}

}
