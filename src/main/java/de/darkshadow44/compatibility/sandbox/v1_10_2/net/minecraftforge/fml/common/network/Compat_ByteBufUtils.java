package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class Compat_ByteBufUtils {
	public static void Compat_writeUTF8String(ByteBuf to, String str) {
		ByteBufUtils.writeUTF8String(to, str);
	}
}
