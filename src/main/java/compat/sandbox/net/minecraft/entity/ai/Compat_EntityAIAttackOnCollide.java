package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class Compat_EntityAIAttackOnCollide extends Compat_EntityAIBase {
	private CompatI_EntityAIAttackOnCollide wrapper;

	// When called from Mod
	public Compat_EntityAIAttackOnCollide() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIAttackOnCollide.class, this));
	}

	// When called from child
	protected Compat_EntityAIAttackOnCollide(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIAttackOnCollide(EntityAIAttackMelee original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIAttackOnCollide.class, original));
	}

	protected void initialize(CompatI_EntityAIAttackOnCollide wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIAttackMelee getReal() {
		return wrapper.get();
	}
}