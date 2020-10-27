package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_RayTraceResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public class Compat_DrawBlockHighlightEvent {

	private final DrawBlockHighlightEvent original;

	public Compat_DrawBlockHighlightEvent(DrawBlockHighlightEvent original) {
		this.original = original;
	}

	public DrawBlockHighlightEvent getReal() {
		return original;
	}

	public Compat_RayTraceResult Compat_getTarget() {
		return new Compat_RayTraceResult(original.getTarget());
	}

	public Compat_EntityPlayer Compat_getPlayer() {
		EntityPlayer player = original.getPlayer();
		return player == null ? null : new Compat_EntityPlayer(player);
	}

	public float Compat_getPartialTicks() {
		return original.getPartialTicks();
	}
}
