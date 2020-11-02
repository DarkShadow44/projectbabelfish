package compat.sandbox.net.minecraft.client.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;

public class Compat_AbstractClientPlayer extends Compat_EntityPlayer {
	private CompatI_AbstractClientPlayer wrapper;

	// When called from Mod
	public Compat_AbstractClientPlayer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AbstractClientPlayer.class, this));
	}

	// When called from child
	protected Compat_AbstractClientPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractClientPlayer(AbstractClientPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_AbstractClientPlayer.class, original));
	}

	protected void initialize(CompatI_AbstractClientPlayer wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public AbstractClientPlayer getReal() {
		return wrapper.get();
	}
}
