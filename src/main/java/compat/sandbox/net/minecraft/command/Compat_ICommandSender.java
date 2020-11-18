package compat.sandbox.net.minecraft.command;

import compat.sandbox.net.minecraft.server.Compat_MinecraftServer;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.command.ICommandSender;

public interface Compat_ICommandSender {

	public boolean Compat_canUseCommand(int arg0, String arg1);

	public Compat_World Compat_getEntityWorld();

	public String Compat_getName();

	public Compat_MinecraftServer Compat_getServer();

	public static Compat_ICommandSender getFake(ICommandSender real) {
		if (real instanceof Wrapper2_ICommandSender) {
			return ((Wrapper2_ICommandSender) real).getFake();
		}
		return new Wrapper_ICommandSender(real);
	}

	public static ICommandSender getReal(Compat_ICommandSender fake) {
		if (fake instanceof Wrapper_ICommandSender) {
			return ((Wrapper_ICommandSender) fake).getReal();
		}
		return new Wrapper2_ICommandSender(fake);
	}
}
