package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network;

import de.darkshadow44.compatibility.sandbox.v1_10_2.io.netty.buffer.Compat_ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class Compat_ByteBufUtils {
	public static void Compat_writeUTF8String(Compat_ByteBuf to, String str) {
		ByteBufUtils.writeUTF8String(to.getReal(), str);
	}

	public static String Compat_readUTF8String(Compat_ByteBuf buf) {
		return ByteBufUtils.readUTF8String(buf.getReal());
	}
}
