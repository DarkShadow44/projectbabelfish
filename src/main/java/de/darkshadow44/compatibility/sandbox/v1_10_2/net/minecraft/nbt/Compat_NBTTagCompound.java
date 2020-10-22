package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import java.util.Set;

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

	public int Compat_func_74762_e(String key) {
		if (original == null)
			return thisReal.getIntegerSuper(key);
		else
			return original.getInteger(key);
	}

	public boolean Compat_func_74767_n(String key) {
		if (original == null)
			return thisReal.getBooleanSuper(key);
		else
			return original.getBoolean(key);
	}

	public Compat_NBTTagList Compat_func_150295_c(String key, int type) {
		if (original == null)
			return new Compat_NBTTagList(thisReal.getTagListSuper(key, type));
		else
			return new Compat_NBTTagList(original.getTagList(key, type));
	}

	public boolean Compat_func_74764_b(String key) {
		if (original == null)
			return thisReal.hasKeySuper(key);
		else
			return original.hasKey(key);
	}

	public Compat_NBTTagCompound Compat_func_74775_l(String key) {
		if (original == null)
			return new Compat_NBTTagCompound(thisReal.getCompoundTagSuper(key));
		else
			return new Compat_NBTTagCompound(original.getCompoundTag(key));
	}

	public Set<String> Compat_func_150296_c() {
		if (original == null)
			return thisReal.getKeySetSuper();
		else
			return original.getKeySet();
	}

	public byte Compat_func_74771_c(String key) {
		if (original == null)
			return thisReal.getByteSuper(key);
		else
			return original.getByte(key);
	}

	public Compat_NBTTagCompound Compat_func_74737_b() {
		if (original == null)
			return new Compat_NBTTagCompound(thisReal.copySuper());
		else
			return new Compat_NBTTagCompound(original.copy());
	}

	public String Compat_func_74779_i(String key) {
		if (original == null)
			return thisReal.getStringSuper(key);
		else
			return original.getString(key);
	}
}
