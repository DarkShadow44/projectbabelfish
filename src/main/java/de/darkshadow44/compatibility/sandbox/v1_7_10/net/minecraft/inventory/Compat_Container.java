package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.Container;

public class Compat_Container {
	private CompatI_Container wrapper;

	// When called from Mod
	public Compat_Container() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Container.class, this));
	}

	// When called from child
	protected Compat_Container(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Container(Container original) {
		this.initialize(Factory.createWrapper(CompatI_Container.class, original));
	}

	protected void initialize(CompatI_Container wrapper) {
		this.wrapper = wrapper;
	}

	public Container getReal() {
		return wrapper.get();
	}
}
