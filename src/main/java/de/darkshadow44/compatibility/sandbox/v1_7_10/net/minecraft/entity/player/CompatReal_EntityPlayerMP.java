package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import net.minecraft.entity.player.EntityPlayerMP;

public class CompatReal_EntityPlayerMP extends EntityPlayerMP implements CompatI_EntityPlayerMP {
	@SuppressWarnings("unused")
	private Compat_EntityPlayerMP thisFake;

	public CompatReal_EntityPlayerMP(Compat_EntityPlayerMP thisFake) {
		super(null, null, null, null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public EntityPlayerMP get() {
		return this;
	}
}
