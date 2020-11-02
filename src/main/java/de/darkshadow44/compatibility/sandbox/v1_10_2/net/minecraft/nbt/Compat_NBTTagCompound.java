package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import java.util.Set;

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

	public void Compat_func_74768_a(String key, int value) {
		wrapper.setIntegerSuper(key, value);
	}

	public int Compat_func_74762_e(String key) {
		return wrapper.getIntegerSuper(key);
	}

	public boolean Compat_func_74767_n(String key) {
		return wrapper.getBooleanSuper(key);
	}

	public Compat_NBTTagList Compat_func_150295_c(String key, int type) {
		return new Compat_NBTTagList(wrapper.getTagListSuper(key, type));
	}

	public boolean Compat_func_74764_b(String key) {
		return wrapper.hasKeySuper(key);
	}

	public Compat_NBTTagCompound Compat_func_74775_l(String key) {
		return new Compat_NBTTagCompound(wrapper.getCompoundTagSuper(key));
	}

	public Set<String> Compat_func_150296_c() {
		return wrapper.getKeySetSuper();
	}

	public byte Compat_func_74771_c(String key) {
		return wrapper.getByteSuper(key);
	}

	public Compat_NBTTagCompound Compat_func_74737_b() {
		return new Compat_NBTTagCompound(wrapper.copySuper());
	}

	public String Compat_func_74779_i(String key) {
		return wrapper.getStringSuper(key);
	}

	public float Compat_func_74760_g(String key) {
		return wrapper.getFloatSuper(key);
	}

	public void Compat_func_74778_a(String key, String value) {
		wrapper.setStringSuper(key, value);
	}

	public void Compat_func_74776_a(String key, float value) {
		wrapper.setFloatSuper(key, value);
	}

	public void Compat_func_74782_a(String key, Compat_NBTBase value) {
		wrapper.setTagSuper(key, value.getReal());
	}

	public byte Compat_func_74732_a() {
		return wrapper.getIdSuper();
	}

	public void Compat_func_74773_a(String key, byte[] value) {
		wrapper.setByteArraySuper(key, value);
	}

	public byte[] Compat_func_74770_j(String key) {
		return wrapper.getByteArraySuper(key);
	}

	public void Compat_func_74757_a(String key, boolean value) {
		wrapper.setBooleanSuper(key, value);
	}

	public void Compat_func_74783_a(String key, int[] value) {
		wrapper.setIntArraySuper(key, value);
	}

	public int[] Compat_func_74759_k(String key) {
		return wrapper.getIntArraySuper(key);
	}
}
