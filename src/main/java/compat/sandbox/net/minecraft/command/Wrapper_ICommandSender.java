package compat.sandbox.net.minecraft.command;

import compat.sandbox.net.minecraft.server.Compat_MinecraftServer;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.command.ICommandSender;

public class Wrapper_ICommandSender implements Compat_ICommandSender {
	private final ICommandSender original;

	public Wrapper_ICommandSender(ICommandSender original) {
		this.original = original;
	}

	public ICommandSender getReal() {
		return original;
	}

	@Override
	public boolean Compat_canUseCommand(int arg0, String arg1) {
		return original.canUseCommand(arg0, arg1);
	}

	@Override
	public Compat_World Compat_getEntityWorld() {
		return Compat_World.getFake(original.getEntityWorld());
	}

	@Override
	public String Compat_getName() {
		return original.getName();
	}

	@Override
	public Compat_MinecraftServer Compat_getServer() {
		return Compat_MinecraftServer.getFake(original.getServer());
	}
}
