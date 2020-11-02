package compat.sandbox.net.minecraft.world.biome;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class Compat_BiomeGenBase {
	private CompatI_BiomeGenBase wrapper;

	// When called from Mod
	public Compat_BiomeGenBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BiomeGenBase.class, this));
	}

	// When called from child
	protected Compat_BiomeGenBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BiomeGenBase(Biome original) {
		this.initialize(Factory.createWrapper(CompatI_BiomeGenBase.class, original));
	}

	protected void initialize(CompatI_BiomeGenBase wrapper) {
		this.wrapper = wrapper;
	}

	public Biome getReal() {
		return wrapper.get();
	}

	public static Compat_BiomeGenBase Compat_get_field_76780_h() {
		return new Compat_BiomeGenBase(Biomes.SWAMPLAND);
	}

	public String Compat_get_field_76791_y() {
		return wrapper.getBiomeNameSuper();
	}
}
