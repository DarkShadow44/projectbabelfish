package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.BlockMycelium;

public class Compat_BlockMycelium extends Compat_Block {
	private CompatI_BlockMycelium wrapper;

	// When called from Mod
	public Compat_BlockMycelium() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockMycelium.class, this));
	}

	// When called from child
	protected Compat_BlockMycelium(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockMycelium(BlockMycelium original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockMycelium.class, original));
	}

	protected void initialize(CompatI_BlockMycelium wrapper) {
		this.wrapper = wrapper;
	}

	public BlockMycelium getReal() {
		return wrapper.get();
	}
}
