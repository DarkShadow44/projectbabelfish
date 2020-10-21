package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public interface CompatI_PropertyEnum<T extends Enum<T> & IStringSerializable> extends CompatI_PropertyHelper<T> {
	public PropertyEnum<T> get();
}
