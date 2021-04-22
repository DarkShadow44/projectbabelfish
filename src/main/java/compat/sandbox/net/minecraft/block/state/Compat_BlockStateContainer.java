package compat.sandbox.net.minecraft.block.state;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.properties.Compat_IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.IProperty;
import net.minecraft.world.chunk.BlockStateContainer;

public class Compat_BlockStateContainer {
	private CompatI_BlockStateContainer wrapper;

	// When called from Mod
	public Compat_BlockStateContainer(Compat_Block block, Compat_IProperty<?>[] properties) {
		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer.class, this, block.getReal(), propertiesConverted));
	}

	// When called from child
	protected Compat_BlockStateContainer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BlockStateContainer(BlockStateContainer original) {
		this.initialize(Factory.createWrapper(CompatI_BlockStateContainer.class, original));
	}

	protected void initialize(CompatI_BlockStateContainer wrapper) {
		this.wrapper = wrapper;
	}

	public BlockStateContainer getReal() {
		return wrapper.get();
	}

	public ImmutableList<Compat_IBlockState> Compat_func_177619_a() {
		ImmutableList<IBlockState> result = wrapper.getValidStatesSuper();

		List<Compat_IBlockState> ret = new ArrayList<>();

		for (IBlockState state : result) {
			ret.add(new Wrapper_IBlockState(state));
		}

		return ImmutableList.copyOf(ret);
	}

	public Compat_IBlockState Compat_func_177621_b() {
		IBlockState result = wrapper.getBaseStateSuper();
		return Compat_IBlockState.getFake(result);
	}
}
