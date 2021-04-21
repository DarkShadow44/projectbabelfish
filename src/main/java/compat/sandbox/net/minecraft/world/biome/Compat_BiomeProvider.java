package compat.sandbox.net.minecraft.world.biome;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class Compat_BiomeProvider {
	private CompatI_BiomeProvider wrapper;

	// When called from Mod
	public Compat_BiomeProvider() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BiomeProvider.class, this));
	}

	// When called from child
	protected Compat_BiomeProvider(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BiomeProvider(BiomeProvider original) {
		this.initialize(Factory.createWrapper(CompatI_BiomeProvider.class, original));
	}

	protected void initialize(CompatI_BiomeProvider wrapper) {
		this.wrapper = wrapper;
	}

	public BiomeProvider getReal() {
		return wrapper.get();
	}

	public static Compat_BiomeProvider getFake(BiomeProvider real) {
		return new Compat_BiomeProvider(real);
	}

	public Compat_Biome Compat_func_76935_a(int x, int z) {
		BlockPos pos = new BlockPos(x, 0, z);
		Biome result = wrapper.getBiomeSuper(pos);
		return Compat_Biome.getFake(result);
	}
}
