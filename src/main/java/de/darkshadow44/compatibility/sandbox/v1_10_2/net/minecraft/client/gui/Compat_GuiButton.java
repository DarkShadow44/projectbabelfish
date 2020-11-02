package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
