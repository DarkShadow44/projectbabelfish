package compat.sandbox.net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;

public interface CompatI_DefaultStateMapper extends CompatI_StateMapperBase {
	public DefaultStateMapper get();

	public ModelResourceLocation getModelResourceLocationSuper(IBlockState state);
}
