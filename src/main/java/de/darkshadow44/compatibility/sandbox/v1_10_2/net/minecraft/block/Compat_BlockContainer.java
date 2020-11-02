package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockContainer;

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
		this.wrapper = wrapper;
	}

	public BlockContainer getReal() {
		return wrapper.get();
	}
}
