package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.Tessellator;

public class Compat_Tessellator {
	private Tessellator original;
	private CompatI_Tessellator thisReal;

	// When called from Mod
	public Compat_Tessellator(int p1) {
		this.initialize(Factory.create(CtorPos.POS1, this, p1), null);
	}

	// When called from child
	protected Compat_Tessellator(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Tessellator(Tessellator original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Tessellator thisReal, Tessellator original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Tessellator getReal() {
		return original == null ? thisReal.get() : original;
	}
}
