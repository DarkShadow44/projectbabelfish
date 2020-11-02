package compat.sandbox.net.minecraft.client.gui;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public GuiScreen getReal() {
		return wrapper.get();
	}
}
