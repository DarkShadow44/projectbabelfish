package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class Compat_EntityAINearestAttackableTarget<T extends EntityLivingBase> extends Compat_EntityAITarget {
	private CompatI_EntityAINearestAttackableTarget<T> wrapper;

	// When called from Mod
	public Compat_EntityAINearestAttackableTarget() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAINearestAttackableTarget.class, this));
	}

	// When called from child
	protected Compat_EntityAINearestAttackableTarget(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAINearestAttackableTarget(EntityAINearestAttackableTarget<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAINearestAttackableTarget.class, original));
	}

	protected void initialize(CompatI_EntityAINearestAttackableTarget<T> wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAINearestAttackableTarget<T> getReal() {
		return wrapper.get();
	}
}
