package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class Compat_BonemealEvent extends Compat_PlayerEvent {
	private CompatI_BonemealEvent wrapper;

	// When called from Mod
	public Compat_BonemealEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BonemealEvent.class, this));
	}

	// When called from child
	protected Compat_BonemealEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BonemealEvent(BonemealEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BonemealEvent.class, original));
	}

	protected void initialize(CompatI_BonemealEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BonemealEvent getReal() {
		return wrapper.get();
	}
}
