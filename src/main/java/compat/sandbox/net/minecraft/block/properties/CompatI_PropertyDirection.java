package compat.sandbox.net.minecraft.block.properties;

import net.minecraft.state.DirectionProperty;
import net.minecraft.util.EnumFacing;

public interface CompatI_PropertyDirection extends CompatI_PropertyEnum<EnumFacing> {
	public DirectionProperty get();
}
