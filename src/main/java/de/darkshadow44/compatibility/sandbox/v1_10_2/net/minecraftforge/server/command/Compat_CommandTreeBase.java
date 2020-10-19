package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.server.command;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.command.Compat_CommandBase;
import net.minecraftforge.server.command.CommandTreeBase;

public class Compat_CommandTreeBase extends Compat_CommandBase {
	private CommandTreeBase original;
	private CompatI_CommandTreeBase thisReal;

	// When called from Mod
	public Compat_CommandTreeBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CommandTreeBase.class, this), null);
	}

	// When called from child
	protected Compat_CommandTreeBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_CommandTreeBase(CommandTreeBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_CommandTreeBase thisReal, CommandTreeBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public CommandTreeBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
