package compat.sandbox.net.minecraft.tileentity;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.core.Version;
import compat.sandbox.net.minecraft.nbt.Compat_NBTTagCompound;
import compat.sandbox.net.minecraft.network.Compat_NetworkManager;
import compat.sandbox.net.minecraft.network.Compat_Packet;
import compat.sandbox.net.minecraft.network.play.server.Compat_SPacketUpdateTileEntity;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_ITickable;
import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_Capability;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;

public class Compat_TileEntity {
	private CompatI_TileEntity wrapper;

	private Version version = Version.UNKNOWN;

	// When called from Mod
	public Compat_TileEntity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntity.class, this));
	}

	// When called from child
	protected Compat_TileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntity(TileEntity original) {
		this.initialize(Factory.createWrapper(CompatI_TileEntity.class, original));
	}

	protected void initialize(CompatI_TileEntity wrapper) {
		this.version = Version.get(this);
		this.wrapper = wrapper;
	}

	public static Compat_TileEntity getFake(TileEntity real) {
		if (real == null)
			return null;
		if (real instanceof CompatI_TileEntity) {
			return ((CompatI_TileEntity) real).getFake();
		}
		return new Compat_TileEntity(real);
	}

	public TileEntity getReal() {
		return wrapper.get();
	}

	public Compat_World Compat_func_145831_w() {
		return Compat_World.getFake(wrapper.getWorldSuper());
	}

	public Compat_BlockPos Compat_func_174877_v() {
		return Compat_BlockPos.getFake(wrapper.getPosSuper());
	}

	@Callback
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return Compat_hasCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		if (wrapper == null) {
			// Must be a call during constructor
			return false;
		}
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		return wrapper.hasCapabilitySuper(capability.getReal(), facing2);
	}

	@SuppressWarnings("unchecked")
	@Callback
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return (T) Compat_getCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback({ Version.V1_10_2 })
	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		return wrapper.getCapabilitySuper(capability.getReal(), facing2);
	}

	public void update() {
		if (this instanceof Compat_ITickable) {
			((Compat_ITickable) this).Compat_func_73660_a();
		}
	}

	@Callback
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		switch (version) {
		case V1_10_2:
			Compat_func_189515_b(new Compat_NBTTagCompound(compound));
			break;
		case V1_7_10:
			Compat_func_145841_b(new Compat_NBTTagCompound(compound));
			break;
		default:
			throw version.makeException();
		}

		return compound;
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_NBTTagCompound Compat_func_189515_b(Compat_NBTTagCompound tag) {
		wrapper.writeToNBTSuper(tag.getReal());
		return tag;
	}

	@Callback
	public void readFromNBT(NBTTagCompound compound) {
		Compat_func_145839_a(new Compat_NBTTagCompound(compound));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_145839_a(Compat_NBTTagCompound tag) {
		wrapper.readFromNBTSuper(tag.getReal());
	}

	@Callback
	public NBTTagCompound getUpdateTag() {
		return Compat_func_189517_E_().getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_NBTTagCompound Compat_func_189517_E_() {
		NBTTagCompound result = wrapper.getUpdateTagSuper();
		return new Compat_NBTTagCompound(result);
	}

	@Callback
	public SPacketUpdateTileEntity getUpdatePacket() {
		switch (version) {
		case V1_10_2:
			return Compat_func_189518_D_().getReal();
		case V1_7_10:
			return ((Compat_SPacketUpdateTileEntity) Compat_func_145844_m()).getReal();
		default:
			throw version.makeException();
		}
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_SPacketUpdateTileEntity Compat_func_189518_D_() {
		SPacketUpdateTileEntity result = wrapper.getUpdatePacketSuper();
		return new Compat_SPacketUpdateTileEntity(result);
	}

	@HasCallback({ Version.V1_7_10 })
	public Compat_Packet Compat_func_145844_m() {
		return null;
	}

	@Callback
	public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet) {
		Compat_onDataPacket(new Compat_NetworkManager(manager), Compat_SPacketUpdateTileEntity.getFake(packet));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_onDataPacket(Compat_NetworkManager manager, Compat_SPacketUpdateTileEntity packet) {
		wrapper.onDataPacketSuper(manager.getReal(), packet.getReal());
	}

	@Callback
	public void handleUpdateTag(NBTTagCompound tag) {
		Compat_handleUpdateTag(new Compat_NBTTagCompound(tag));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_handleUpdateTag(Compat_NBTTagCompound tag) {
		wrapper.handleUpdateTagSuper(tag.getReal());
	}

	@Callback
	public AxisAlignedBB getRenderBoundingBox() {
		return Compat_getRenderBoundingBox().getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_AxisAlignedBB Compat_getRenderBoundingBox() {
		AxisAlignedBB result = wrapper.getRenderBoundingBoxSuper();
		return new Compat_AxisAlignedBB(result);
	}

	@Callback
	public boolean shouldRenderInPass(int pass) {
		return Compat_shouldRenderInPass(pass);
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_shouldRenderInPass(int pass) {
		return wrapper.shouldRenderInPassSuper(pass);
	}

	@Callback
	public boolean hasFastRenderer() {
		return Compat_hasFastRenderer();
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_hasFastRenderer() {
		return wrapper.hasFastRendererSuper();
	}

	@Callback
	public void onLoad() {
		Compat_onLoad();
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_onLoad() {
		wrapper.onLoadSuper();
	}

	@Callback
	public void onChunkUnload() {
		Compat_onChunkUnload();
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_onChunkUnload() {
		wrapper.onChunkUnloadSuper();
	}

	@Callback
	public boolean canRenderBreaking() {
		return Compat_canRenderBreaking();
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_canRenderBreaking() {
		return wrapper.canRenderBreakingSuper();

	}

	public static TileEntity getReal(Compat_TileEntity tile) {
		return tile == null ? null : tile.getReal();
	}

	@HasCallback({ Version.V1_7_10 })
	public void Compat_func_145841_b(Compat_NBTTagCompound tag) {
		wrapper.writeToNBTSuper(tag.getReal());
	}

	public int Compat_get_field_145851_c() {
		return wrapper.getPosSuper().getX();
	}

	public int Compat_get_field_145848_d() {
		return wrapper.getPosSuper().getY();
	}

	public int Compat_get_field_145849_e() {
		return wrapper.getPosSuper().getZ();
	}

	public Compat_World Compat_get_field_145850_b() {
		return Compat_World.getFake(wrapper.getWorldSuper());
	}

}
