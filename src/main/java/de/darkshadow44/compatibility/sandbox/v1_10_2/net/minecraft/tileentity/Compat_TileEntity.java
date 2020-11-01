package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.autogen.HasCallback;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network.Compat_NetworkManager;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network.play.server.Compat_SPacketUpdateTileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ITickable;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities.Compat_Capability;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;

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

	@Callback
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return Compat_hasCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.map_real_to_fake(facing));
	}

	@HasCallback
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

	@SuppressWarnings("unchecked")
	@Callback
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return (T) Compat_getCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.map_real_to_fake(facing));
	}

	@HasCallback
	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		if (original == null)
			return thisReal.getCapabilitySuper(capability.getReal(), facing2);
		else
			return original.getCapability(capability.getReal(), facing2);
	}

	public void update() {
		if (this instanceof Compat_ITickable) {
			((Compat_ITickable) this).Compat_func_73660_a();
		}
	}

	@Callback
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		Compat_func_189515_b(new Compat_NBTTagCompound(compound));
		return compound;
	}

	@HasCallback
	public Compat_NBTTagCompound Compat_func_189515_b(Compat_NBTTagCompound tag) {
		if (original == null)
			thisReal.writeToNBTSuper(tag.getReal());
		else
			original.writeToNBT(tag.getReal());
		return tag;
	}

	@Callback
	public void readFromNBT(NBTTagCompound compound) {
		Compat_func_145839_a(new Compat_NBTTagCompound(compound));
	}

	@HasCallback
	public void Compat_func_145839_a(Compat_NBTTagCompound tag) {
		if (original == null)
			thisReal.readFromNBTSuper(tag.getReal());
		else
			original.readFromNBT(tag.getReal());
	}

	@Callback
	public NBTTagCompound getUpdateTag() {
		return Compat_func_189517_E_().getReal();
	}

	@HasCallback
	public Compat_NBTTagCompound Compat_func_189517_E_() {
		NBTTagCompound result;
		if (original == null)
			result = thisReal.getUpdateTagSuper();
		else
			result = original.getUpdateTag();
		return new Compat_NBTTagCompound(result);
	}

	@Callback
	public SPacketUpdateTileEntity getUpdatePacket() {
		return Compat_func_189518_D_().getReal();
	}

	@HasCallback
	public Compat_SPacketUpdateTileEntity Compat_func_189518_D_() {
		SPacketUpdateTileEntity result;
		if (original == null)
			result = thisReal.getUpdatePacketSuper();
		else
			result = original.getUpdatePacket();
		return new Compat_SPacketUpdateTileEntity(result);
	}

	@Callback
	public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet) {
		Compat_onDataPacket(new Compat_NetworkManager(manager), new Compat_SPacketUpdateTileEntity(packet));
	}

	@HasCallback
	public void Compat_onDataPacket(Compat_NetworkManager manager, Compat_SPacketUpdateTileEntity packet) {
		if (original == null)
			thisReal.onDataPacketSuper(manager.getReal(), packet.getReal());
		else
			original.onDataPacket(manager.getReal(), packet.getReal());
	}

	@Callback
	public void handleUpdateTag(NBTTagCompound tag) {
		Compat_handleUpdateTag(new Compat_NBTTagCompound(tag));
	}

	@HasCallback
	public void Compat_handleUpdateTag(Compat_NBTTagCompound tag) {
		if (original == null)
			thisReal.handleUpdateTagSuper(tag.getReal());
		else
			original.handleUpdateTag(tag.getReal());
	}

	@Callback
	public AxisAlignedBB getRenderBoundingBox() {
		return Compat_getRenderBoundingBox().getReal();
	}

	@HasCallback
	public Compat_AxisAlignedBB Compat_getRenderBoundingBox() {
		AxisAlignedBB result;
		if (original == null)
			result = thisReal.getRenderBoundingBoxSuper();
		else
			result = original.getRenderBoundingBox();
		return new Compat_AxisAlignedBB(result);
	}

	@Callback
	public boolean shouldRenderInPass(int pass) {
		return Compat_shouldRenderInPass(pass);
	}

	@HasCallback
	public boolean Compat_shouldRenderInPass(int pass) {
		if (original == null)
			return thisReal.shouldRenderInPassSuper(pass);
		else
			return original.shouldRenderInPass(pass);
	}

	@Callback
	public boolean hasFastRenderer() {
		return Compat_hasFastRenderer();
	}

	@HasCallback
	public boolean Compat_hasFastRenderer() {
		if (original == null)
			return thisReal.hasFastRendererSuper();
		else
			return original.hasFastRenderer();
	}

	@Callback
	public void onLoad() {
		Compat_onLoad();
	}

	@HasCallback
	public void Compat_onLoad() {
		if (original == null)
			thisReal.onLoadSuper();
		else
			original.onLoad();
	}

	@Callback
	public void onChunkUnload() {
		Compat_onChunkUnload();
	}

	@HasCallback
	public void Compat_onChunkUnload() {
		if (original == null)
			thisReal.onChunkUnloadSuper();
		else
			original.onChunkUnload();
	}

	@Callback
	public boolean canRenderBreaking() {
		return Compat_canRenderBreaking();
	}

	@HasCallback
	public boolean Compat_canRenderBreaking() {
		if (original == null)
			return thisReal.canRenderBreakingSuper();
		else
			return original.canRenderBreaking();

	}

}
