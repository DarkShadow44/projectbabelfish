package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;

public interface CompatI_PacketBuffer {
	public PacketBuffer get();

	public byte[] arraySuper();

	public PacketBuffer writeEnumValueSuper(Enum<?> value);

	public ByteBuf writeBooleanSuper(boolean value);

	public PacketBuffer writeStringSuper(String value);
}
