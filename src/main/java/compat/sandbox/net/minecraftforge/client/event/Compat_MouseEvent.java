package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.client.event.MouseEvent;

public class Compat_MouseEvent extends Compat_Event {
	private CompatI_MouseEvent wrapper;

	// When called from Mod
	public Compat_MouseEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_MouseEvent.class, this));
	}

	// When called from child
	protected Compat_MouseEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_MouseEvent(MouseEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_MouseEvent.class, original));
	}

	protected void initialize(CompatI_MouseEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public MouseEvent getReal() {
		return wrapper.get();
	}

	public int Compat_getDwheel() {
		return wrapper.getDwheelSuper();
	}
}
