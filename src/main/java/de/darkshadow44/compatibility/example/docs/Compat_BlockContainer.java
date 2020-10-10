package de.darkshadow44.compatibility.example.docs;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

@SuppressWarnings("unused")
public class Compat_BlockContainer extends Compat_Block {

	private BlockContainer original;
	private CompatI_BlockContainer thisReal;

	// When called from 1.7.10,
	public Compat_BlockContainer(Material materialIn) {
		super();
		thisReal = new CompatReal_BlockContainer(this, materialIn);
		super.setThisReal(thisReal);
	}

	// When called from 1.12.2,
	public Compat_BlockContainer(BlockContainer original) {
		super(original);
		this.original = original;
	}

	public void setThisReal(CompatI_BlockContainer thisReal) {
		this.thisReal = thisReal;
	}

}
