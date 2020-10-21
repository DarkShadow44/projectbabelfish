package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.state.BlockStateContainer.Builder;

public class Compat_BlockStateContainer_Builder {
	private Builder original;
	private CompatI_BlockStateContainer_Builder thisReal;

	// When called from Mod
	public Compat_BlockStateContainer_Builder() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer_Builder.class, this), null);
	}

	// When called from child
	protected Compat_BlockStateContainer_Builder(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BlockStateContainer_Builder(Builder original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockStateContainer_Builder thisReal, Builder original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Builder getReal() {
		return original == null ? thisReal.get() : original;
	}
}
