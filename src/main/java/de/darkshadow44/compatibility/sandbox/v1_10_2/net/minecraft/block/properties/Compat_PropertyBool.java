package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyBool;

public class Compat_PropertyBool extends Compat_PropertyHelper<Boolean> {
	private CompatI_PropertyBool wrapper;

	// When called from Mod
	public Compat_PropertyBool() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyBool.class, this));
	}

	// When called from child
	protected Compat_PropertyBool(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyBool(PropertyBool original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PropertyBool.class, original));
	}

	protected void initialize(CompatI_PropertyBool wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PropertyBool getReal() {
		return wrapper.get();
	}

	public static Compat_PropertyBool Compat_func_177716_a(String p1) {
		return new Compat_PropertyBool(PropertyBool.create(p1));
	}
}
