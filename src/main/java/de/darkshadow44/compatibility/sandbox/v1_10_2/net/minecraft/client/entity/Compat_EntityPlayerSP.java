package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.entity.EntityPlayerSP;

public class Compat_EntityPlayerSP extends Compat_AbstractClientPlayer {
	private CompatI_EntityPlayerSP wrapper;

	// When called from Mod
	public Compat_EntityPlayerSP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayerSP.class, this));
	}

	// When called from child
	protected Compat_EntityPlayerSP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayerSP(EntityPlayerSP original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPlayerSP.class, original));
	}

	protected void initialize(CompatI_EntityPlayerSP wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityPlayerSP getReal() {
		return wrapper.get();
	}
}
