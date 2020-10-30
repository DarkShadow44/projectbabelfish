package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import java.io.IOException;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.io.netty.buffer.Compat_ByteBuf;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class Compat_PacketBuffer extends Compat_ByteBuf {
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

	public ByteBuf Compat_writeFloat(float value) {
		if (original == null)
			return thisReal.writeFloatSuper(value);
		else
			return original.writeFloat(value);
	}

	public ByteBuf Compat_writeInt(int value) {
		if (original == null)
			return thisReal.writeIntSuper(value);
		else
			return original.writeInt(value);
	}

	public Compat_PacketBuffer Compat_func_150788_a(Compat_ItemStack stack) {
		if (original == null)
			thisReal.writeItemStackSuper(stack.getReal());
		else
			original.writeItemStack(stack.getReal());
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

	public Compat_ItemStack Compat_func_150791_c() throws IOException {
		ItemStack stack;
		if (original == null)
			stack = thisReal.readItemStackSuper();
		else
			stack = original.readItemStack();
		return new Compat_ItemStack(stack);
	}

}
