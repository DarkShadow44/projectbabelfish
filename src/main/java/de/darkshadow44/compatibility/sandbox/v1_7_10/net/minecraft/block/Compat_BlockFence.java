package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;

public class Compat_BlockFence extends Compat_Block {
	private CompatI_BlockFence wrapper;

	// When called from Mod
	public Compat_BlockFence(String p1, Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFence.class, this, material.getReal(), MapColor.BLACK)); // TODO
	}

	// When called from child
	protected Compat_BlockFence(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFence(BlockFence original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFence.class, original));
	}

	protected void initialize(CompatI_BlockFence wrapper) {
		this.wrapper = wrapper;
	}

	public BlockFence getReal() {
		return wrapper.get();
	}
}
