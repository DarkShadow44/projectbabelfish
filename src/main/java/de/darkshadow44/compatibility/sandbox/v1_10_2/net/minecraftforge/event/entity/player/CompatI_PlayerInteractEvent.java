package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public interface CompatI_PlayerInteractEvent extends CompatI_Event {
	public PlayerInteractEvent get();

	public World getWorldSuper();

	public EnumHand getHandSuper();

	public ItemStack getItemStackSuper();

	public EntityPlayer getEntityPlayerSuper();

	public BlockPos getPosSuper();

	public EnumFacing getFaceSuper();
}
