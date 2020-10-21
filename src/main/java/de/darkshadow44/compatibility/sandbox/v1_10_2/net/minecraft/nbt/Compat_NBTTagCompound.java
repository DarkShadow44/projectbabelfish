package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.nbt.NBTTagCompound;

public class Compat_NBTTagCompound extends Compat_NBTBase {
	private NBTTagCompound original;
	private CompatI_NBTTagCompound thisReal;

	// When called from Mod
	public Compat_NBTTagCompound() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_NBTTagCompound.class, this), null);
	}

	// When called from child
	protected Compat_NBTTagCompound(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NBTTagCompound(NBTTagCompound original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_NBTTagCompound thisReal, NBTTagCompound original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public NBTTagCompound getReal() {
		return original == null ? thisReal.get() : original;
	}

	public void Compat_func_74768_a(String key, int value) {
		if (original == null)
			thisReal.setIntegerSuper(key, value);
		else
			original.setInteger(key, value);
	}
}
