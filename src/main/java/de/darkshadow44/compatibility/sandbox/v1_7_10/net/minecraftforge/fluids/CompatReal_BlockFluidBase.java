package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class CompatReal_BlockFluidBase extends BlockFluidBase implements CompatI_BlockFluidBase {
	@SuppressWarnings("unused")
	private Compat_BlockFluidBase thisFake;

	public CompatReal_BlockFluidBase(Compat_BlockFluidBase thisFake, Fluid fluid, Material material) {
		super(fluid, material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockFluidBase get() {
		return this;
	}@Override
	public void setTickRandomlySuper(boolean shouldTick) {
		super.setTickRandomly(shouldTick);
	}

	@Override
	public void setHardnessSuper(float hardness) {
		super.setHardness(hardness);
	}

	@Override
	public void setSoundTypeSuper(SoundType sound) {
		super.setSoundType(sound);
	}
	
	@Override
	public void setDefaultSlipperinessSuper(float value) {
		super.setDefaultSlipperiness(value);
	}

	@Override
	public void setResistanceSuper(float resistance) {
		super.setResistance(resistance);
	}
	@Override
	public void setLightLevelSuper(float value) {
		super.setLightLevel(value);
	}

	@Override
	public void disableStatsSuper() {
		super.disableStats();
	}

	@Override
	public void setCreativeTabSuper(CreativeTabs creativeTabs) {
		super.setCreativeTab(creativeTabs);
	}

	@Override
	public void setUnlocalizedNameSuper(String name) {
		super.setUnlocalizedName(name);
	}

	@Override
	public void setLightOpacitySuper(int opacity) {
		super.setLightOpacity(opacity);
	}

	@Override
	public void setBlockUnbreakableSuper() {
		super.setBlockUnbreakable();
	}

	@Override
	public int place(World world, BlockPos pos, FluidStack fluidStack, boolean doPlace) {
		// TODO
		return 0;
	}

	@Override
	public FluidStack drain(World world, BlockPos pos, boolean doDrain) {
		// TODO
		return null;
	}

	@Override
	public boolean canDrain(World world, BlockPos pos) {
		// TODO
		return false;
	}

	@Override
	public int getQuantaValue(IBlockAccess world, BlockPos pos) {
		// TODO
		return 0;
	}

	@Override
	public boolean canCollideCheck(IBlockState state, boolean fullHit) {
		// TODO
		return false;
	}

	@Override
	public int getMaxRenderHeightMeta() {
		// TODO
		return 0;
	}
}
