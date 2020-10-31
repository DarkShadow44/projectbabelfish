package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities.Compat_Capability;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class Compat_TileEntity {
	private TileEntity original;
	private CompatI_TileEntity thisReal;

	// When called from Mod
	public Compat_TileEntity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntity.class, this), null);
	}

	// When called from child
	protected Compat_TileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntity(TileEntity original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TileEntity thisReal, TileEntity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public static Compat_TileEntity get_fake(TileEntity real) {
		if (real instanceof CompatI_TileEntity) {
			return ((CompatI_TileEntity) real).getFake();
		}
		return new Compat_TileEntity(real);
	}

	public TileEntity getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_World Compat_func_145831_w() {
		if (original == null)
			return Compat_World.get_fake(thisReal.getWorldSuper());
		else
			return Compat_World.get_fake(original.getWorld());
	}

	public Compat_BlockPos Compat_func_174877_v() {
		if (original == null)
			return new Compat_BlockPos(thisReal.getPosSuper());
		else
			return new Compat_BlockPos(original.getPos());
	}

	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		if (thisReal == null && original == null) {
			// Must be a call during constructor
			return false;
		}
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		if (original == null)
			return thisReal.hasCapabilitySuper(capability.getReal(), facing2);
		else
			return original.hasCapability(capability.getReal(), facing2);
	}

	public static Compat_TileEntity getFake(TileEntity real) {
		if (real instanceof CompatI_TileEntity) {
			return ((CompatI_TileEntity) real).getFake();
		}
		return new Compat_TileEntity(real);
	}

	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		if (original == null)
			return thisReal.getCapabilitySuper(capability.getReal(), facing2);
		else
			return original.getCapability(capability.getReal(), facing2);
	}
}
