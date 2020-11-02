package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_BakedQuad;
import net.minecraftforge.client.model.pipeline.LightUtil;

public class Compat_LightUtil {
	public static void Compat_putBakedQuad(Compat_IVertexConsumer consumer, Compat_BakedQuad quad) {
		LightUtil.putBakedQuad(new Wrapper_IVertexConsumer(consumer), quad.getReal());
	}
}
