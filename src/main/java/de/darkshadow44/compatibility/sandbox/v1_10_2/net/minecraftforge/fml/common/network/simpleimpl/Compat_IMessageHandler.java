package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network.simpleimpl;

import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;

public interface Compat_IMessageHandler<REQ extends Compat_IMessage, REPLY extends Compat_IMessage>  extends IMessageHandler<REQ, REPLY> {

}