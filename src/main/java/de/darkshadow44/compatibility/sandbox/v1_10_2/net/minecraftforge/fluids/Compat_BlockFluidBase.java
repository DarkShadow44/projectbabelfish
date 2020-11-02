package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraftforge.fluids.BlockFluidBase;

public class Compat_BlockFluidBase extends Compat_Block {
	private CompatI_BlockFluidBase wrapper;

	// When called from Mod
	public Compat_BlockFluidBase(Compat_Fluid fluid, Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFluidBase.class, this, fluid.getReal(), material.getReal()));
	}

	// When called from child
	protected Compat_BlockFluidBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFluidBase(BlockFluidBase original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFluidBase.class, original));
	}

	protected void initialize(CompatI_BlockFluidBase wrapper) {
		this.wrapper = wrapper;
	}

	public BlockFluidBase getReal() {
		return wrapper.get();
	}

	public void Compat_set_quantaPerBlock(int value) {
		this.wrapper.setQuantaPerBlockSuper(value);
	}
}
