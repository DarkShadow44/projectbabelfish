package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Compat_Block extends Block {

	// When object owned by 1.12, this contains the original. When owned by 1.7.10 it is null.
	private Block original; // Original is never an instance from us!

	// When passing down, make a copy
	public Compat_Block(Block original) {
		super(Material.AIR);
		this.original = original;
	}
	
	// When called from 1.7.10, 
	public Compat_Block(Material materialIn)
	{
		super(materialIn);
	}
	
	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		if (original == null) // Owned by 1.7.10
			return Compat_isNormalCube(world, pos.getX(), pos.getY(), pos.getZ());
		else
			return super.isNormalCube(state, world, pos);
	}

	// Can be overriden by 1.7.10 mod
	public boolean Compat_isNormalCube(IBlockAccess world, int x, int y, int z) {
		if (original == null) // Owned by 1.7.10
			return super.isNormalCube(world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z));
		else
			return original.isNormalCube(world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z));
	}

}

/*
 * Cases:
 * 
 * Block owned by 1.7.10, then 1.7.10 calls Compat_isNormalCube but no overwrite is used -> must go to parent class
 * Block owned by 1.12.2, then 1.7.10 calls Compat_isNormalCube but no overwrite is used  -> must go to wrapper class
 * Block owned by 1.7.10, then 1.12.2 calls isNormalCube but no overwrite is used -> must go to parent class
 * Block owned by 1.7.10, then 1.12.2 calls isNormalCube but    overwrite is used -> must go to 1.7.10 class
 * 
 * Invalid cases:
 * 
 *  Block owned by 1.12.2, then 1.12.2 calls isNormalCube - we don't come into play here, 1.12 never gets our instances
 *  Block owned by 1.7.10, then 1.7.10 calls Compat_isNormalCube but overwrite is used - we don't come into play here
 *  Block owned by 1.12.2, then 1.7.10 calls Compat_isNormalCube but overwrite is used  -> impossible
 */