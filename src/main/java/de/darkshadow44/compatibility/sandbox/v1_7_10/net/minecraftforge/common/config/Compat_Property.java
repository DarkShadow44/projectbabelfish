package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.common.config;

import net.minecraftforge.common.config.Property;

public class Compat_Property {
	private final Property original;

	public Compat_Property(Property original) {
		this.original = original;
	}

	public boolean Compat_getBoolean(boolean _default) {
		return original.getBoolean(_default);
	}

	public int Compat_getInt() {
		return original.getInt();
	}

	public String[] Compat_getStringList() {
		return original.getStringList();
	}

	public double Compat_getDouble(double _default) {
		return original.getDouble(_default);
	}
}
