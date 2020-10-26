package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class Compat_EntityLivingBase extends Compat_Entity {
	private EntityLivingBase original;
	private CompatI_EntityLivingBase thisReal;

	// When called from Mod
	public Compat_EntityLivingBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLivingBase.class, this), null);
	}

	// When called from child
	protected Compat_EntityLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLivingBase(EntityLivingBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityLivingBase thisReal, EntityLivingBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityLivingBase getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_ItemStack Compat_func_184614_ca() {
		ItemStack stack;
		if (original == null)
			stack = thisReal.getHeldItemMainhandSuper();
		else
			stack = original.getHeldItemMainhand();
		return stack == null ? null : new Compat_ItemStack(stack);
	}

	public Compat_ItemStack Compat_func_184592_cb() {
		ItemStack stack;
		if (original == null)
			stack = thisReal.getHeldItemOffhandSuper();
		else
			stack = original.getHeldItemOffhand();
		return stack == null ? null : new Compat_ItemStack(stack);
	}
}
