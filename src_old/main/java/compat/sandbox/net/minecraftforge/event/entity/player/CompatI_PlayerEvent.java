package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.sandbox.net.minecraftforge.event.entity.living.CompatI_LivingEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public interface CompatI_PlayerEvent extends CompatI_LivingEvent {
	public PlayerEvent get();

	public EntityPlayer getEntityPlayerSuper();
}
