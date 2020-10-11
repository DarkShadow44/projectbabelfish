package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockFlower extends BlockFlower implements CompatI_BlockFlower {
	@SuppressWarnings("unused")
	private Compat_BlockFlower thisFake;

	public CompatReal_BlockFlower(Compat_BlockFlower thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockFlower get() {
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
	public void disableStatsSuper() {
		super.disableStats();
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
	public void setDefaultSlipperinessSuper(float value) {
		super.setDefaultSlipperiness(value);
	}

	@Override
	public void setLightLevelSuper(float value) {
		super.setLightLevel(value);
	}

	@Override
	public void setResistanceSuper(float resistance) {
		super.setResistance(resistance);
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
	public EnumFlowerColor getBlockType() {
		// TODO
		return null;
	}

	@Override
	public void setBlockUnbreakableSuper() {
		super.setBlockUnbreakable();
	}
}
