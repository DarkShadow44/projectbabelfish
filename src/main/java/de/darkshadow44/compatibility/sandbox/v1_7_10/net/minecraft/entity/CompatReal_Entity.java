package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CompatReal_Entity extends Entity implements CompatI_Entity {
	@SuppressWarnings("unused")
	private Compat_Entity thisFake;

	public CompatReal_Entity(Compat_Entity thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public Entity get() {
		return this;
	}

	@Override
	protected void entityInit() {
		// TODO
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO
	}
}
