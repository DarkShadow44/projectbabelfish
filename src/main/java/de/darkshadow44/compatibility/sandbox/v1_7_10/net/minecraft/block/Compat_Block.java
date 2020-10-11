package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab.Compat_CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class Compat_Block {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		initialize(new CompatReal_Block(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Block Compat_func_149675_a(boolean shouldTick) {
		if (this.original == null)
			thisReal.setTickRandomlySuper(shouldTick);
		else
			original.setTickRandomly(shouldTick);
		return this;
	}

	public void Compat_func_149676_a(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		// TODO: setBlockBounds
	}

	public Compat_Block Compat_func_149711_c(float hardness) {
		if (this.original == null)
			thisReal.setHardnessSuper(hardness);
		else
			original.setHardness(hardness);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149779_h() {
		return new Compat_Block_SoundType(SoundType.PLANT);
	}

	public Compat_Block Compat_func_149672_a(Compat_Block_SoundType sound) {
		if (this.original == null)
			thisReal.setSoundTypeSuper(sound.getReal());
		else
			original.setSoundType(sound.getReal());
		return this;
	}

	public Compat_Block Compat_func_149649_H() {
		if (this.original == null)
			thisReal.disableStatsSuper();
		else
			original.disableStats();
		return this;
	}

	public Compat_Block Compat_func_149647_a(Compat_CreativeTabs creativeTabs) {
		CreativeTabs real = creativeTabs == null ? null : creativeTabs.getReal();
		if (this.original == null)
			thisReal.setCreativeTabSuper(real);
		else
			original.setCreativeTab(real);
		return this;
	}
}
