package compat.sandbox.net.minecraftforge.fml.relauncher;

import net.minecraftforge.fml.relauncher.Side;

public enum Compat_Side {
	CLIENT(Side.CLIENT),
	SERVER(Side.SERVER);

	private Side original;

	private Compat_Side(Side original) {
		this.original = original;
	}

	public static Compat_Side fromReal(Side effectiveSide) {
		switch (effectiveSide) {
		case CLIENT:
			return CLIENT;
		case SERVER:
			return SERVER;
		}
		return null;
	}

	public static Compat_Side Compat_get_CLIENT() {
		return CLIENT;
	}

	public static Compat_Side Compat_get_SERVER() {
		return SERVER;
	}

	public Side getReal() {
		return original;
	}

}
