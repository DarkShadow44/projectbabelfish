package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CompatReal_EntityPlayer extends EntityPlayer implements CompatI_EntityPlayer {
	@SuppressWarnings("unused")
	private Compat_EntityPlayer thisFake;

	public CompatReal_EntityPlayer(Compat_EntityPlayer thisFake, World world, GameProfile profile) {
		super(world, profile);
		this.thisFake = thisFake;
	}

	@Override
	public EntityPlayer get() {
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
