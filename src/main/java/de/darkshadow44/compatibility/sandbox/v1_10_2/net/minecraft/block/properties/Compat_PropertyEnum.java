package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public class Compat_PropertyEnum<T extends Enum<T> & IStringSerializable> extends Compat_PropertyHelper<T> {
	private PropertyEnum<T> original;
	private CompatI_PropertyEnum<T> thisReal;

	// When called from Mod
	public Compat_PropertyEnum() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyEnum.class, this), null);
	}

	// When called from child
	protected Compat_PropertyEnum(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyEnum(PropertyEnum<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PropertyEnum<T> thisReal, PropertyEnum<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public PropertyEnum<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
