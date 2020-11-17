package compat.sandbox.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.SimpleBakedModel.Builder;

public interface CompatI_SimpleBakedModel_Builder {
	public Builder get();

	public IBakedModel makeBakedModelSuper();
}
