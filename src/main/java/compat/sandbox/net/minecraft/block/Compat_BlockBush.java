package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockBush;

public class Compat_BlockBush extends Compat_Block {
	private CompatI_BlockBush wrapper;

	// When called from Mod
	public Compat_BlockBush() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockBush.class, this));
	}

	// When called from Mod
	public Compat_BlockBush(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS2, CompatI_BlockBush.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockBush(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockBush(BlockBush original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockBush.class, original));
	}

	protected void initialize(CompatI_BlockBush wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockBush getReal() {
		return wrapper.get();
	}
}
