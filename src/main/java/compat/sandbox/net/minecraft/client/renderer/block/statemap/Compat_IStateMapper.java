package compat.sandbox.net.minecraft.client.renderer.block.statemap;

import java.util.Map;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;

public interface Compat_IStateMapper {
	Map<Compat_IBlockState, Compat_ModelResourceLocation> Compat_func_178130_a(Compat_Block compat_Block);
}
