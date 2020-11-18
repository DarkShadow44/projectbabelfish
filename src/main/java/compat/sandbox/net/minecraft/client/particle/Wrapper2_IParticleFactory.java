package compat.sandbox.net.minecraft.client.particle;

import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class Wrapper2_IParticleFactory implements IParticleFactory {

	private final Compat_IParticleFactory original;

	public Wrapper2_IParticleFactory(Compat_IParticleFactory original) {
		this.original = original;
	}

	public Compat_IParticleFactory getFake() {
		return original;
	}

	@Override
	public Particle createParticle(int id, World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
		Compat_Particle result = original.Compat_createParticle(id, Compat_World.getFake(world), x, y, z, xSpeed, ySpeed, zSpeed, parameters);
		return result.getReal();
	}

}
