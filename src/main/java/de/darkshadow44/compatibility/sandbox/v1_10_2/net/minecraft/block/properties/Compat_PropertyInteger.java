package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyInteger;

public class Compat_PropertyInteger extends Compat_PropertyHelper<Integer> {
	private PropertyInteger original;
	private CompatI_PropertyInteger thisReal;

	// When called from Mod
	public Compat_PropertyInteger() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyInteger.class, this), null);
	}

	// When called from child
	protected Compat_PropertyInteger(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyInteger(PropertyInteger original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PropertyInteger thisReal, PropertyInteger original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public PropertyInteger getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_PropertyInteger Compat_func_177719_a(String p1, int p2, int p3) {
		return new Compat_PropertyInteger(PropertyInteger.create(p1, p2, p3));
	}
}
