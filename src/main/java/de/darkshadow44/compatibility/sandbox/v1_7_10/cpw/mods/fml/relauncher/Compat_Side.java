package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.relauncher;

import net.minecraftforge.fml.relauncher.Side;

public enum Compat_Side {
	COMPAT_ERROR, COMPAT_CLIENT, COMPAT_SERVER;

	public static Compat_Side fromReal(Side effectiveSide) {
		switch (effectiveSide) {
		case CLIENT:
			return COMPAT_CLIENT;
		case SERVER:
			return COMPAT_SERVER;
		}
		return COMPAT_ERROR;
	}

}
