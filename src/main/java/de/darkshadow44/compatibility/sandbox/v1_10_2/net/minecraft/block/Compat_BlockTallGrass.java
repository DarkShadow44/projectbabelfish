package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockTallGrass;

public class Compat_BlockTallGrass extends Compat_BlockBush {
	private CompatI_BlockTallGrass wrapper;

	// When called from Mod
	public Compat_BlockTallGrass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockTallGrass.class, this));
	}

	// When called from child
	protected Compat_BlockTallGrass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockTallGrass(BlockTallGrass original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockTallGrass.class, original));
	}

	protected void initialize(CompatI_BlockTallGrass wrapper) {
		this.wrapper = wrapper;
	}

	public BlockTallGrass getReal() {
		return wrapper.get();
	}
}
