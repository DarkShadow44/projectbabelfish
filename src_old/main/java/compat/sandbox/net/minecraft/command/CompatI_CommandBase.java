package compat.sandbox.net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public interface CompatI_CommandBase {
	public CommandBase get();

	public void executeSuper(MinecraftServer server, ICommandSender sender, String[] args);

	public boolean checkPermissionSuper(MinecraftServer server, ICommandSender sender);

	public String getNameSuper();

	public String getUsageSuper(ICommandSender sender);

	public int getRequiredPermissionLevelSuper();
}
