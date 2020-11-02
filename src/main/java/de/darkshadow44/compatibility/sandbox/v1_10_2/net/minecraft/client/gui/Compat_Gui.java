package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.gui;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.Gui;

public class Compat_Gui {
	private CompatI_Gui wrapper;

	// When called from Mod
	public Compat_Gui() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Gui.class, this));
	}

	// When called from child
	protected Compat_Gui(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Gui(Gui original) {
		this.initialize(Factory.createWrapper(CompatI_Gui.class, original));
	}

	protected void initialize(CompatI_Gui wrapper) {
		this.wrapper = wrapper;
	}

	public Gui getReal() {
		return wrapper.get();
	}
}
