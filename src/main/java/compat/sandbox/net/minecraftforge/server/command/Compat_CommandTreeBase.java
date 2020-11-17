package compat.sandbox.net.minecraftforge.server.command;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.command.Compat_CommandBase;
import compat.sandbox.net.minecraft.command.Compat_ICommand;
import net.minecraftforge.server.command.CommandTreeBase;

public class Compat_CommandTreeBase extends Compat_CommandBase {
	private CompatI_CommandTreeBase wrapper;

	// When called from Mod
	public Compat_CommandTreeBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CommandTreeBase.class, this));
	}

	// When called from child
	protected Compat_CommandTreeBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_CommandTreeBase(CommandTreeBase original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_CommandTreeBase.class, original));
	}

	protected void initialize(CompatI_CommandTreeBase wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public CommandTreeBase getReal() {
		return wrapper.get();
	}

	public void Compat_addSubcommand(Compat_ICommand command) {
		wrapper.addSubcommandSuper(getReal());
	}
}
