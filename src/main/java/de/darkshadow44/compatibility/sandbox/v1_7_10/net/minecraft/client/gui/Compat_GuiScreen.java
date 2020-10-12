package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.GuiScreen;

public class Compat_GuiScreen extends Compat_Gui {
	private GuiScreen original;
	private CompatI_GuiScreen thisReal;

	// When called from Mod
	public Compat_GuiScreen() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_GuiScreen(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiScreen(GuiScreen original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_GuiScreen thisReal, GuiScreen original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public GuiScreen getReal() {
		return original == null ? thisReal.get() : original;
	}
}
