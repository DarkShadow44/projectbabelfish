package compat.sandbox.net.minecraft.network;

import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;

public class Compat_NetHandlerPlayServer {

	private final NetHandlerPlayServer original;

	public Compat_NetHandlerPlayServer(NetHandlerPlayServer original) {
		this.original = original;
	}

	public Compat_EntityPlayerMP Compat_get_field_147369_b() {
		return new Compat_EntityPlayerMP(original.player);
	}
}
