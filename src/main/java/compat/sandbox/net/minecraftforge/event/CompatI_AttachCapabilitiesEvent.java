package compat.sandbox.net.minecraftforge.event;

import java.util.Map;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_GenericEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent<T> extends CompatI_GenericEvent<T> {
	public AttachCapabilitiesEvent<T> get();

	public Map<ResourceLocation, ICapabilityProvider> getCapabilitiesSuper();

	public T getObjectSuper();
}
