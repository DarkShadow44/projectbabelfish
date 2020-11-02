package compat.sandbox.net.minecraftforge.server.command;

import compat.sandbox.net.minecraft.command.CompatI_CommandBase;
import net.minecraftforge.server.command.CommandTreeBase;

public interface CompatI_CommandTreeBase extends CompatI_CommandBase {
	public CommandTreeBase get();
}
