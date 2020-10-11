package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.common.util;

import com.mojang.authlib.GameProfile;

import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;

public class CompatReal_FakePlayer extends FakePlayer implements CompatI_FakePlayer {
	@SuppressWarnings("unused")
	private Compat_FakePlayer thisFake;

	public CompatReal_FakePlayer(Compat_FakePlayer thisFake, WorldServer world, GameProfile profile) {
		super(world, profile);
		this.thisFake = thisFake;
	}

	@Override
	public FakePlayer get() {
		return this;
	}
}
