package compat.sandbox.net.minecraftforge.fluids;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
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
