package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Compat_FMLLog {

	private static final Logger log = LogManager.getLogger("FML");

	public static void Compat_info(String format, Object... data) {
		log.log(Level.INFO, format, data);
	}
}
