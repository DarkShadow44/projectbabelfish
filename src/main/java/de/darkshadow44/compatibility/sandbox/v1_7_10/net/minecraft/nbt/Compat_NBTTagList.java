package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.nbt;

import de.darkshadow44.compatibility.core.ParentSelector;

public class Compat_NBTTagList extends Compat_NBTBase {
	private NBTTagList original;
	private CompatI_NBTTagList thisReal;

	// When called from Mod
	public Compat_NBTTagList() {
		initialize(new CompatReal_NBTTagList(this), null);
	}

	// When called from child
	protected Compat_NBTTagList(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NBTTagList(NBTTagList original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_NBTTagList thisReal, NBTTagList original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public NBTTagList getReal() {
		return original == null ? thisReal.get() : original;
	}
}
