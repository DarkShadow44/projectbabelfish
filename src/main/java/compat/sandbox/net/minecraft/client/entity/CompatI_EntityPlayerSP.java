package compat.sandbox.net.minecraft.client.entity;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.EnumHandSide;

public interface CompatI_EntityPlayerSP extends CompatI_AbstractClientPlayer {
	public EntityPlayerSP get();

	public EnumHandSide getPrimaryHandSuper();

	public CooldownTracker getCooldownTrackerSuper();

	public GameProfile getGameProfileSuper();
}
