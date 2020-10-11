package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockBreakable extends BlockBreakable implements CompatI_BlockBreakable {
	@SuppressWarnings("unused")
	private Compat_BlockBreakable thisFake;

	public CompatReal_BlockBreakable(Compat_BlockBreakable thisFake, Material material, boolean p1) {
		super(material, p1);
		this.thisFake = thisFake;
	}

	@Override
	public BlockBreakable get() {
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
}
