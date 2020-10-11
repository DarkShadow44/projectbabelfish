package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CompatReal_BlockSlab extends BlockSlab implements CompatI_BlockSlab {
	@SuppressWarnings("unused")
	private Compat_BlockSlab thisFake;

	public CompatReal_BlockSlab(Compat_BlockSlab thisFake, Material material) {
		super(material);
		this.thisFake = thisFake;
	}

	@Override
	public BlockSlab get() {
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
	public void setLightOpacitySuper(int opacity) {
		super.setLightOpacity(opacity);
	}

	@Override
	public String getUnlocalizedName(int meta) {
		// TODO
		return null;
	}

	@Override
	public boolean isDouble() {
		// TODO
		return false;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		// TODO
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		// TODO
		return null;
	}

	@Override
	public void setBlockUnbreakableSuper() {
		super.setBlockUnbreakable();
	}
}
