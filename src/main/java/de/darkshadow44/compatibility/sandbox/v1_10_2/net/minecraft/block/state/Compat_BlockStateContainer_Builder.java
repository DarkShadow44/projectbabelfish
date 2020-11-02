package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property.Compat_IUnlistedProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property.Wrapper_IUnlistedProperty;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer.Builder;
import net.minecraftforge.common.property.IUnlistedProperty;

public class Compat_BlockStateContainer_Builder {
	private CompatI_BlockStateContainer_Builder wrapper;

	// When called from Mod
	public Compat_BlockStateContainer_Builder(Compat_Block block) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer_Builder.class, this, block.getReal()));
	}

	// When called from child
	protected Compat_BlockStateContainer_Builder(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BlockStateContainer_Builder(Builder original) {
		this.initialize(Factory.createWrapper(CompatI_BlockStateContainer_Builder.class, original));
	}

	protected void initialize(CompatI_BlockStateContainer_Builder wrapper) {
		this.wrapper = wrapper;
	}

	public Builder getReal() {
		return wrapper.get();
	}

	public Compat_BlockStateContainer_Builder Compat_add(Compat_IProperty<?>[] properties) {
		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}

		wrapper.addSuper(propertiesConverted);
		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Compat_BlockStateContainer_Builder Compat_add(Compat_IUnlistedProperty<?>[] properties) {
		IUnlistedProperty<?>[] propertiesConverted = new IUnlistedProperty<?>[properties.length];
		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = new Wrapper_IUnlistedProperty(properties[i]);
		}

		wrapper.addSuper(propertiesConverted);
		return this;
	}

	public Compat_BlockStateContainer Compat_build() {
		return new Compat_BlockStateContainer(wrapper.buildSuper());
	}
}
