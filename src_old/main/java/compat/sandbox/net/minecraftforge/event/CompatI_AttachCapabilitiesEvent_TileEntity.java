package compat.sandbox.net.minecraftforge.event;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent_TileEntity extends CompatI_AttachCapabilitiesEvent<TileEntity> {
	public AttachCapabilitiesEvent<TileEntity> get();

	public void addCapabilitySuper(ResourceLocation location, ICapabilityProvider provider);
}
