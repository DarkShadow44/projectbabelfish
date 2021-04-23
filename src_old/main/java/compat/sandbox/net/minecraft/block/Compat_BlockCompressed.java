package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_MapColor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Compat_BlockCompressed extends Compat_Block {
	private CompatI_Block wrapper;

	// When called from Mod
	public Compat_BlockCompressed(Compat_MapColor color) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS6, CompatI_Block.class, this, Material.IRON, color.getReal()));
	}

	// When called from child
	protected Compat_BlockCompressed(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockCompressed(Block original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_Block.class, original));
	}

	protected void initialize(CompatI_Block wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Block getReal() {
		return wrapper.get();
	}
}
