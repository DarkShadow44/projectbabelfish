package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.IStringSerializable;

public interface Compat_IStringSerializable extends IStringSerializable {

	public String Compat_func_176610_l();

	public default String getName() {
		return Compat_func_176610_l();
	}
}
