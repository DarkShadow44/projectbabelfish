package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

public class Compat_Entity {
	private Entity original;
	private CompatI_Entity thisReal;

	// When called from Mod
	public Compat_Entity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Entity.class, this), null);
	}

	// When called from child
	protected Compat_Entity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Entity(Entity original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Entity thisReal, Entity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Entity getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_World Compat_get_field_70170_p() {
		if (original == null)
			return Compat_World.get_fake(thisReal.get_world());
		else
			return Compat_World.get_fake(original.world);
	}

	public boolean Compat_func_70093_af() {
		if (original == null)
			return thisReal.isSneakingSuper();
		else
			return original.isSneaking();
	}

	public Compat_EnumFacing Compat_func_174811_aO() {
		EnumFacing ret;
		if (original == null)
			ret = thisReal.getHorizontalFacingSuper();
		else
			ret = original.getHorizontalFacing();
		return Compat_EnumFacing.map_real_to_fake(ret);
	}
}
