package compat.sandbox.net.minecraft.block.properties;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.IStringSerializable;

public class Compat_PropertyEnum<T extends Enum<T> & IStringSerializable> extends Compat_PropertyHelper<T> {
	private CompatI_PropertyEnum<T> wrapper;

	// When called from Mod
	public Compat_PropertyEnum() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyEnum.class, this));
	}

	// When called from child
	protected Compat_PropertyEnum(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyEnum(EnumProperty<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PropertyEnum.class, original));
	}

	protected void initialize(CompatI_PropertyEnum<T> wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EnumProperty<T> getReal() {
		return wrapper.get();
	}

	public static <T extends Enum<T> & IStringSerializable> Compat_PropertyEnum<T> Compat_func_177709_a(String p1, Class<T> p2) {
		return new Compat_PropertyEnum<T>(EnumProperty.create(p1, p2)); // TODO is class correct?
	}
}
