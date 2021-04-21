package compat.sandbox.net.minecraft.block.properties;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.state.IntegerProperty;

public class Compat_PropertyInteger extends Compat_PropertyHelper<Integer> {
	private CompatI_PropertyInteger wrapper;

	// When called from Mod
	public Compat_PropertyInteger() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyInteger.class, this));
	}

	// When called from child
	protected Compat_PropertyInteger(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyInteger(IntegerProperty original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PropertyInteger.class, original));
	}

	protected void initialize(CompatI_PropertyInteger wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public IntegerProperty getReal() {
		return wrapper.get();
	}

	public static Compat_PropertyInteger Compat_func_177719_a(String p1, int p2, int p3) {
		return new Compat_PropertyInteger(IntegerProperty.create(p1, p2, p3));
	}
}
