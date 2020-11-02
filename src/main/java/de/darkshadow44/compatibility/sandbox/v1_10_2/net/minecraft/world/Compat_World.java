package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_SoundCategory;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_SoundEvent;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.border.Compat_WorldBorder;
import net.minecraft.block.state.IBlockState;
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

		return Compat_TileEntity.get_fake(result);
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

	public static Compat_World get_fake(World real) {
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
			ret.add(Compat_EntityPlayer.get_fake(player));
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
}
