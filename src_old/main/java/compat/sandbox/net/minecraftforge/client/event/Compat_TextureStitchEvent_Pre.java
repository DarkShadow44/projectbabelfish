package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;

public class Compat_TextureStitchEvent_Pre extends Compat_TextureStitchEvent {
	private CompatI_TextureStitchEvent_Pre wrapper;

	// When called from Mod
	public Compat_TextureStitchEvent_Pre() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureStitchEvent_Pre.class, this));
	}

	// When called from child
	protected Compat_TextureStitchEvent_Pre(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TextureStitchEvent_Pre(Pre original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_TextureStitchEvent_Pre.class, original));
	}

	protected void initialize(CompatI_TextureStitchEvent_Pre wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Pre getReal() {
		return wrapper.get();
	}
}
