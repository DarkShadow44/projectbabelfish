package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.entity;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player.CompatI_EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;

public interface CompatI_EntityClientPlayerMP extends CompatI_EntityPlayerMP {
	public EntityPlayerMP get();
}
