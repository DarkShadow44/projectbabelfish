package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;

public class Compat_TextureStitchEvent_Pre extends Compat_TextureStitchEvent {
	private Pre original;
	private CompatI_TextureStitchEvent_Pre thisReal;

	// When called from Mod
	public Compat_TextureStitchEvent_Pre() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureStitchEvent_Pre.class, this), null);
	}

	// When called from child
	protected Compat_TextureStitchEvent_Pre(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TextureStitchEvent_Pre(Pre original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TextureStitchEvent_Pre thisReal, Pre original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Pre getReal() {
		return original == null ? thisReal.get() : original;
	}
}
