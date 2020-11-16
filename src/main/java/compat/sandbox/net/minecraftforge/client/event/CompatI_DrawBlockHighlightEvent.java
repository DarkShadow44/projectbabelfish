package compat.sandbox.net.minecraftforge.client.event;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public interface CompatI_DrawBlockHighlightEvent extends CompatI_Event {
	public DrawBlockHighlightEvent get();

	public RayTraceResult getTargetSuper();

	public EntityPlayer getPlayerSuper();

	public float getPartialTicksSuper();
}
