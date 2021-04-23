package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class Compat_UseHoeEvent extends Compat_PlayerEvent {
	private CompatI_UseHoeEvent wrapper;

	// When called from Mod
	public Compat_UseHoeEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UseHoeEvent.class, this));
	}

	// When called from child
	protected Compat_UseHoeEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_UseHoeEvent(UseHoeEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_UseHoeEvent.class, original));
	}

	protected void initialize(CompatI_UseHoeEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public UseHoeEvent getReal() {
		return wrapper.get();
	}
}
