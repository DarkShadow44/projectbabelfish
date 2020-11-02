package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIMoveIndoors;

public class Compat_EntityAIMoveIndoors extends Compat_EntityAIBase {
	private CompatI_EntityAIMoveIndoors wrapper;

	// When called from Mod
	public Compat_EntityAIMoveIndoors() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIMoveIndoors.class, this));
	}

	// When called from child
	protected Compat_EntityAIMoveIndoors(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIMoveIndoors(EntityAIMoveIndoors original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIMoveIndoors.class, original));
	}

	protected void initialize(CompatI_EntityAIMoveIndoors wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIMoveIndoors getReal() {
		return wrapper.get();
	}
}
