package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.FontRenderer;

public class Compat_FontRenderer {
	private CompatI_FontRenderer wrapper;

	// When called from Mod
	public Compat_FontRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FontRenderer.class, this));
	}

	// When called from child
	protected Compat_FontRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_FontRenderer(FontRenderer original) {
		this.initialize(Factory.createWrapper(CompatI_FontRenderer.class, original));
	}

	protected void initialize(CompatI_FontRenderer wrapper) {
		this.wrapper = wrapper;
	}

	public FontRenderer getReal() {
		return wrapper.get();
	}
}
