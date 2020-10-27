package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public interface CompatI_TileEntity {
	public TileEntity get();

	public Compat_TileEntity getFake();

	public World getWorldSuper();

	public BlockPos getPosSuper();

	public boolean hasCapabilitySuper(Capability<?> capability, EnumFacing facing);
}
