package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockIce;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockIce extends BlockIce implements CompatI_BlockIce {
	@SuppressWarnings("unused")
	private Compat_BlockIce thisFake;

	public CompatReal_BlockIce(Compat_BlockIce thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockIce get() {
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
	public void setCreativeTabSuper(CreativeTabs creativeTabs) {
		super.setCreativeTab(creativeTabs);
	}
}
