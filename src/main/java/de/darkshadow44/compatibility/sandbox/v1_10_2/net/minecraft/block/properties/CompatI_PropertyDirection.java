package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public interface CompatI_PropertyDirection extends CompatI_PropertyEnum<EnumFacing> {
	public PropertyDirection get();
}
