package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.inventory;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.Compat_GuiScreen;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory.Compat_Container;
import net.minecraft.client.gui.inventory.GuiContainer;

public class Compat_GuiContainer extends Compat_GuiScreen {
	private GuiContainer original;
	private CompatI_GuiContainer thisReal;

	// When called from Mod
	public Compat_GuiContainer(Compat_Container container) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_GuiContainer(this, container.getReal()), null);
	}

	// When called from child
	protected Compat_GuiContainer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiContainer(GuiContainer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_GuiContainer thisReal, GuiContainer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public GuiContainer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
