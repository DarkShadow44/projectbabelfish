package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.client.event.TextureStitchEvent.Post;

public class Compat_TextureStitchEvent_Post extends Compat_TextureStitchEvent {
	private Post original;
	private CompatI_TextureStitchEvent_Post thisReal;

	// When called from Mod
	public Compat_TextureStitchEvent_Post() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureStitchEvent_Post.class, this), null);
	}

	// When called from child
	protected Compat_TextureStitchEvent_Post(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TextureStitchEvent_Post(Post original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TextureStitchEvent_Post thisReal, Post original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Post getReal() {
		return original == null ? thisReal.get() : original;
	}
}
