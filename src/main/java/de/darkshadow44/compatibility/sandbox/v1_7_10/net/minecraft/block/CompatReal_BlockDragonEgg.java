package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockDragonEgg extends BlockDragonEgg implements CompatI_BlockDragonEgg {
	@SuppressWarnings("unused")
	private Compat_BlockDragonEgg thisFake;

	public CompatReal_BlockDragonEgg(Compat_BlockDragonEgg thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public BlockDragonEgg get() {
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
