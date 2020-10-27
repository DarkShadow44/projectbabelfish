package de.darkshadow44.compatibility.example.docs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CompatReal_Block extends Block implements CompatI_Block {

	private final Compat_Block thisFake;

	public CompatReal_Block(Compat_Block thisFake, Material materialIn) {
		super(materialIn);
		this.thisFake = thisFake;
	}

	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		return thisFake.isNormalCube(state, world, pos);
	}

	public boolean isNormalCubeSuper(IBlockState state, IBlockAccess world, BlockPos pos) {
		return super.isNormalCube(state, world, pos);
	}
}
