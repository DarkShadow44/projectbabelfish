package compat.sandbox.net.minecraft.client.particle;

import net.minecraft.client.particle.ParticleDigging;
import net.minecraft.util.math.BlockPos;

public interface CompatI_ParticleDigging extends CompatI_Particle {
	public ParticleDigging get();

	public void multiplyColorSuper(BlockPos pos);
}
