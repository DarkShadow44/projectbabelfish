package compat.sandbox.net.minecraftforge.event.entity.player;

import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

public interface CompatI_PlayerInteractEvent_RightClickBlock extends CompatI_PlayerInteractEvent {
	public RightClickBlock get();

	public Vec3d getHitVecSuper();
}
