package compat.sandbox.net.minecraftforge.event.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.event.entity.EntityEvent;

public class Compat_EntityEvent extends Compat_Event {
	private CompatI_EntityEvent wrapper;

	// When called from Mod
	public Compat_EntityEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityEvent.class, this));
	}

	// When called from child
	protected Compat_EntityEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityEvent(EntityEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityEvent.class, original));
	}

	protected void initialize(CompatI_EntityEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityEvent getReal() {
		return wrapper.get();
	}
}
