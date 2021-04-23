package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class Compat_PlayerEvent extends Compat_Event {
	private CompatI_PlayerEvent wrapper;

	// When called from Mod
	public Compat_PlayerEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerEvent.class, this));
	}

	// When called from child
	protected Compat_PlayerEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerEvent(PlayerEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerEvent.class, original));
	}

	protected void initialize(CompatI_PlayerEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PlayerEvent getReal() {
		return wrapper.get();
	}
}
