package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import java.io.IOException;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.io.netty.buffer.Compat_ByteBuf;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
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

}
