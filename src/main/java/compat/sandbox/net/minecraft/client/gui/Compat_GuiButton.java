package compat.sandbox.net.minecraft.client.gui;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.gui.GuiButton;

public class Compat_GuiButton extends Compat_Gui {
	private CompatI_GuiButton wrapper;

	// When called from Mod
	public Compat_GuiButton() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GuiButton.class, this));
	}

	// When called from child
	protected Compat_GuiButton(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiButton(GuiButton original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GuiButton.class, original));
	}

	protected void initialize(CompatI_GuiButton wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public GuiButton getReal() {
		return wrapper.get();
	}
}
