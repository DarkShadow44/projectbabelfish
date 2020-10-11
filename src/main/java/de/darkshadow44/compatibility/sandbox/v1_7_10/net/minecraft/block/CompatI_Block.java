package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public interface CompatI_Block {
	public Block get();

	public void setTickRandomlySuper(boolean shouldTick);

	public void setHardnessSuper(float hardness);

	public void setSoundTypeSuper(SoundType sound);

	public void disableStatsSuper();

	public void setCreativeTabSuper(CreativeTabs creativeTabs);
	
	public void setUnlocalizedNameSuper(String name);

	public void setLightOpacitySuper(int opacity);
}
