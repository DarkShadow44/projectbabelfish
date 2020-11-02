package compat.sandbox.net.minecraft.network;

import compat.sandbox.io.netty.buffer.CompatI_ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public interface CompatI_PacketBuffer extends CompatI_ByteBuf {
	public PacketBuffer get();

	public PacketBuffer writeEnumValueSuper(Enum<?> value);

	public PacketBuffer writeStringSuper(String value);

	public <T extends Enum<T>> T readEnumValueSuper(Class<T> clazz);

	public String readStringSuper(int maxLength);

	public PacketBuffer writeItemStackSuper(ItemStack stack);

	public ItemStack readItemStackSuper();
}
