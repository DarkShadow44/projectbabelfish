package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public interface CompatI_PacketBuffer {
	public PacketBuffer get();

	public byte[] arraySuper();

	public PacketBuffer writeEnumValueSuper(Enum<?> value);

	public ByteBuf writeBooleanSuper(boolean value);

	public PacketBuffer writeStringSuper(String value);

	public <T extends Enum<T>> T readEnumValueSuper(Class<T> clazz);

	public boolean readBooleanSuper();

	public String readStringSuper(int maxLength);

	public ByteBuf writeFloatSuper(float value);

	public ByteBuf writeIntSuper(int value);

	public PacketBuffer writeItemStackSuper(ItemStack stack);

	public float readFloatSuper();

	public int readIntSuper();

	public ItemStack readItemStackSuper();
}
