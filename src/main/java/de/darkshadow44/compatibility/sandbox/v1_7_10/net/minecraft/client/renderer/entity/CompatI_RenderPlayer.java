package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

public interface CompatI_RenderPlayer extends CompatI_RenderLivingBase<AbstractClientPlayer> {
	public RenderPlayer get();
}
