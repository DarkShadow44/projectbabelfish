package compat.sandbox.net.minecraftforge.event.entity.living;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.event.entity.Compat_EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class Compat_LivingEvent extends Compat_EntityEvent {
	private CompatI_LivingEvent wrapper;

	// When called from Mod
	public Compat_LivingEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_LivingEvent.class, this));
	}

	// When called from child
	protected Compat_LivingEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_LivingEvent(LivingEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_LivingEvent.class, original));
	}

	protected void initialize(CompatI_LivingEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public LivingEvent getReal() {
		return wrapper.get();
	}
}
