package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class Compat_EntityAIAttackMelee extends Compat_EntityAIBase {
	private CompatI_EntityAIAttackMelee wrapper;

	// When called from Mod
	public Compat_EntityAIAttackMelee() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIAttackMelee.class, this));
	}

	// When called from child
	protected Compat_EntityAIAttackMelee(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIAttackMelee(EntityAIAttackMelee original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIAttackMelee.class, original));
	}

	protected void initialize(CompatI_EntityAIAttackMelee wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIAttackMelee getReal() {
		return wrapper.get();
	}
}
