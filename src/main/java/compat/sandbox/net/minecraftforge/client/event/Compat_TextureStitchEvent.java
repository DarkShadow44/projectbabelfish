package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.client.event.TextureStitchEvent;

public class Compat_TextureStitchEvent extends Compat_Event {
	private CompatI_TextureStitchEvent wrapper;

	// When called from Mod
	public Compat_TextureStitchEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureStitchEvent.class, this));
	}

	// When called from child
	protected Compat_TextureStitchEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TextureStitchEvent(TextureStitchEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_TextureStitchEvent.class, original));
	}

	protected void initialize(CompatI_TextureStitchEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public TextureStitchEvent getReal() {
		return wrapper.get();
	}
}
