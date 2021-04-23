package compat.sandbox.net.minecraft.util.text.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.text.event.ClickEvent;

public class Compat_ClickEvent {
	private CompatI_ClickEvent wrapper;

	// When called from Mod
	public Compat_ClickEvent(Compat_ClickEvent_Action action, String str) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ClickEvent.class, this, action.getReal(), str));
	}

	// When called from child
	protected Compat_ClickEvent(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ClickEvent(ClickEvent original) {
		this.initialize(Factory.createWrapper(CompatI_ClickEvent.class, original));
	}

	protected void initialize(CompatI_ClickEvent wrapper) {
		this.wrapper = wrapper;
	}

	public ClickEvent getReal() {
		return wrapper.get();
	}
}
