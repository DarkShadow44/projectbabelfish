package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class Compat_EntityPlayer extends EntityPlayer {

	public Compat_EntityPlayer(World worldIn, GameProfile gameProfileIn) {
		super(worldIn, gameProfileIn);
	}
}
