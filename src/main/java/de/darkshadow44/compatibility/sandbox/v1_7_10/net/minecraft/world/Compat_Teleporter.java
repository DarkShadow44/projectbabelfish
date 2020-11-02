package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.Teleporter;

public class Compat_Teleporter {
	private CompatI_Teleporter wrapper;

	// When called from Mod
	public Compat_Teleporter(Compat_WorldServer world) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Teleporter.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_Teleporter(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Teleporter(Teleporter original) {
		this.initialize(Factory.createWrapper(CompatI_Teleporter.class, original));
	}

	protected void initialize(CompatI_Teleporter wrapper) {
		this.wrapper = wrapper;
	}

	public Teleporter getReal() {
		return wrapper.get();
	}
}
