package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.entity.EntityPlayerSP;

public class Compat_EntityPlayerSP extends Compat_AbstractClientPlayer {
	private EntityPlayerSP original;
	private CompatI_EntityPlayerSP thisReal;

	// When called from Mod
	public Compat_EntityPlayerSP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayerSP.class, this), null);
	}

	// When called from child
	protected Compat_EntityPlayerSP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayerSP(EntityPlayerSP original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityPlayerSP thisReal, EntityPlayerSP original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPlayerSP getReal() {
		return original == null ? thisReal.get() : original;
	}
}
