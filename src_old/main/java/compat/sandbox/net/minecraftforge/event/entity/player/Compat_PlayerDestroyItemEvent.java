package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class Compat_PlayerDestroyItemEvent extends Compat_PlayerEvent {
	private CompatI_PlayerDestroyItemEvent wrapper;

	// When called from Mod
	public Compat_PlayerDestroyItemEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerDestroyItemEvent.class, this));
	}

	// When called from child
	protected Compat_PlayerDestroyItemEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerDestroyItemEvent(PlayerDestroyItemEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerDestroyItemEvent.class, original));
	}

	protected void initialize(CompatI_PlayerDestroyItemEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PlayerDestroyItemEvent getReal() {
		return wrapper.get();
	}
}
