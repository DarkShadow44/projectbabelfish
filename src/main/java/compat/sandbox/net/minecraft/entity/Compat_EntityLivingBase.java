package compat.sandbox.net.minecraft.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.math.Compat_Vec3d;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class Compat_EntityLivingBase extends Compat_Entity {
	private CompatI_EntityLivingBase wrapper;

	// When called from Mod
	public Compat_EntityLivingBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLivingBase.class, this));
	}

	// When called from child
	protected Compat_EntityLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLivingBase(EntityLivingBase original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityLivingBase.class, original));
	}

	protected void initialize(CompatI_EntityLivingBase wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityLivingBase getReal() {
		return wrapper.get();
	}

	public Compat_ItemStack Compat_func_184614_ca() {
		ItemStack result = wrapper.getHeldItemMainhandSuper();
		return result == null || result.isEmpty() ? null : new Compat_ItemStack(result);
	}

	public Compat_ItemStack Compat_func_184592_cb() {
		ItemStack result = wrapper.getHeldItemOffhandSuper();
		return result == null || result.isEmpty() ? null : new Compat_ItemStack(result);
	}

	public Compat_Vec3d Compat_func_70040_Z() {
		return new Compat_Vec3d(wrapper.getLookVecSuper());
	}
}
