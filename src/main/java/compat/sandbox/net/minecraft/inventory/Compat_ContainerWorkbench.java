package compat.sandbox.net.minecraft.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
