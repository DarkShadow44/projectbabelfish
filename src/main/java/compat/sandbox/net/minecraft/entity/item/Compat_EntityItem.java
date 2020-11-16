package compat.sandbox.net.minecraft.entity.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.item.EntityItem;

public class Compat_EntityItem extends Compat_Entity {
	private CompatI_EntityItem wrapper;

	// When called from Mod
	public Compat_EntityItem(Compat_World world, double x, double y, double z, Compat_ItemStack stack) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItem.class, this, world.getReal(), x, y, z, stack.getReal()));
	}

	// When called from child
	protected Compat_EntityItem(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityItem(EntityItem original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityItem.class, original));
	}

	protected void initialize(CompatI_EntityItem wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityItem getReal() {
		return wrapper.get();
	}

	public void Compat_func_174869_p() {
		wrapper.setDefaultPickupDelaySuper();
	}
}
