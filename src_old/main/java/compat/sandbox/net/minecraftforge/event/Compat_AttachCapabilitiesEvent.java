package compat.sandbox.net.minecraftforge.event;

import java.util.HashMap;
import java.util.Map;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_ICapabilityProvider;
import compat.sandbox.net.minecraftforge.common.capabilities.Wrapper_ICapabilityProvider;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_GenericEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class Compat_AttachCapabilitiesEvent<T> extends Compat_GenericEvent<T> {
	private CompatI_AttachCapabilitiesEvent<T> wrapper;

	// When called from Mod
	public Compat_AttachCapabilitiesEvent(Object obj) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AttachCapabilitiesEvent.class, this, obj.getClass(), obj)); // TODO right class?
	}

	// When called from child
	protected Compat_AttachCapabilitiesEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AttachCapabilitiesEvent(AttachCapabilitiesEvent<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_AttachCapabilitiesEvent.class, original));
	}

	protected void initialize(CompatI_AttachCapabilitiesEvent<T> wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public AttachCapabilitiesEvent<T> getReal() {
		return wrapper.get();
	}

	public Map<Compat_ResourceLocation, Compat_ICapabilityProvider> Compat_getCapabilities() {
		Map<ResourceLocation, ICapabilityProvider> capabilities = wrapper.getCapabilitiesSuper();

		Map<Compat_ResourceLocation, Compat_ICapabilityProvider> ret = new HashMap<>();

		for (ResourceLocation location : capabilities.keySet()) {
			ICapabilityProvider provider = capabilities.get(location);
			ret.put(new Compat_ResourceLocation(location), new Wrapper_ICapabilityProvider(provider));
		}

		return ret;
	}
}
