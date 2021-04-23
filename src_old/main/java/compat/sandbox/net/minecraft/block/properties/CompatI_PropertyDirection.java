package compat.sandbox.net.minecraft.block.properties;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public interface CompatI_PropertyDirection extends CompatI_PropertyEnum<EnumFacing> {
	public PropertyDirection get();
}
