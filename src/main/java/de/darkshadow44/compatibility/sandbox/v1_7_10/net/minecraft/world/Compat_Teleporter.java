package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.Teleporter;

public class Compat_Teleporter {
	private Teleporter original;
	private CompatI_Teleporter thisReal;

	// When called from Mod
	public Compat_Teleporter(Compat_WorldServer world) {
		this.initialize(Factory.create(CtorPos.POS1, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_Teleporter(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Teleporter(Teleporter original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Teleporter thisReal, Teleporter original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Teleporter getReal() {
		return original == null ? thisReal.get() : original;
	}
}
