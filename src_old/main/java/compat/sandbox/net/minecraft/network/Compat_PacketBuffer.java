package compat.sandbox.net.minecraft.network;

import java.io.IOException;
import java.util.UUID;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.io.netty.buffer.Compat_ByteBuf;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.nbt.Compat_NBTTagCompound;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class Compat_PacketBuffer extends Compat_ByteBuf {
	private CompatI_PacketBuffer wrapper;

	// When called from Mod
	public Compat_PacketBuffer(Compat_ByteBuf p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PacketBuffer.class, this, p1.getReal()));
	}

	// When called from child
	protected Compat_PacketBuffer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PacketBuffer(PacketBuffer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PacketBuffer.class, original));
	}

	protected void initialize(CompatI_PacketBuffer wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PacketBuffer getReal() {
		return wrapper.get();
	}

	public Compat_PacketBuffer Compat_func_179249_a(Enum<?> value) {
		wrapper.writeEnumValueSuper(value);
		return this;
	}

	public Compat_PacketBuffer Compat_func_180714_a(String value) {
		wrapper.writeStringSuper(value);
		return this;
	}

	public <T extends Enum<T>> T Compat_func_179257_a(Class<T> clazz) {
		return wrapper.readEnumValueSuper(clazz);
	}

	public String Compat_func_150789_c(int maxLength) {
		return wrapper.readStringSuper(maxLength);
	}

	public Compat_PacketBuffer Compat_func_150788_a(Compat_ItemStack stack) {
		wrapper.writeItemStackSuper(stack.getReal());
		return this;
	}

	public Compat_ItemStack Compat_func_150791_c() throws IOException {
		ItemStack result = wrapper.readItemStackSuper();
		return new Compat_ItemStack(result);
	}

	public Compat_PacketBuffer Compat_func_150786_a(Compat_NBTTagCompound tag) {
		wrapper.writeCompoundTagSuper(tag.getReal());
		return this;
	}

	public Compat_NBTTagCompound Compat_func_150793_b() throws IOException {
		return new Compat_NBTTagCompound(wrapper.readCompoundTagSuper());
	}

	public Compat_PacketBuffer Compat_func_179250_a(byte[] value) {
		wrapper.writeByteArraySuper(value);
		return this;
	}

	public byte[] Compat_func_179251_a() {
		return wrapper.readByteArraySuper();
	}

	public Compat_PacketBuffer Compat_func_179252_a(UUID uuid) {
		wrapper.writeUniqueIdSuper(uuid);
		return this;
	}

	public UUID Compat_func_179253_g() {
		return wrapper.readUniqueIdSuper();
	}

	public Compat_PacketBuffer Compat_func_179255_a(Compat_BlockPos pos) {
		wrapper.writeBlockPosSuper(pos.getReal());
		return this;
	}

	public Compat_BlockPos Compat_func_179259_c() {
		return new Compat_BlockPos(wrapper.readBlockPosSuper());
	}

	public int[] Compat_func_186863_b() {
		return wrapper.readVarIntArraySuper();
	}

	public Compat_PacketBuffer Compat_func_186875_a(int[] value) {
		wrapper.writeVarIntArraySuper(value);
		return this;
	}

}
