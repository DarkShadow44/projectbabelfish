package compat.sandbox.net.minecraftforge.common;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class Wrapper_IPlantable implements Compat_IPlantable {
	private final IPlantable original;

	public Wrapper_IPlantable(IPlantable original) {
		this.original = original;
	}

	public IPlantable getReal() {
		return original;
	}

	@Override
	public Compat_EnumPlantType getPlantType(Compat_IBlockAccess world, Compat_BlockPos pos) {
		EnumPlantType result = original.getPlantType(world.getReal(), pos.getReal());
		return Compat_EnumPlantType.getFake(result);
	}

	@Override
	public Compat_IBlockState getPlant(Compat_IBlockAccess world, Compat_BlockPos pos) {
		IBlockState result = original.getPlant(world.getReal(), pos.getReal());
		return Compat_IBlockState.getFake(result);
	}
}
