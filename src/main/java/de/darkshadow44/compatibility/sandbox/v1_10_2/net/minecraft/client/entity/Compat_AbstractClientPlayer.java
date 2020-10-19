package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;

public class Compat_AbstractClientPlayer extends Compat_EntityPlayer {
	private AbstractClientPlayer original;
	private CompatI_AbstractClientPlayer thisReal;

	// When called from Mod
	public Compat_AbstractClientPlayer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AbstractClientPlayer.class, this), null);
	}

	// When called from child
	protected Compat_AbstractClientPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractClientPlayer(AbstractClientPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AbstractClientPlayer thisReal, AbstractClientPlayer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public AbstractClientPlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
