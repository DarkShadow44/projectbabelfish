package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockDaylightDetector;

public class Compat_BlockDaylightDetector extends Compat_Block {
	private CompatI_BlockDaylightDetector wrapper;

	// When called from Mod
	public Compat_BlockDaylightDetector(boolean p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDaylightDetector.class, this, p1));
	}

	// When called from child
	protected Compat_BlockDaylightDetector(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDaylightDetector(BlockDaylightDetector original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDaylightDetector.class, original));
	}

	protected void initialize(CompatI_BlockDaylightDetector wrapper) {
		this.wrapper = wrapper;
	}

	public BlockDaylightDetector getReal() {
		return wrapper.get();
	}
}
