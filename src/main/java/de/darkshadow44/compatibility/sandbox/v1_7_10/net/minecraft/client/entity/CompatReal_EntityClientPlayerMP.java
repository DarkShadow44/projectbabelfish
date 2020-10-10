package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.entity;

import net.minecraft.entity.player.EntityPlayerMP;

public class CompatReal_EntityClientPlayerMP extends EntityPlayerMP implements CompatI_EntityClientPlayerMP {
	@SuppressWarnings("unused")
	private Compat_EntityClientPlayerMP thisFake;

	public CompatReal_EntityClientPlayerMP(Compat_EntityClientPlayerMP thisFake) {
		super(null, null, null, null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public EntityPlayerMP get() {
		return this;
	}

	@Override
	public boolean isSpectator() {
		// TODO
		return false;
	}

	@Override
	public boolean isCreative() {
		// TODO
		return false;
	}
}
