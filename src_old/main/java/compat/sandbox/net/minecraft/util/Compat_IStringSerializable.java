package compat.sandbox.net.minecraft.util;

import net.minecraft.util.IStringSerializable;

public interface Compat_IStringSerializable extends IStringSerializable {

	public String Compat_func_176610_l();

	public default String getName() {
		return Compat_func_176610_l();
	}
}
