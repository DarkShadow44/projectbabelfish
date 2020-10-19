package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_BlockStateContainer;
import net.minecraftforge.common.property.ExtendedBlockState;

public class Compat_ExtendedBlockState extends Compat_BlockStateContainer {
	private ExtendedBlockState original;
	private CompatI_ExtendedBlockState thisReal;

	// When called from Mod
	public Compat_ExtendedBlockState() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ExtendedBlockState.class, this), null);
	}

	// When called from child
	protected Compat_ExtendedBlockState(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ExtendedBlockState(ExtendedBlockState original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ExtendedBlockState thisReal, ExtendedBlockState original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ExtendedBlockState getReal() {
		return original == null ? thisReal.get() : original;
	}
}
