package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.command;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.command.CommandBase;

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
}
