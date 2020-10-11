package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class CompatReal_BlockFluidClassic extends BlockFluidClassic implements CompatI_BlockFluidClassic {
	@SuppressWarnings("unused")
	private Compat_BlockFluidClassic thisFake;

	public CompatReal_BlockFluidClassic(Compat_BlockFluidClassic thisFake, Fluid fluid, Material material) {
		super(fluid, material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockFluidClassic get() {
		return this;
	}

	@Override
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
	public SoundType getSoundTypeSuper() {
		return this.blockSoundType;
	}

	@Override
	public Material getMaterialSuper() {
		return this.blockMaterial;
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
	public void setQuantaPerBlockSuper(int value) {
		super.setQuantaPerBlock(value);
	}
}
