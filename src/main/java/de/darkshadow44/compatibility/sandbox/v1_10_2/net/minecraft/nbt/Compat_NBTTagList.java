package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.nbt.NBTTagList;

public class Compat_NBTTagList extends Compat_NBTBase {
	private CompatI_NBTTagList wrapper;

	// When called from Mod
	public Compat_NBTTagList() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_NBTTagList.class, this));
	}

	// When called from child
	protected Compat_NBTTagList(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NBTTagList(NBTTagList original) {
		this.initialize(Factory.createWrapper(CompatI_NBTTagList.class, original));
	}

	protected void initialize(CompatI_NBTTagList wrapper) {
		this.wrapper = wrapper;
	}

	public NBTTagList getReal() {
		return wrapper.get();
	}

	public Compat_NBTTagCompound Compat_func_150305_b(int index) {
		return new Compat_NBTTagCompound(wrapper.getCompoundTagAtSuper(index));
	}

	public void Compat_func_74742_a(Compat_NBTBase tag) {
		wrapper.appendTagSuper(tag.getReal());
	}

	public int Compat_func_74745_c() {
		return wrapper.tagCountSuper();
	}
}
