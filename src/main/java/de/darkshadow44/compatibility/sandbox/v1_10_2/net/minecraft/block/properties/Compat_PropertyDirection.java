package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public class Compat_PropertyDirection extends Compat_PropertyEnum<EnumFacing> {
	private CompatI_PropertyDirection wrapper;

	// When called from Mod
	public Compat_PropertyDirection() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyDirection.class, this));
	}

	// When called from child
	protected Compat_PropertyDirection(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PropertyDirection(PropertyDirection original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PropertyDirection.class, original));
	}

	protected void initialize(CompatI_PropertyDirection wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PropertyDirection getReal() {
		return wrapper.get();
	}
}
