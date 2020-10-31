package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network.play.server;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public interface CompatI_SPacketUpdateTileEntity {
	public SPacketUpdateTileEntity get();

	public NBTTagCompound getNbtCompoundSuper();
}
