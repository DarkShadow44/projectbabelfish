package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleDigging;
import net.minecraft.util.math.BlockPos;

public class Compat_ParticleDigging extends Compat_Particle {
	private CompatI_ParticleDigging wrapper;

	// When called from Mod
	public Compat_ParticleDigging(Compat_World world, double p1, double p2, double p3, double p4, double p5, double p6, Compat_Block block) {
		super(ParentSelector.NULL);
		IBlockState state = block.getReal().getDefaultState();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleDigging.class, this, world.getReal(), p1, p2, p3, p4, p5, p6, state));
	}

	// When called from child
	protected Compat_ParticleDigging(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ParticleDigging(ParticleDigging original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ParticleDigging.class, original));
	}

	protected void initialize(CompatI_ParticleDigging wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ParticleDigging getReal() {
		return wrapper.get();
	}

	public Compat_ParticleDigging Compat_func_70596_a(int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		wrapper.multiplyColorSuper(pos);
		return this;
	}
}
