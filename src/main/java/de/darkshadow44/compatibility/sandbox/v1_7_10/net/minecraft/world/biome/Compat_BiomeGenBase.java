package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.biome;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class Compat_BiomeGenBase {
	private Biome original;
	private CompatI_BiomeGenBase thisReal;

	// When called from Mod
	public Compat_BiomeGenBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BiomeGenBase.class, this), null);
	}

	// When called from child
	protected Compat_BiomeGenBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BiomeGenBase(Biome original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BiomeGenBase thisReal, Biome original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Biome getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_BiomeGenBase Compat_get_field_76780_h() {
		return new Compat_BiomeGenBase(Biomes.SWAMPLAND);
	}

	public String Compat_get_field_76791_y() {
		if (original == null)
			return thisReal.getBiomeNameSuper();
		else
			return original.getBiomeName();
	}
}
