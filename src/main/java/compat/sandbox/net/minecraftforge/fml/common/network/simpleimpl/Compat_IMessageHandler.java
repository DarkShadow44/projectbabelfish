package compat.sandbox.net.minecraftforge.fml.common.network.simpleimpl;

import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface Compat_IMessageHandler<REQ extends Compat_IMessage, REPLY extends Compat_IMessage> extends IMessageHandler<REQ, REPLY> {
	public default REPLY onMessage(REQ msg, MessageContext context) {
		return Compat_onMessage(msg, new Compat_MessageContext(context));
	}

	public REPLY Compat_onMessage(REQ msg, Compat_MessageContext context);

}