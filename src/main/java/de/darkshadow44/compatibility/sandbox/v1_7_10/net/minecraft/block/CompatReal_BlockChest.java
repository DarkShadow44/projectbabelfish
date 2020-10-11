package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockChest;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockChest extends BlockChest implements CompatI_BlockChest {
	@SuppressWarnings("unused")
	private Compat_BlockChest thisFake;

	public CompatReal_BlockChest(Compat_BlockChest thisFake, Type chestTypeIn) {
		super(chestTypeIn);
		this.thisFake = thisFake;
	}

	@Override
	public BlockChest get() {
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
