package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_BakedQuad;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;

public class Compat_UnpackedBakedQuad extends Compat_BakedQuad {
	private UnpackedBakedQuad original;
	private CompatI_UnpackedBakedQuad thisReal;

	// When called from Mod
	public Compat_UnpackedBakedQuad() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UnpackedBakedQuad.class, this), null);
	}

	// When called from child
	protected Compat_UnpackedBakedQuad(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_UnpackedBakedQuad(UnpackedBakedQuad original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_UnpackedBakedQuad thisReal, UnpackedBakedQuad original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public UnpackedBakedQuad getReal() {
		return original == null ? thisReal.get() : original;
	}
}
