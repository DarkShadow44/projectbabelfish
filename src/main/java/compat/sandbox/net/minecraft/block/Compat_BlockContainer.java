package compat.sandbox.net.minecraft.block;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public class Compat_BlockContainer extends Compat_Block {
	private CompatI_BlockContainer wrapper;

	// When called from Mod
	public Compat_BlockContainer(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockContainer.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockContainer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockContainer(BlockContainer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockContainer.class, original));
	}

	protected void initialize(CompatI_BlockContainer wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockContainer getReal() {
		return wrapper.get();
	}

	@Callback
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
}
