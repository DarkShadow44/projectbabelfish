package compat.sandbox.net.minecraft.client.gui;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.Compat_Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class Compat_GuiIngame extends Compat_Gui {
	private CompatI_GuiIngame wrapper;

	// When called from Mod
	public Compat_GuiIngame(Compat_Minecraft mc) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GuiIngame.class, this, mc.getReal()));
	}

	// When called from child
	protected Compat_GuiIngame(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiIngame(GuiIngame original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GuiIngame.class, original));
	}

	protected void initialize(CompatI_GuiIngame wrapper) {
		this.wrapper = wrapper;
	}

	public GuiIngame getReal() {
		return wrapper.get();
	}
}
