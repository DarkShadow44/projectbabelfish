package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_PropertyDirection;
import net.minecraft.block.BlockDirectional;

public class Compat_BlockDirectional extends Compat_Block {
	private BlockDirectional original;
	private CompatI_BlockDirectional thisReal;

	private static final Compat_PropertyDirection FACING = new Compat_PropertyDirection(BlockDirectional.FACING);

	// When called from Mod
	public Compat_BlockDirectional(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDirectional.class, this, material.getReal()), null);

		workaround_init();
	}

	// When called from child
	protected Compat_BlockDirectional(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDirectional(BlockDirectional original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockDirectional thisReal, BlockDirectional original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockDirectional getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_PropertyDirection Compat_get_field_176387_N() {
		return FACING;
	}
}
