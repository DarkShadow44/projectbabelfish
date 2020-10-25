package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network.simpleimpl;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public interface Compat_IMessage extends IMessage {
	public default void toBytes(ByteBuf buf) {
		Compat_toBytes(buf);
	}

	public default void fromBytes(ByteBuf buf) {
		Compat_fromBytes(buf);
	}

	public void Compat_toBytes(ByteBuf buf);

	public void Compat_fromBytes(ByteBuf buf);
}
