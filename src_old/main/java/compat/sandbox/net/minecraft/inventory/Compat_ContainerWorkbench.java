package compat.sandbox.net.minecraft.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_InventoryPlayer;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.inventory.ContainerWorkbench;

public class Compat_ContainerWorkbench extends Compat_Container {
	private CompatI_ContainerWorkbench wrapper;

	// When called from Mod
	public Compat_ContainerWorkbench(Compat_InventoryPlayer inv, Compat_World world, Compat_BlockPos pos) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ContainerWorkbench.class, this, inv.getReal(), world.getReal(), pos.getReal()));
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
