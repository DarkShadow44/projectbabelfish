package compat.sandbox.net.minecraft.client.gui.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.gui.Compat_GuiScreen;
import compat.sandbox.net.minecraft.inventory.Compat_Container;
import net.minecraft.client.gui.inventory.GuiContainer;

public class Compat_GuiContainer extends Compat_GuiScreen {
	private CompatI_GuiContainer wrapper;

	// When called from Mod
	public Compat_GuiContainer(Compat_Container container) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GuiContainer.class, this, container.getReal()));
	}

	// When called from child
	protected Compat_GuiContainer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiContainer(GuiContainer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GuiContainer.class, original));
	}

	protected void initialize(CompatI_GuiContainer wrapper) {
		this.wrapper = wrapper;
	}

	public GuiContainer getReal() {
		return wrapper.get();
	}
}
