package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureManager;
import net.minecraft.client.renderer.RenderItem;

public class Compat_RenderItem {
	private RenderItem original;
	private CompatI_RenderItem thisReal;

	// When called from Mod
	public Compat_RenderItem(Compat_TextureManager textureManager) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderItem.class, this, textureManager.getReal(), null, null), null); // TODO
	}

	// When called from child
	protected Compat_RenderItem(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderItem(RenderItem original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderItem thisReal, RenderItem original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderItem getReal() {
		return original == null ? thisReal.get() : original;
	}
}
