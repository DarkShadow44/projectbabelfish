package compat.sandbox.net.minecraft.client.particle;

import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.client.particle.IParticleFactory;

public interface Compat_IParticleFactory {

	public Compat_Particle Compat_createParticle(int id, Compat_World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters);

	public static Compat_IParticleFactory getFake(IParticleFactory real) {
		if (real instanceof Wrapper2_IParticleFactory) {
			return ((Wrapper2_IParticleFactory) real).getFake();
		}
		return new Wrapper_IParticleFactory(real);
	}

	public static IParticleFactory getReal(Compat_IParticleFactory fake) {
		if (fake instanceof Wrapper_IParticleFactory) {
			return ((Wrapper_IParticleFactory) fake).getReal();
		}
		return new Wrapper2_IParticleFactory(fake);
	}
}
