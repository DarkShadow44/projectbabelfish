package compat.sandbox.net.minecraftforge.fml.common.network.simpleimpl;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class Compat_MessageContext {
	private CompatI_MessageContext wrapper;

	// When called from Mod
	public Compat_MessageContext() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_MessageContext.class, this));
	}

	// When called from child
	protected Compat_MessageContext(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_MessageContext(MessageContext original) {
		this.initialize(Factory.createWrapper(CompatI_MessageContext.class, original));
	}

	protected void initialize(CompatI_MessageContext wrapper) {
		this.wrapper = wrapper;
	}

	public MessageContext getReal() {
		return wrapper.get();
	}

	public Compat_Side Compat_get_side() {
		return Compat_Side.fromReal(wrapper.get_side());
	}
}
