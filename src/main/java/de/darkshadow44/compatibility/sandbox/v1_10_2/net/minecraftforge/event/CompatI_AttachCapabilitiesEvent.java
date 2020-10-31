package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import java.util.Map;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_GenericEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent<T> extends CompatI_GenericEvent<T> {
	public AttachCapabilitiesEvent<T> get();

	public Map<ResourceLocation, ICapabilityProvider> getCapabilitiesSuper();

	public T getObjectSuper();
}
