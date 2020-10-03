package de.darkshadow44.compatibility.example;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/*
 * How handle that BlockChest inherits from block?! interfaces...?
 * How handle inner classes?
 * How handle different interfaces? Inherit them?
 */
public class Compat_Block {

	private Block original;
	private CompatI_Block thisReal;

	// When called from 1.7.10,
	public Compat_Block(Material materialIn) {
		this.thisReal = new CompatReal_Block(this, materialIn);
	}

	// When called from child
	public Compat_Block() {
	}

	// When called from 1.12.2
	public Compat_Block(Block original) {
		this.original = original;
	}

	public void setThisReal(CompatI_Block thisReal) {
		this.thisReal = thisReal;
	}

	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		return Compat_isNormalCube(world, pos.getX(), pos.getY(), pos.getZ());
	}

	// Can be overridden by 1.7.10 mod
	public boolean Compat_isNormalCube(IBlockAccess world, int x, int y, int z) {
		if (original == null) // Owned by 1.7.10, when there is no override but 1.12.2 calls isNormalCube
			return thisReal.isNormalCubeSuper(world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z));
		else // When 1.7.10 calls to a block owned by 1.12.2
			return original.isNormalCube(world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z));
	}

}

/*
 * Cases:
 * 
 * Block owned by 1.7.10, then 1.7.10 calls Compat_isNormalCube but no overwrite is used -> must go to parent class
 * Block owned by 1.12.2, then 1.7.10 calls Compat_isNormalCube but no overwrite is used -> must go to wrapper class
 * Block owned by 1.7.10, then 1.12.2 calls isNormalCube        but no overwrite is used -> must go to parent class
 * Block owned by 1.7.10, then 1.12.2 calls isNormalCube        but    overwrite is used -> must go to 1.7.10 class
 * 
 * Invalid cases:
 * 
 * Block owned by 1.12.2, then 1.12.2 calls isNormalCube -> we don't come into play here, 1.12.2 never gets our instances
 * Block owned by 1.7.10, then 1.7.10 calls Compat_isNormalCube but overwrite is used -> we don't come into play here
 * Block owned by 1.12.2, then 1.7.10 calls Compat_isNormalCube but overwrite is used -> impossible
 */