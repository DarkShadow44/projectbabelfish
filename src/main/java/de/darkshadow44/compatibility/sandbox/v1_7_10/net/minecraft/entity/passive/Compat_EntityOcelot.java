package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityOcelot;

public class Compat_EntityOcelot extends Compat_EntityTameable {
	private CompatI_EntityOcelot wrapper;

	// When called from Mod
	public Compat_EntityOcelot(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityOcelot.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityOcelot(EntityOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityOcelot.class, original));
	}

	protected void initialize(CompatI_EntityOcelot wrapper) {
		this.wrapper = wrapper;
	}

	public EntityOcelot getReal() {
		return wrapper.get();
	}
}
