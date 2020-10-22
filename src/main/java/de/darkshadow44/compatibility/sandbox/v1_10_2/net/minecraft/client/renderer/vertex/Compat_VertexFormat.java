package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.vertex.VertexFormat;

public class Compat_VertexFormat {
	private VertexFormat original;
	private CompatI_VertexFormat thisReal;

	// When called from Mod
	public Compat_VertexFormat() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_VertexFormat.class, this), null);
	}

	// When called from child
	protected Compat_VertexFormat(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_VertexFormat(VertexFormat original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_VertexFormat thisReal, VertexFormat original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public VertexFormat getReal() {
		return original == null ? thisReal.get() : original;
	}
}
