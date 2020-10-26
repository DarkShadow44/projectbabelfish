package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_IBlockAccess;
import net.minecraft.client.renderer.BlockModelRenderer;

public class Compat_BlockModelRenderer {

	private final BlockModelRenderer original;

	public Compat_BlockModelRenderer(BlockModelRenderer original) {
		this.original = original;
	}

	public BlockModelRenderer getReal() {
		return original;
	}

	public boolean Compat_func_178267_a(Compat_IBlockAccess world, Compat_IBakedModel model, Compat_IBlockState state, Compat_BlockPos pos, Compat_VertexBuffer buffer, boolean p1) {
		return original.renderModel(world.getReal(), Compat_IBakedModel.getReal(model), state.getReal(), pos.getReal(), buffer.getReal(), p1);
	}
}
