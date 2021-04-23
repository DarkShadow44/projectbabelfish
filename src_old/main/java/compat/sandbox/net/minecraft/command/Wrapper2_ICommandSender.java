package compat.sandbox.net.minecraft.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class Wrapper2_ICommandSender implements ICommandSender {

	private final Compat_ICommandSender original;

	public Wrapper2_ICommandSender(Compat_ICommandSender original) {
		this.original = original;
	}

	public Compat_ICommandSender getFake() {
		return original;
	}

	@Override
	public boolean canUseCommand(int arg0, String arg1) {
		return original.Compat_canUseCommand(arg0, arg1);
	}

	@Override
	public World getEntityWorld() {
		return original.Compat_getEntityWorld().getReal();
	}

	@Override
	public String getName() {
		return original.Compat_getName();
	}

	@Override
	public MinecraftServer getServer() {
		return original.Compat_getServer().getReal();
	}

}
