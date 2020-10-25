package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network.simpleimpl;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class Compat_MessageContext {
	private MessageContext original;
	private CompatI_MessageContext thisReal;

	// When called from Mod
	public Compat_MessageContext() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_MessageContext.class, this), null);
	}

	// When called from child
	protected Compat_MessageContext(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_MessageContext(MessageContext original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_MessageContext thisReal, MessageContext original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public MessageContext getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Side Compat_get_side() {
		if (original == null)
			return Compat_Side.fromReal(thisReal.get_side());
		else
			return Compat_Side.fromReal(original.side);
	}
}
