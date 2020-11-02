package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class Compat_RenderPlayer extends Compat_RenderLivingBase<AbstractClientPlayer> {
	private CompatI_RenderPlayer wrapper;

	// When called from Mod
	public Compat_RenderPlayer(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderPlayer.class, this, renderManager.getReal()));
	}

	// When called from child
	protected Compat_RenderPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderPlayer(RenderPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderPlayer.class, original));
	}

	protected void initialize(CompatI_RenderPlayer wrapper) {
		this.wrapper = wrapper;
	}

	public RenderPlayer getReal() {
		return wrapper.get();
	}
}
