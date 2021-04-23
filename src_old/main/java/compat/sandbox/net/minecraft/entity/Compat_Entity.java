package compat.sandbox.net.minecraft.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Compat_Entity {
	private CompatI_Entity wrapper;

	// When called from Mod
	public Compat_Entity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Entity.class, this));
	}

	// When called from child
	protected Compat_Entity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Entity(Entity original) {
		this.initialize(Factory.createWrapper(CompatI_Entity.class, original));
	}

	protected void initialize(CompatI_Entity wrapper) {
		this.wrapper = wrapper;
	}

	public Entity getReal() {
		return wrapper.get();
	}

	public Compat_World Compat_get_field_70170_p() {
		return Compat_World.getFake(wrapper.get_world());
	}

	public boolean Compat_func_70093_af() {
		return wrapper.isSneakingSuper();
	}

	public Compat_EnumFacing Compat_func_174811_aO() {
		EnumFacing result = wrapper.getHorizontalFacingSuper();
		return Compat_EnumFacing.getFake(result);
	}

	public Compat_World Compat_func_130014_f_() {
		World result = wrapper.getEntityWorldSuper();
		return Compat_World.getFake(result);
	}

	public double Compat_get_field_70142_S() {
		return wrapper.get_lastTickPosX();
	}

	public double Compat_get_field_70137_T() {
		return wrapper.get_lastTickPosY();
	}

	public double Compat_get_field_70136_U() {
		return wrapper.get_lastTickPosZ();
	}

	public double Compat_get_field_70165_t() {
		return wrapper.get_posX();
	}

	public double Compat_get_field_70163_u() {
		return wrapper.get_posY();
	}

	public double Compat_get_field_70161_v() {
		return wrapper.get_posZ();
	}

	public static Compat_Entity getFake(Entity entity) {
		return new Compat_Entity(entity);
	}

	public static Entity getReal(Compat_Entity entity) {
		return entity == null ? null : entity.getReal();
	}

	public void Compat_func_70015_d(int seconds) {
		wrapper.setFireSuper(seconds);
	}

	public void Compat_func_85030_a(String name, float volume, float pitch) {
		SoundEvent event = SoundEvent.REGISTRY.getObject(new ResourceLocation(name));
		if (event == null) {
			throw new RuntimeException(name);
		}
		wrapper.playSoundSuper(event, volume, pitch);
	}

	public void Compat_set_field_70159_w(double value) {
		wrapper.set_motionX(value);
	}

	public void Compat_set_field_70181_x(double value) {
		wrapper.set_motionY(value);
	}

	public void Compat_set_field_70179_y(double value) {
		wrapper.set_motionZ(value);
	}

	public float Compat_get_field_70177_z() {
		return wrapper.get_rotationYaw();
	}

	public void Compat_func_70071_h_() {
		wrapper.onUpdateSuper();
	}

	public boolean Compat_func_70089_S() {
		return wrapper.isEntityAliveSuper();
	}
}
