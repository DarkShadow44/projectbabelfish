package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockDeadBush extends BlockDeadBush implements CompatI_BlockDeadBush {
	@SuppressWarnings("unused")
	private Compat_BlockDeadBush thisFake;

	public CompatReal_BlockDeadBush(Compat_BlockDeadBush thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockDeadBush get() {
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
