package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.FontRenderer;

public class Compat_FontRenderer {
	private FontRenderer original;
	private CompatI_FontRenderer thisReal;

	// When called from Mod
	public Compat_FontRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FontRenderer.class, this), null);
	}

	// When called from child
	protected Compat_FontRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_FontRenderer(FontRenderer original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_FontRenderer thisReal, FontRenderer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public FontRenderer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
