package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_SoundCategory;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_SoundEvent;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Compat_World implements Compat_IBlockAccess {
	private World original;
	private CompatI_World thisReal;

	// When called from Mod
	public Compat_World() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_World.class, this), null);
	}

	// When called from child
	protected Compat_World(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_World(World original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_World thisReal, World original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public World getReal() {
		return original == null ? thisReal.get() : original;
	}

	public boolean Compat_get_field_72995_K() {
		if (original == null)
			return thisReal.get_isRemote();
		else
			return original.isRemote;
	}

	public Compat_IBlockState Compat_func_180495_p(Compat_BlockPos pos) {
		IBlockState state;

		if (original == null)
			state = thisReal.getBlockStateSuper(pos.getReal());
		else
			state = original.getBlockState(pos.getReal());

		return new Wrapper_IBlockState(state);
	}

	@Override
	public Compat_TileEntity Compat_func_175625_s(Compat_BlockPos pos) {
		TileEntity tile;

		if (original == null)
			tile = thisReal.getTileEntitySuper(pos.getReal());
		else
			tile = original.getTileEntity(pos.getReal());

		return new Compat_TileEntity(tile);
	}

	public boolean Compat_func_72855_b(Compat_AxisAlignedBB axis) {
		if (original == null)
			return thisReal.checkNoEntityCollisionSuper(axis.getReal());
		else
			return original.checkNoEntityCollision(axis.getReal());
	}

	public void Compat_func_184133_a(Compat_EntityPlayer player, Compat_BlockPos pos, Compat_SoundEvent sound, Compat_SoundCategory category, float volume, float pitch) {
		if (original == null)
			thisReal.playSoundSuper(player.getReal(), pos.getReal(), sound.getReal(), category.getReal(), volume, pitch);
		else
			original.playSound(player.getReal(), pos.getReal(), sound.getReal(), category.getReal(), volume, pitch);
	}

	public boolean Compat_func_175656_a(Compat_BlockPos pos, Compat_IBlockState state) {
		if (original == null)
			return thisReal.setBlockStateSuper(pos.getReal(), state.getReal());
		else
			return original.setBlockState(pos.getReal(), state.getReal());
	}
}
