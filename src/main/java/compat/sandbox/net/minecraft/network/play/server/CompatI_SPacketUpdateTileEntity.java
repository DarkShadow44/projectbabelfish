package compat.sandbox.net.minecraft.network.play.server;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public interface CompatI_SPacketUpdateTileEntity {
	public SPacketUpdateTileEntity get();

	public NBTTagCompound getNbtCompoundSuper();
}
