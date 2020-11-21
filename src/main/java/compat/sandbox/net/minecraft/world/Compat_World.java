package compat.sandbox.net.minecraft.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumParticleTypes;
import compat.sandbox.net.minecraft.util.Compat_SoundCategory;
import compat.sandbox.net.minecraft.util.Compat_SoundEvent;
import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.util.math.Compat_RayTraceResult;
import compat.sandbox.net.minecraft.util.math.Compat_Vec3d;
import compat.sandbox.net.minecraft.world.border.Compat_WorldBorder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.border.WorldBorder;

public class Compat_World implements Compat_IBlockAccess {
	private CompatI_World wrapper;

	// When called from Mod
	public Compat_World() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_World.class, this));
	}

	// When called from child
	protected Compat_World(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_World(World original) {
		this.initialize(Factory.createWrapper(CompatI_World.class, original));
	}

	protected void initialize(CompatI_World wrapper) {
		this.wrapper = wrapper;
	}

	public World getReal() {
		return wrapper.get();
	}

	public boolean Compat_get_field_72995_K() {
		return wrapper.get_isRemote();
	}

	public Compat_IBlockState Compat_func_180495_p(Compat_BlockPos pos) {
		IBlockState result = wrapper.getBlockStateSuper(pos.getReal());

		return new Wrapper_IBlockState(result);
	}

	@Override
	public Compat_TileEntity Compat_func_175625_s(Compat_BlockPos pos) {
		TileEntity result = wrapper.getTileEntitySuper(pos.getReal());

		if (result == null)
			return null;

		return Compat_TileEntity.getFake(result);
	}

	public boolean Compat_func_72855_b(Compat_AxisAlignedBB axis) {
		return wrapper.checkNoEntityCollisionSuper(axis.getReal());
	}

	public void Compat_func_184133_a(Compat_EntityPlayer player, Compat_BlockPos pos, Compat_SoundEvent sound, Compat_SoundCategory category, float volume, float pitch) {
		wrapper.playSoundSuper(player.getReal(), pos.getReal(), sound.getReal(), category.getReal(), volume, pitch);
	}

	public boolean Compat_func_175656_a(Compat_BlockPos pos, Compat_IBlockState state) {
		return wrapper.setBlockStateSuper(pos.getReal(), state.getReal());
	}

	public void Compat_func_175690_a(Compat_BlockPos pos, Compat_TileEntity tile) {
		wrapper.setTileEntitySuper(pos.getReal(), tile.getReal());
	}

	public void Compat_func_175685_c(Compat_BlockPos pos, Compat_Block block) {
		wrapper.notifyNeighborsOfStateChangeSuper(pos.getReal(), block.getReal(), true);
	}

	public boolean Compat_func_175664_x(Compat_BlockPos pos) {
		return wrapper.checkLightSuper(pos.getReal());
	}

	public static Compat_World getFake(World real) {
		if (real == null)
			return null;

		if (real instanceof WorldServer) {
			return new Compat_WorldServer((WorldServer) real);
		} else {
			return new Compat_World(real);
		}
	}

	public List<Compat_EntityPlayer> Compat_get_field_73010_i() {
		List<EntityPlayer> result = wrapper.get_playerEntities();

		List<Compat_EntityPlayer> ret = new ArrayList<>();
		for (EntityPlayer player : result) {
			ret.add(Compat_EntityPlayer.getFake(player));
		}
		return ret;
	}

	public void Compat_func_175679_n(Compat_BlockPos pos) {
		wrapper.notifyLightSetSuper(pos.getReal());
	}

	public void Compat_func_175704_b(Compat_BlockPos pos, Compat_BlockPos pos2) {
		wrapper.markBlockRangeForRenderUpdateSuper(pos.getReal(), pos2.getReal());
	}

	public Compat_WorldBorder Compat_func_175723_af() {
		WorldBorder result = wrapper.getWorldBorderSuper();

		return new Compat_WorldBorder(result);
	}

	public long Compat_func_82737_E() {
		return wrapper.getTotalWorldTimeSuper();
	}

	public boolean Compat_func_175698_g(Compat_BlockPos pos) {
		return wrapper.setBlockToAirSuper(pos.getReal());
	}

	public void Compat_func_175646_b(Compat_BlockPos pos, Compat_TileEntity tile) {
		wrapper.markChunkDirtySuper(pos.getReal(), tile.getReal());
	}

	// TODO?
	public <T extends Entity> List<Compat_Entity> Compat_func_175647_a(Class<? extends T> classEntity, Compat_AxisAlignedBB bb, Predicate<? super T> filter) {
		List<T> result = wrapper.getEntitiesWithinAABBSuper(classEntity, bb.getReal(), filter);

		List<Compat_Entity> ret = new ArrayList<>();

		for (Entity e : result) {
			ret.add(new Compat_Entity(e));
		}

		return ret;
	}

	public int Compat_func_175651_c(Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.getRedstonePowerSuper(pos.getReal(), facing.getReal());
	}

	public void Compat_func_175666_e(Compat_BlockPos pos, Compat_Block block) {
		wrapper.updateComparatorOutputLevelSuper(pos.getReal(), block.getReal());
	}

	public void Compat_func_175688_a(Compat_EnumParticleTypes type, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
		wrapper.spawnParticleSuper(type.getReal(), x, y, z, xSpeed, ySpeed, zSpeed, parameters);
	}

	public void Compat_func_175695_a(Compat_BlockPos pos, Compat_Block block, Compat_EnumFacing facing) {
		wrapper.notifyNeighborsOfStateExceptSuper(pos.getReal(), block.getReal(), facing.getReal());
	}

	public void Compat_func_175713_t(Compat_BlockPos pos) {
		wrapper.removeTileEntitySuper(pos.getReal());
	}

	public boolean Compat_func_175716_a(Compat_Block block, Compat_BlockPos pos, boolean skipCollisionCheck, Compat_EnumFacing facing, Compat_Entity entity, Compat_ItemStack stack) {
		return wrapper.mayPlaceSuper(block.getReal(), pos.getReal(), skipCollisionCheck, facing.getReal(), entity.getReal());
	}

	public void Compat_func_180496_d(Compat_BlockPos pos, Compat_Block block) {
		wrapper.neighborChangedSuper(pos.getReal(), block.getReal(), pos.getReal()); // TODO?;
	}

	public void Compat_func_180497_b(Compat_BlockPos pos, Compat_Block block, int delay, int priority) {
		wrapper.scheduleBlockUpdateSuper(pos.getReal(), block.getReal(), delay, priority);
	}

	public boolean Compat_func_180501_a(Compat_BlockPos pos, Compat_IBlockState state, int flags) {
		return wrapper.setBlockStateSuper(pos.getReal(), state.getReal(), flags);
	}

	public void Compat_func_184138_a(Compat_BlockPos pos, Compat_IBlockState stateOld, Compat_IBlockState stateNew, int flags) {
		wrapper.notifyBlockUpdateSuper(pos.getReal(), stateOld.getReal(), stateNew.getReal(), flags);
	}

	public boolean Compat_func_72838_d(Compat_Entity entity) {
		return wrapper.spawnEntitySuper(entity.getReal());
	}

	public Compat_RayTraceResult Compat_func_72933_a(Compat_Vec3d start, Compat_Vec3d end) {
		return Compat_RayTraceResult.getFake(wrapper.rayTraceBlocksSuper(start.getReal(), end.getReal()));
	}

	public Compat_GameRules Compat_func_82736_K() {
		return new Compat_GameRules(wrapper.getGameRulesSuper());
	}

	public Compat_WorldProvider Compat_get_field_73011_w() {
		return new Compat_WorldProvider(wrapper.get_provider());
	}

	public Random Compat_get_field_73012_v() {
		return wrapper.get_rand();
	}

	public boolean Compat_get_restoringBlockSnapshots() {
		return wrapper.get_restoringBlockSnapshots();
	}

	public boolean Compat_isSideSolid(Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.isSideSolidSuper(pos.getReal(), facing.getReal());
	}

}
