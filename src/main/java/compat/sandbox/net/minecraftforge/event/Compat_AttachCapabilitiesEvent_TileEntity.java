package compat.sandbox.net.minecraftforge.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_ICapabilityProvider;
import compat.sandbox.net.minecraftforge.common.capabilities.Wrapper2_ICapabilityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class Compat_AttachCapabilitiesEvent_TileEntity extends Compat_AttachCapabilitiesEvent<TileEntity> {
	private CompatI_AttachCapabilitiesEvent_TileEntity wrapper;

	// When called from Mod
	public Compat_AttachCapabilitiesEvent_TileEntity() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AttachCapabilitiesEvent_TileEntity.class, this));
	}

	// When called from child
	protected Compat_AttachCapabilitiesEvent_TileEntity(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AttachCapabilitiesEvent_TileEntity(AttachCapabilitiesEvent<TileEntity> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_AttachCapabilitiesEvent_TileEntity.class, original));
	}

	protected void initialize(CompatI_AttachCapabilitiesEvent_TileEntity wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public AttachCapabilitiesEvent<TileEntity> getReal() {
		return wrapper.get();
	}

	public Compat_TileEntity Compat_getTileEntity() {
		TileEntity result = wrapper.getObjectSuper();

		return Compat_TileEntity.get_fake(result);
	}

	public void Compat_addCapability(Compat_ResourceLocation location, Compat_ICapabilityProvider provider) {
		wrapper.addCapabilitySuper(location.getReal(), new Wrapper2_ICapabilityProvider(provider));
	}
}
