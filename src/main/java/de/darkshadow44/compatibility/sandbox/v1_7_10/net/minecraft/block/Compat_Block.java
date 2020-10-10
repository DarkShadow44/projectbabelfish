package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.Block;

public class Compat_Block {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		initialize(new CompatReal_Block(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}
}
