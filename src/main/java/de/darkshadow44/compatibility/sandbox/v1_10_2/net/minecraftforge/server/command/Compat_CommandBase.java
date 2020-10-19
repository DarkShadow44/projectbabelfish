package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.server.command;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.command.CommandBase;

public class Compat_CommandBase {
	private CommandBase original;
	private CompatI_CommandBase thisReal;

	// When called from Mod
	public Compat_CommandBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CommandBase.class, this), null);
	}

	// When called from child
	protected Compat_CommandBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_CommandBase(CommandBase original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_CommandBase thisReal, CommandBase original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public CommandBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
