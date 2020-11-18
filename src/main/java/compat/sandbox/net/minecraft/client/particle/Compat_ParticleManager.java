package compat.sandbox.net.minecraft.client.particle;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumParticleTypes;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Compat_ParticleManager {
	private CompatI_ParticleManager wrapper;

	// When called from Mod
	public Compat_ParticleManager() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ParticleManager.class, this));
	}

	// When called from child
	protected Compat_ParticleManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ParticleManager(ParticleManager original) {
		this.initialize(Factory.createWrapper(CompatI_ParticleManager.class, original));
	}

	protected void initialize(CompatI_ParticleManager wrapper) {
		this.wrapper = wrapper;
	}

	public ParticleManager getReal() {
		return wrapper.get();
	}

	@Callback
	public void emitParticleAtEntity(Entity entity, EnumParticleTypes type) {
		Compat_func_178926_a(Compat_Entity.getFake(entity), Compat_EnumParticleTypes.getFake(type));
	}

	@HasCallback
	public void Compat_func_178926_a(Compat_Entity entity, Compat_EnumParticleTypes type) {
		getReal().emitParticleAtEntity(entity.getReal(), type.getReal());
	}

	@Callback
	public Particle spawnEffectParticle(int id, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
		Compat_Particle result = Compat_func_178927_a(id, x, y, z, xSpeed, ySpeed, zSpeed, parameters);
		return result.getReal();
	}

	@HasCallback
	public Compat_Particle Compat_func_178927_a(int id, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int[] parameters) {
		Particle result = getReal().spawnEffectParticle(id, x, y, z, xSpeed, ySpeed, zSpeed, parameters);
		return Compat_Particle.getFake(result);
	}

	@Callback
	public void registerParticle(int id, IParticleFactory factory) {
		Compat_func_178929_a(id, Compat_IParticleFactory.getFake(factory));
	}

	@HasCallback
	public void Compat_func_178929_a(int id, Compat_IParticleFactory factory) {
		getReal().registerParticle(id, Compat_IParticleFactory.getReal(factory));
	}

	@Callback
	public void addBlockHitEffects(BlockPos pos, EnumFacing facing) {
		Compat_func_180532_a(Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback
	public void Compat_func_180532_a(Compat_BlockPos pos, Compat_EnumFacing facing) {
		getReal().addBlockHitEffects(pos.getReal(), facing.getReal());
	}

	@Callback
	public void addBlockDestroyEffects(BlockPos pos, IBlockState state) {
		Compat_func_180533_a(Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state));
	}

	@HasCallback
	public void Compat_func_180533_a(Compat_BlockPos pos, Compat_IBlockState state) {
		getReal().addBlockDestroyEffects(pos.getReal(), state.getReal());
	}

	@Callback
	public void updateEffects() {
		Compat_func_78868_a();
	}

	@HasCallback
	public void Compat_func_78868_a() {
		getReal().updateEffects();
	}

	@Callback
	public String getStatistics() {
		return Compat_func_78869_b();
	}

	@HasCallback
	public String Compat_func_78869_b() {
		return getReal().getStatistics();
	}

	@Callback
	public void clearEffects(World world) {
		Compat_func_78870_a(Compat_World.getFake(world));
	}

	@HasCallback
	public void Compat_func_78870_a(Compat_World world) {
		getReal().clearEffects(world.getReal());
	}

	@Callback
	public void renderLitParticles(Entity entity, float partialTick) {
		Compat_func_78872_b(Compat_Entity.getFake(entity), partialTick);
	}

	@HasCallback
	public void Compat_func_78872_b(Compat_Entity entity, float partialTick) {
		getReal().renderLitParticles(entity.getReal(), partialTick);
	}

	@Callback
	public void addEffect(Particle effect) {
		Compat_func_78873_a(Compat_Particle.getFake(effect));
	}

	@HasCallback
	public void Compat_func_78873_a(Compat_Particle particle) {
		getReal().addEffect(particle.getReal());
	}

	@Callback
	public void renderParticles(Entity entity, float partialTicks) {
		Compat_func_78874_a(Compat_Entity.getFake(entity), partialTicks);
	}

	@HasCallback
	public void Compat_func_78874_a(Compat_Entity entity, float partialTick) {
		getReal().renderParticles(entity.getReal(), partialTick);
	}
}
