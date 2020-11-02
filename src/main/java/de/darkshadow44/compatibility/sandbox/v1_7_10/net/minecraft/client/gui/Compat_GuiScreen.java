package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.GuiScreen;

public class Compat_GuiScreen extends Compat_Gui {
	private CompatI_GuiScreen wrapper;

	// When called from Mod
	public Compat_GuiScreen() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GuiScreen.class, this));
	}

	// When called from child
	protected Compat_GuiScreen(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiScreen(GuiScreen original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GuiScreen.class, original));
	}

	protected void initialize(CompatI_GuiScreen wrapper) {
		this.wrapper = wrapper;
	}

	public GuiScreen getReal() {
		return wrapper.get();
	}
}
