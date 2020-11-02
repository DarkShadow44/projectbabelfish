package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.ContainerWorkbench;

public class Compat_ContainerWorkbench extends Compat_Container {
	private CompatI_ContainerWorkbench wrapper;

	// When called from Mod
	public Compat_ContainerWorkbench() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ContainerWorkbench.class, this));
	}

	// When called from child
	protected Compat_ContainerWorkbench(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ContainerWorkbench(ContainerWorkbench original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ContainerWorkbench.class, original));
	}

	protected void initialize(CompatI_ContainerWorkbench wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ContainerWorkbench getReal() {
		return wrapper.get();
	}
}
