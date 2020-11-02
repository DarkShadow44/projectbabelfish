package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class Compat_BlockFluidClassic extends Compat_BlockFluidBase {
	private CompatI_BlockFluidClassic wrapper;

	// When called from Mod
	public Compat_BlockFluidClassic(Compat_Fluid fluid, Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFluidClassic.class, this, fluid.getReal(), material.getReal()));
	}

	// When called from child
	protected Compat_BlockFluidClassic(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFluidClassic(BlockFluidClassic original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFluidClassic.class, original));
	}

	protected void initialize(CompatI_BlockFluidClassic wrapper) {
		this.wrapper = wrapper;
	}

	public BlockFluidClassic getReal() {
		return wrapper.get();
	}
}
