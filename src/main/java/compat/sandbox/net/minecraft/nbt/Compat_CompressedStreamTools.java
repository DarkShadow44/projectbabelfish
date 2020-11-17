package compat.sandbox.net.minecraft.nbt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.minecraft.nbt.CompressedStreamTools;

public class Compat_CompressedStreamTools {
	public static Compat_NBTTagCompound Compat_func_74796_a(InputStream stream) throws IOException {
		return new Compat_NBTTagCompound(CompressedStreamTools.readCompressed(stream));
	}

	public static void Compat_func_74799_a(Compat_NBTTagCompound tag, OutputStream stream) throws IOException {
		CompressedStreamTools.writeCompressed(tag.getReal(), stream);
	}
}
