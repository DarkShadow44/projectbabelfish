package compat.sandbox.net.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public interface CompatI_Entity {
	public Entity get();

	public World get_world();

	public boolean isSneakingSuper();

	public EnumFacing getHorizontalFacingSuper();

	public World getEntityWorldSuper();

	public double get_lastTickPosX();

	public double get_lastTickPosY();

	public double get_lastTickPosZ();

	public double get_posX();

	public double get_posY();

	public double get_posZ();

	public void setFireSuper(int seconds);

	public void playSoundSuper(SoundEvent event, float volume, float pitch);

	public void set_motionX(double value);

	public void set_motionY(double value);

	public void set_motionZ(double value);

	public float get_rotationYaw();

	public void onUpdateSuper();

	public boolean isEntityAliveSuper();
}
