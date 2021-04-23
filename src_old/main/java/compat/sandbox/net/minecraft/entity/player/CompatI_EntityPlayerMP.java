package compat.sandbox.net.minecraft.entity.player;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerInteractionManager;

public interface CompatI_EntityPlayerMP extends CompatI_EntityPlayer {
	public EntityPlayerMP get();

	public PlayerInteractionManager get_interactionManager();
}
