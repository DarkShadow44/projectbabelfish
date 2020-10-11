package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockFire extends BlockFire implements CompatI_BlockFire {
	@SuppressWarnings("unused")
	private Compat_BlockFire thisFake;

	public CompatReal_BlockFire(Compat_BlockFire thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockFire get() {
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
	public void setFireInfoSuper(Block block, int encouragement, int flammability) {
		super.setFireInfo(block, encouragement, flammability);
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
