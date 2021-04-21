package compat.sandbox.net.minecraft.block.properties;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.state.DirectionProperty;
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
	public Compat_PropertyDirection(DirectionProperty original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PropertyDirection.class, original));
	}

	protected void initialize(CompatI_PropertyDirection wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public DirectionProperty getReal() {
		return wrapper.get();
	}
}
