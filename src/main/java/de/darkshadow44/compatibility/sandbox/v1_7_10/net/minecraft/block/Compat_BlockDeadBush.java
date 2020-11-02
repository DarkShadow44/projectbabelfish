package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDeadBush;

public class Compat_BlockDeadBush extends Compat_Block {
	private CompatI_BlockDeadBush wrapper;

	// When called from Mod
	public Compat_BlockDeadBush() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, Compat_BlockDeadBush.class, this));
	}

	// When called from child
	protected Compat_BlockDeadBush(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDeadBush(BlockDeadBush original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDeadBush.class, original));
	}

	protected void initialize(CompatI_BlockDeadBush wrapper) {
		this.wrapper = wrapper;
	}

	public BlockDeadBush getReal() {
		return wrapper.get();
	}
}
