package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockChest.Type;

public class Compat_BlockChest extends Compat_Block {
	private BlockChest original;
	private CompatI_BlockChest thisReal;

	// When called from Mod
	public Compat_BlockChest(int p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, Type.BASIC), null);
	}

	// When called from child
	protected Compat_BlockChest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockChest(BlockChest original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockChest thisReal, BlockChest original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockChest getReal() {
		return original == null ? thisReal.get() : original;
	}
}
