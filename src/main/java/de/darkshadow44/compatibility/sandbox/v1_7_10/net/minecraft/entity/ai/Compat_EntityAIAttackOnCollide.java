package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class Compat_EntityAIAttackOnCollide extends Compat_EntityAIBase {
	private EntityAIAttackMelee original;
	private CompatI_EntityAIAttackOnCollide thisReal;

	// When called from Mod
	public Compat_EntityAIAttackOnCollide() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIAttackOnCollide.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIAttackOnCollide(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIAttackOnCollide(EntityAIAttackMelee original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIAttackOnCollide thisReal, EntityAIAttackMelee original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIAttackMelee getReal() {
		return original == null ? thisReal.get() : original;
	}
}
