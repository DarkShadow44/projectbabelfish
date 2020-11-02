package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network.play.server;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public class Compat_SPacketUpdateTileEntity {
	private CompatI_SPacketUpdateTileEntity wrapper;

	// When called from Mod
	public Compat_SPacketUpdateTileEntity(Compat_BlockPos pos, int p1, Compat_NBTTagCompound tag) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_SPacketUpdateTileEntity.class, this, pos.getReal(), p1, tag.getReal()));
	}

	// When called from child
	protected Compat_SPacketUpdateTileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_SPacketUpdateTileEntity(SPacketUpdateTileEntity original) {
		this.initialize(Factory.createWrapper(CompatI_SPacketUpdateTileEntity.class, original));
	}

	protected void initialize(CompatI_SPacketUpdateTileEntity wrapper) {
		this.wrapper = wrapper;
	}

	public SPacketUpdateTileEntity getReal() {
		return wrapper.get();
	}

	public Compat_NBTTagCompound Compat_func_148857_g() {
		NBTTagCompound result = wrapper.getNbtCompoundSuper();
		return new Compat_NBTTagCompound(result);
	}
}
