package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory.Compat_Container;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.Compat_GuiScreen;
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
