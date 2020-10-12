package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class Compat_RenderPlayer extends Compat_RenderLivingBase<AbstractClientPlayer> {
	private RenderPlayer original;
	private CompatI_RenderPlayer thisReal;

	// When called from Mod
	public Compat_RenderPlayer(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderPlayer.class, this, renderManager.getReal()), null);
	}

	// When called from child
	protected Compat_RenderPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderPlayer(RenderPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderPlayer thisReal, RenderPlayer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderPlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
