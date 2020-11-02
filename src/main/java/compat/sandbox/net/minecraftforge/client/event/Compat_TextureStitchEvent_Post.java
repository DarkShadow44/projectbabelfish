package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.client.event.TextureStitchEvent.Post;

public class Compat_TextureStitchEvent_Post extends Compat_TextureStitchEvent {
	private CompatI_TextureStitchEvent_Post wrapper;

	// When called from Mod
	public Compat_TextureStitchEvent_Post() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureStitchEvent_Post.class, this));
	}

	// When called from child
	protected Compat_TextureStitchEvent_Post(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TextureStitchEvent_Post(Post original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_TextureStitchEvent_Post.class, original));
	}

	protected void initialize(CompatI_TextureStitchEvent_Post wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Post getReal() {
		return wrapper.get();
	}
}
