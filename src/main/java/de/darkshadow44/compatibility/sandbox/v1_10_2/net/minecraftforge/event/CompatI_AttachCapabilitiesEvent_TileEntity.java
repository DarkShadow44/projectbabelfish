package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent_TileEntity extends CompatI_AttachCapabilitiesEvent<TileEntity> {
	public AttachCapabilitiesEvent<TileEntity> get();

	public void addCapabilitySuper(ResourceLocation location, ICapabilityProvider provider);
}
