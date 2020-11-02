package compat.sandbox.net.minecraftforge.fml.common.network.simpleimpl;

import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public interface CompatI_MessageContext {
	public MessageContext get();

	public Side get_side();
}
