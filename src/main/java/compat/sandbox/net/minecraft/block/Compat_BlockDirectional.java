package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import compat.sandbox.net.minecraft.block.properties.Compat_PropertyDirection;
import net.minecraft.block.BlockDirectional;

public class Compat_BlockDirectional extends Compat_Block {
	private CompatI_BlockDirectional wrapper;

	private static final Compat_PropertyDirection FACING = new Compat_PropertyDirection(BlockDirectional.FACING);

	// When called from Mod
	public Compat_BlockDirectional(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDirectional.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockDirectional(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDirectional(BlockDirectional original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDirectional.class, original));
	}

	protected void initialize(CompatI_BlockDirectional wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockDirectional getReal() {
		return wrapper.get();
	}

	public static Compat_PropertyDirection Compat_get_field_176387_N() {
		return FACING;
	}
}
