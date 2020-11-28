package compat.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import compat.mixinhelper.ForgeBlockModelRendererHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.pipeline.ForgeBlockModelRenderer;
import net.minecraftforge.client.model.pipeline.VertexLighterFlat;

@Mixin(ForgeBlockModelRenderer.class)
public class MixinForgeBlockModelRenderer {

	@Inject(method = "render", locals = LocalCapture.CAPTURE_FAILHARD, require = 1, at = @At("HEAD"))
	private static void renderInject(VertexLighterFlat lighter, IBlockAccess world, IBakedModel model, IBlockState state, BlockPos pos, BufferBuilder wr, boolean checkSides, long rand, CallbackInfoReturnable<Boolean> callback) {
		ForgeBlockModelRendererHelper.currentPos = pos;
		ForgeBlockModelRendererHelper.currentWorld = world;
	}

}
