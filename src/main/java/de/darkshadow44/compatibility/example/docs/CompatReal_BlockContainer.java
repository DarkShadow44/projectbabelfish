package de.darkshadow44.compatibility.example.docs;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CompatReal_BlockContainer extends BlockContainer implements CompatI_BlockContainer {
	private Compat_BlockContainer thisFake;

	public CompatReal_BlockContainer(Compat_BlockContainer thisFake, Material materialIn) {
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

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
