package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockDoor extends BlockDoor implements CompatI_BlockDoor {
	@SuppressWarnings("unused")
	private Compat_BlockDoor thisFake;

	public CompatReal_BlockDoor(Compat_BlockDoor thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockDoor get() {
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
	public void setResistanceSuper(float resistance) {
		super.setResistance(resistance);
	}
}
