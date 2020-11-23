package compat.sandbox.net.minecraftforge.event.entity.player;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public interface CompatI_PlayerInteractEvent extends CompatI_PlayerEvent {
	public PlayerInteractEvent get();

	public World getWorldSuper();

	public EnumHand getHandSuper();

	public ItemStack getItemStackSuper();

	public BlockPos getPosSuper();

	public EnumFacing getFaceSuper();
}
