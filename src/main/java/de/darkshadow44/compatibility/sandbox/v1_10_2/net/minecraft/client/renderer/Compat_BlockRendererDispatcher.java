package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import net.minecraft.client.renderer.BlockRendererDispatcher;

public class Compat_BlockRendererDispatcher {

	private final BlockRendererDispatcher original;

	public Compat_BlockRendererDispatcher(BlockRendererDispatcher original) {
		this.original = original;
	}

	public BlockRendererDispatcher getReal() {
		return original;
	}

	public Compat_IBakedModel Compat_func_184389_a(Compat_IBlockState state) {
		return new Wrapper2_IBakedModel(original.getModelForState(state.getReal()));
	}
}
