package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt;

import java.io.IOException;
import java.io.InputStream;

import net.minecraft.nbt.CompressedStreamTools;

public class Compat_CompressedStreamTools {
	public static Compat_NBTTagCompound Compat_func_74796_a(InputStream stream) throws IOException {
		return new Compat_NBTTagCompound(CompressedStreamTools.readCompressed(stream));
	}
}
