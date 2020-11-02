package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities.Compat_ICapabilityProvider;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities.Wrapper2_ICapabilityProvider;
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
