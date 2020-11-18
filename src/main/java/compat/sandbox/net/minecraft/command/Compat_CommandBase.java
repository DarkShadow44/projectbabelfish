package compat.sandbox.net.minecraft.command;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.server.Compat_MinecraftServer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

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

	@Callback
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Compat_func_184881_a(Compat_MinecraftServer.getFake(server), Compat_ICommandSender.getFake(sender), args);
	}

	@HasCallback
	public void Compat_func_184881_a(Compat_MinecraftServer server, Compat_ICommandSender sender, String[] args) throws CommandException {
		wrapper.executeSuper(server.getReal(), Compat_ICommandSender.getReal(sender), args);
	}

	@Callback
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return Compat_func_184882_a(Compat_MinecraftServer.getFake(server), Compat_ICommandSender.getFake(sender));
	}

	@HasCallback
	public boolean Compat_func_184882_a(Compat_MinecraftServer server, Compat_ICommandSender sender) {
		return wrapper.checkPermissionSuper(server.getReal(), Compat_ICommandSender.getReal(sender));
	}

	@Callback
	public String getName() {
		return Compat_func_71517_b();
	}

	@HasCallback
	public String Compat_func_71517_b() {
		return wrapper.getNameSuper();
	}

	@Callback
	public String getUsage(ICommandSender sender) {
		return Compat_func_71518_a(Compat_ICommandSender.getFake(sender));
	}

	@HasCallback
	public String Compat_func_71518_a(Compat_ICommandSender sender) {
		return wrapper.getUsageSuper(Compat_ICommandSender.getReal(sender));
	}

	@Callback
	public int getRequiredPermissionLevel() {
		return Compat_func_82362_a();
	}

	@HasCallback
	public int Compat_func_82362_a() {
		return wrapper.getRequiredPermissionLevelSuper();
	}
}
