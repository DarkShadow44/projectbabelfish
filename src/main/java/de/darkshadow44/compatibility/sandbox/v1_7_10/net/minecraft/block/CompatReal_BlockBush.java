package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CompatReal_BlockBush extends BlockBush implements CompatI_BlockBush {
	@SuppressWarnings("unused")
	private Compat_BlockBush thisFake;

	public CompatReal_BlockBush(Compat_BlockBush thisFake) {
		super();
		this.thisFake = thisFake;
	}

	public CompatReal_BlockBush(Compat_BlockBush thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockBush get() {
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
	public void setResistanceSuper(float resistance) {
		super.setResistance(resistance);
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
	public void setLightLevelSuper(float value) {
		super.setLightLevel(value);
	}
}
