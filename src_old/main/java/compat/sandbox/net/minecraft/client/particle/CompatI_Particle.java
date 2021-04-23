package compat.sandbox.net.minecraft.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public interface CompatI_Particle {
	public Particle get();

	public Particle multiplyVelocitySuper(float multiplier);

	public void setParticleTextureSuper(TextureAtlasSprite sprite);
}
