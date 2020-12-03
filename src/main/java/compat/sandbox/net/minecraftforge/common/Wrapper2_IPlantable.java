package compat.sandbox.net.minecraftforge.common;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class Wrapper2_IPlantable implements IPlantable {

	private final Compat_IPlantable original;

	public Wrapper2_IPlantable(Compat_IPlantable original) {
		this.original = original;
	}

	public Compat_IPlantable getFake() {
		return original;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		Compat_EnumPlantType result = original.getPlantType(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos));
		return result.getReal();
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		Compat_IBlockState result = original.getPlant(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos));
		return result.getReal();
	}

}
