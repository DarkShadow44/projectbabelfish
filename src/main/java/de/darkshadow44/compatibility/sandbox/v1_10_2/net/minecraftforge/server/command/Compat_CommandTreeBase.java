package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.server.command;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.command.Compat_CommandBase;
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
}
