package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.Compat_Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class Compat_GuiIngame extends Compat_Gui {
	private GuiIngame original;
	private CompatI_GuiIngame thisReal;

	// When called from Mod
	public Compat_GuiIngame(Compat_Minecraft mc) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, mc.getReal()), null);
	}

	// When called from child
	protected Compat_GuiIngame(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiIngame(GuiIngame original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_GuiIngame thisReal, GuiIngame original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public GuiIngame getReal() {
		return original == null ? thisReal.get() : original;
	}
}
