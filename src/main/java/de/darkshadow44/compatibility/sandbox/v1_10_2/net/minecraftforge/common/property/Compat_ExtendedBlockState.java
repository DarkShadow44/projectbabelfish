package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class Compat_ExtendedBlockState extends Compat_BlockStateContainer {
	private ExtendedBlockState original;
	private CompatI_ExtendedBlockState thisReal;

	// When called from Mod
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Compat_ExtendedBlockState(Compat_Block block, Compat_IProperty<?>[] properties, Compat_IUnlistedProperty<?>[] unlistedProperties) {
		super(ParentSelector.NULL);

		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		IUnlistedProperty<?>[] unlistedPropertiesConverted = new IUnlistedProperty<?>[unlistedProperties.length];

		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}

		for (int i = 0; i < unlistedProperties.length; i++) {
			unlistedPropertiesConverted[i] = new Wrapper_IUnlistedProperty(unlistedProperties[i]);
		}

		this.initialize(Factory.create(CtorPos.POS1, CompatI_ExtendedBlockState.class, this, block.getReal(), propertiesConverted, unlistedPropertiesConverted), null);
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
