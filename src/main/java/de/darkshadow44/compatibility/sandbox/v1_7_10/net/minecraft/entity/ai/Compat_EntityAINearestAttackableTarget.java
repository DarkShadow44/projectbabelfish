package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
