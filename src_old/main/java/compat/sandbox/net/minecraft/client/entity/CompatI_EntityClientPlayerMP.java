package compat.sandbox.net.minecraft.client.entity;

import compat.sandbox.net.minecraft.entity.player.CompatI_EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;

public interface CompatI_EntityClientPlayerMP extends CompatI_EntityPlayerMP {
	public EntityPlayerMP get();
}
