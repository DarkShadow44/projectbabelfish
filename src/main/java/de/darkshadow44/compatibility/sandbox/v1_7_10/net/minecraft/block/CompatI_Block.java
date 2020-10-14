package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface CompatI_Block {
	public Block get();

	public Block setTickRandomlySuper(boolean shouldTick);

	public Block setHardnessSuper(float hardness);

	public Block setSoundTypeSuper(SoundType sound);

	public Block disableStatsSuper();

	public Block setCreativeTabSuper(CreativeTabs creativeTabs);
	
	public Block setUnlocalizedNameSuper(String name);

	public Block setLightOpacitySuper(int opacity);

	public Block setBlockUnbreakableSuper();

	public Block setResistanceSuper(float resistance);

	public Block setLightLevelSuper(float value);

	public void setDefaultSlipperinessSuper(float value);

	public Material getMaterialSuper(IBlockState state);

	public SoundType getSoundTypeSuper();

	public IForgeRegistryEntry<Block> setRegistryNameSuper(String name);
}
