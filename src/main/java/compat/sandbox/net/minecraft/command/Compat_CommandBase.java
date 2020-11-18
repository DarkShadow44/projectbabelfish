package compat.sandbox.net.minecraft.command;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.server.Compat_MinecraftServer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;

public class Compat_CommandBase {
	private CompatI_CommandBase wrapper;

	// When called from Mod
	public Compat_CommandBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CommandBase.class, this));
	}

	// When called from child
	protected Compat_CommandBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_CommandBase(CommandBase original) {
		this.initialize(Factory.createWrapper(CompatI_CommandBase.class, original));
	}

	protected void initialize(CompatI_CommandBase wrapper) {
		this.wrapper = wrapper;
	}

	public CommandBase getReal() {
		return wrapper.get();
	}

	public void Compat_func_184881_a(Compat_MinecraftServer server, Compat_ICommandSender sender, String[] args) throws CommandException {
		getReal().execute(server.getReal(), Compat_ICommandSender.getReal(sender), args);
	}

	public boolean Compat_func_184882_a(Compat_MinecraftServer server, Compat_ICommandSender sender) {
		return getReal().checkPermission(server.getReal(), Compat_ICommandSender.getReal(sender));
	}

	public String Compat_func_71517_b() {
		return getReal().getName();
	}

	public String Compat_func_71518_a(Compat_ICommandSender sender) {
		return getReal().getUsage(Compat_ICommandSender.getReal(sender));
	}

	public int Compat_func_82362_a() {
		return getReal().getRequiredPermissionLevel();
	}
}
