package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockGrass;

public class Compat_BlockGrass extends Compat_Block {
	private CompatI_BlockGrass wrapper;

	// When called from Mod
	public Compat_BlockGrass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockGrass.class, this));
	}

	// When called from child
	protected Compat_BlockGrass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockGrass(BlockGrass original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockGrass.class, original));
	}

	protected void initialize(CompatI_BlockGrass wrapper) {
		this.wrapper = wrapper;
	}

	public BlockGrass getReal() {
		return wrapper.get();
	}
}
