package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public class Compat_PropertyDirection extends Compat_PropertyEnum<EnumFacing> {
	private PropertyDirection original;
	private CompatI_PropertyDirection thisReal;

	// When called from Mod
	public Compat_PropertyDirection() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyDirection.class, this), null);
	}

	// When called from child
	protected Compat_PropertyDirection(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyDirection(PropertyDirection original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PropertyDirection thisReal, PropertyDirection original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public PropertyDirection getReal() {
		return original == null ? thisReal.get() : original;
	}
}
