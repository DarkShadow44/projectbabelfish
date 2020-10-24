package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.relauncher;

import net.minecraftforge.fml.relauncher.Side;

public class Compat_Side {
	private final static Compat_Side ERROR = new Compat_Side(null);
	private final static Compat_Side CLIENT = new Compat_Side(Side.CLIENT);
	private final static Compat_Side SERVER = new Compat_Side(Side.SERVER);

	private Side original;

	public Compat_Side(Side original) {
		this.original = original;
	}

	public static Compat_Side fromReal(Side effectiveSide) {
		switch (effectiveSide) {
		case CLIENT:
			return CLIENT;
		case SERVER:
			return SERVER;
		}
		return ERROR;
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
