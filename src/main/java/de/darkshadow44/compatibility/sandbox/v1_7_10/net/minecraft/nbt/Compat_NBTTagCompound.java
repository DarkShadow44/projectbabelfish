package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.nbt;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.nbt.NBTTagCompound;

public class Compat_NBTTagCompound extends Compat_NBTBase {
	private CompatI_NBTTagCompound wrapper;

	// When called from Mod
	public Compat_NBTTagCompound() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_NBTTagCompound.class, this));
	}

	// When called from child
	protected Compat_NBTTagCompound(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NBTTagCompound(NBTTagCompound original) {
		this.initialize(Factory.createWrapper(CompatI_NBTTagCompound.class, original));
	}

	protected void initialize(CompatI_NBTTagCompound wrapper) {
		this.wrapper = wrapper;
	}

	public NBTTagCompound getReal() {
		return wrapper.get();
	}

	public String Compat_func_74779_i(String key) {

		return wrapper.getStringSuper(key);
	}
}
