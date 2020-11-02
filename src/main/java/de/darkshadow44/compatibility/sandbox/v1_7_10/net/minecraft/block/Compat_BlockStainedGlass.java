package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockStainedGlass;

public class Compat_BlockStainedGlass extends Compat_Block {
	private CompatI_BlockStainedGlass wrapper;

	// When called from Mod
	public Compat_BlockStainedGlass(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStainedGlass.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockStainedGlass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockStainedGlass(BlockStainedGlass original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockStainedGlass.class, original));
	}

	protected void initialize(CompatI_BlockStainedGlass wrapper) {
		this.wrapper = wrapper;
	}

	public BlockStainedGlass getReal() {
		return wrapper.get();
	}
}
