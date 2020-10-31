package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network.play.server;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public class Compat_SPacketUpdateTileEntity {
	private SPacketUpdateTileEntity original;
	private CompatI_SPacketUpdateTileEntity thisReal;

	// When called from Mod
	public Compat_SPacketUpdateTileEntity(Compat_BlockPos pos, int p1, Compat_NBTTagCompound tag) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_SPacketUpdateTileEntity.class, this, pos.getReal(), p1, tag.getReal()), null);
	}

	// When called from child
	protected Compat_SPacketUpdateTileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_SPacketUpdateTileEntity(SPacketUpdateTileEntity original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_SPacketUpdateTileEntity thisReal, SPacketUpdateTileEntity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public SPacketUpdateTileEntity getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_NBTTagCompound Compat_func_148857_g() {
		NBTTagCompound result;
		if (original == null)
			result = thisReal.getNbtCompoundSuper();
		else
			result = original.getNbtCompound();
		return new Compat_NBTTagCompound(result);
	}
}
