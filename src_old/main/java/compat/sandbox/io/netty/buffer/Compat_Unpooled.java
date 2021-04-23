package compat.sandbox.io.netty.buffer;

import io.netty.buffer.Unpooled;

public class Compat_Unpooled {
	public static Compat_ByteBuf Compat_buffer() {
		return new Compat_ByteBuf(Unpooled.buffer());
	}

	public static Compat_ByteBuf Compat_copiedBuffer(byte[] data) {
		return new Compat_ByteBuf(Unpooled.copiedBuffer(data));
	}
}
