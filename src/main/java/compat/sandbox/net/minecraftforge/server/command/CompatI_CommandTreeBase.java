package compat.sandbox.net.minecraftforge.server.command;

import compat.sandbox.net.minecraft.command.CompatI_CommandBase;
import net.minecraft.command.ICommand;
import net.minecraftforge.server.command.CommandTreeBase;

public interface CompatI_CommandTreeBase extends CompatI_CommandBase {
	public CommandTreeBase get();

	public void addSubcommandSuper(ICommand real);
}
