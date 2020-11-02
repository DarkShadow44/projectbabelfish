package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.relauncher;

import java.lang.reflect.Field;

import de.darkshadow44.compatibility.sandbox.v1_10_2.java.lang.reflect.Compat_Field;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline.Compat_UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;

public class Compat_ReflectionHelper {
	public static Compat_Field Compat_findField(Class<?> clazz, String[] names) throws Exception {
		if (clazz == Compat_UnpackedBakedQuad.class) {
			if (names.length == 1 && names[0].equals("unpackedData")) {
				Field field = UnpackedBakedQuad.class.getDeclaredField("unpackedData");
				return new Compat_Field(field);
			}
		}

		return null;
	}
}
