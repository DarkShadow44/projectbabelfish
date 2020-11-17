package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelManager;
import compat.sandbox.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import net.minecraft.client.renderer.BlockModelShapes;

public class Compat_BlockModelShapes {

	private final BlockModelShapes original;

	public Compat_BlockModelShapes(BlockModelShapes original) {
		this.original = original;
	}

	public BlockModelShapes getReal() {
		return original;
	}

	public Compat_ModelManager Compat_func_178126_b() {
		return new Compat_ModelManager(original.getModelManager());
	}

	public Compat_IBakedModel Compat_func_178125_b(Compat_IBlockState state) {
		return new Wrapper2_IBakedModel(original.getModelForState(state.getReal()));
	}
}
