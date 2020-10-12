package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockTallGrass;

public class Compat_BlockTallGrass extends Compat_BlockBush {
	private BlockTallGrass original;
	private CompatI_BlockTallGrass thisReal;

	// When called from Mod
	public Compat_BlockTallGrass() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_BlockTallGrass(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockTallGrass(BlockTallGrass original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockTallGrass thisReal, BlockTallGrass original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockTallGrass getReal() {
		return original == null ? thisReal.get() : original;
	}
}
