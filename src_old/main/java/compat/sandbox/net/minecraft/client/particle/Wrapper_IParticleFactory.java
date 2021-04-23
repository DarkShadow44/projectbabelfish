package compat.sandbox.net.minecraft.client.particle;

import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;

public class Wrapper_IParticleFactory implements Compat_IParticleFactory {
	private final IParticleFactory original;

	public Wrapper_IParticleFactory(IParticleFactory original) {
		this.original = original;
	}

	public IParticleFactory getReal() {
		return original;
	}

	@Override
	public Compat_Particle Compat_createParticle(int id, Compat_World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
		Particle result = original.createParticle(id, world.getReal(), x, y, z, xSpeed, ySpeed, zSpeed, parameters);
		return Compat_Particle.getFake(result);
	}
}
