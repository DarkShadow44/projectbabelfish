package compat.sandbox.net.minecraftforge.event.entity.player;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

public interface CompatI_BonemealEvent extends CompatI_PlayerEvent {
	public BonemealEvent get();

	public IBlockState getBlockSuper();

	public World getWorldSuper();

	public BlockPos getPosSuper();
}
