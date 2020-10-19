package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.ContainerWorkbench;

public class Compat_ContainerWorkbench extends Compat_Container {
	private ContainerWorkbench original;
	private CompatI_ContainerWorkbench thisReal;

	// When called from Mod
	public Compat_ContainerWorkbench() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ContainerWorkbench.class, this), null);
	}

	// When called from child
	protected Compat_ContainerWorkbench(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ContainerWorkbench(ContainerWorkbench original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ContainerWorkbench thisReal, ContainerWorkbench original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ContainerWorkbench getReal() {
		return original == null ? thisReal.get() : original;
	}
}
