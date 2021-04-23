package compat.sandbox.net.minecraft.network;

import java.util.UUID;

import compat.sandbox.io.netty.buffer.CompatI_ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

public interface CompatI_PacketBuffer extends CompatI_ByteBuf {
	public PacketBuffer get();

	public PacketBuffer writeEnumValueSuper(Enum<?> value);

	public PacketBuffer writeStringSuper(String value);

	public <T extends Enum<T>> T readEnumValueSuper(Class<T> clazz);

	public String readStringSuper(int maxLength);

	public PacketBuffer writeItemStackSuper(ItemStack stack);

	public ItemStack readItemStackSuper();

	public PacketBuffer writeCompoundTagSuper(NBTTagCompound tag);

	public NBTTagCompound readCompoundTagSuper();

	public PacketBuffer writeByteArraySuper(byte[] value);

	public byte[] readByteArraySuper();

	public PacketBuffer writeUniqueIdSuper(UUID uuid);

	public UUID readUniqueIdSuper();

	public PacketBuffer writeBlockPosSuper(BlockPos real);

	public BlockPos readBlockPosSuper();

	public int[] readVarIntArraySuper();

	public PacketBuffer writeVarIntArraySuper(int[] value);
}
