package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyBool;

public class Compat_PropertyBool extends Compat_PropertyHelper<Boolean> {
	private PropertyBool original;
	private CompatI_PropertyBool thisReal;

	// When called from Mod
	public Compat_PropertyBool() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyBool.class, this), null);
	}

	// When called from child
	protected Compat_PropertyBool(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyBool(PropertyBool original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PropertyBool thisReal, PropertyBool original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public PropertyBool getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_PropertyBool Compat_func_177716_a(String p1) {
		return new Compat_PropertyBool(PropertyBool.create(p1));
	}
}
