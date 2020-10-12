package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockBush;

public class Compat_BlockBush extends Compat_Block {
	private BlockBush original;
	private CompatI_BlockBush thisReal;

	// When called from Mod
	public Compat_BlockBush() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from Mod
	public Compat_BlockBush(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS2, this, material.getReal()), null);
	}

	// When called from child
	protected Compat_BlockBush(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockBush(BlockBush original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockBush thisReal, BlockBush original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockBush getReal() {
		return original == null ? thisReal.get() : original;
	}
}
