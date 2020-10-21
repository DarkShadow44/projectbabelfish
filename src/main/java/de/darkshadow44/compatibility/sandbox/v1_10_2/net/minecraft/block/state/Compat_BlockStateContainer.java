package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;

public class Compat_BlockStateContainer {
	private BlockStateContainer original;
	private CompatI_BlockStateContainer thisReal;

	// When called from Mod
	public Compat_BlockStateContainer(Compat_Block block, Compat_IProperty<?>[] properties) {
		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer.class, this, block.getReal(), propertiesConverted), null);
	}

	// When called from child
	protected Compat_BlockStateContainer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BlockStateContainer(BlockStateContainer original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockStateContainer thisReal, BlockStateContainer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockStateContainer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
