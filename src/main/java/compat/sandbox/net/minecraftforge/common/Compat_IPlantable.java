package compat.sandbox.net.minecraftforge.common;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import net.minecraftforge.common.IPlantable;

public interface Compat_IPlantable {

	public Compat_EnumPlantType getPlantType(Compat_IBlockAccess world, Compat_BlockPos pos);

	public Compat_IBlockState getPlant(Compat_IBlockAccess world, Compat_BlockPos pos);

	public static Compat_IPlantable getFake(IPlantable real) {
		if (real instanceof Wrapper2_IPlantable) {
			return ((Wrapper2_IPlantable) real).getFake();
		}
		return new Wrapper_IPlantable(real);
	}

	public static IPlantable getReal(Compat_IPlantable fake) {
		if (fake instanceof Wrapper_IPlantable) {
			return ((Wrapper_IPlantable) fake).getReal();
		}
		return new Wrapper2_IPlantable(fake);
	}
}
