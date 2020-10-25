package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;

public class Compat_PacketBuffer {
	private PacketBuffer original;
	private CompatI_PacketBuffer thisReal;

	// When called from Mod
	public Compat_PacketBuffer(ByteBuf p1) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PacketBuffer.class, this, p1), null);
	}

	// When called from child
	protected Compat_PacketBuffer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PacketBuffer(PacketBuffer original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PacketBuffer thisReal, PacketBuffer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public PacketBuffer getReal() {
		return original == null ? thisReal.get() : original;
	}

	public byte[] Compat_array() {
		if (original == null)
			return thisReal.arraySuper();
		else
			return original.array();
	}

	public Compat_PacketBuffer Compat_func_179249_a(Enum<?> value) {
		if (original == null)
			thisReal.writeEnumValueSuper(value);
		else
			original.writeEnumValue(value);
		return this;
	}

	public ByteBuf Compat_writeBoolean(boolean value) {
		if (original == null)
			return thisReal.writeBooleanSuper(value);
		else
			return original.writeBoolean(value);
	}

	public Compat_PacketBuffer Compat_func_180714_a(String value) {
		if (original == null)
			thisReal.writeStringSuper(value);
		else
			original.writeString(value);
		return this;
	}

	public <T extends Enum<T>> T Compat_func_179257_a(Class<T> clazz) {
		if (original == null)
			return thisReal.readEnumValueSuper(clazz);
		else
			return original.readEnumValue(clazz);
	}

	public boolean Compat_readBoolean() {
		if (original == null)
			return thisReal.readBooleanSuper();
		else
			return original.readBoolean();
	}

	public String Compat_func_150789_c(int maxLength) {
		if (original == null)
			return thisReal.readStringSuper(maxLength);
		else
			return original.readString(maxLength);
	}
}
