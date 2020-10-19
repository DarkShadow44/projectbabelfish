package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyHelper;

public class Compat_PropertyHelper<T extends Comparable<T>> implements Compat_IProperty<T> {
	private PropertyHelper<T> original;
	private CompatI_PropertyHelper<T> thisReal;

	// When called from Mod
	public Compat_PropertyHelper() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyHelper.class, this), null);
	}

	// When called from child
	protected Compat_PropertyHelper(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PropertyHelper(PropertyHelper<T> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PropertyHelper<T> thisReal, PropertyHelper<T> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public PropertyHelper<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
