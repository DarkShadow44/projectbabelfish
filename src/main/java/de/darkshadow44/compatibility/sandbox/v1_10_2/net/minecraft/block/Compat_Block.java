package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class Compat_Block {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this, material.getReal()), null);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_AxisAlignedBB Compat_get_field_185505_j() {
		return new Compat_AxisAlignedBB(Block.FULL_BLOCK_AABB);
	}

	public Compat_IBlockState Compat_func_176223_P() {
		IBlockState state;
		if (original == null)
			state = thisReal.getDefaultStateSuper();
		else
			state = original.getDefaultState();

		return new Wrapper_IBlockState(state);
	}
}
