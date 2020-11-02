package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockChest.Type;

public class Compat_BlockChest extends Compat_Block {
	private CompatI_BlockChest wrapper;

	// When called from Mod
	public Compat_BlockChest(int p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockChest.class, this, Type.BASIC));
	}

	// When called from child
	protected Compat_BlockChest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockChest(BlockChest original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockChest.class, original));
	}

	protected void initialize(CompatI_BlockChest wrapper) {
		this.wrapper = wrapper;
	}

	public BlockChest getReal() {
		return wrapper.get();
	}
}
