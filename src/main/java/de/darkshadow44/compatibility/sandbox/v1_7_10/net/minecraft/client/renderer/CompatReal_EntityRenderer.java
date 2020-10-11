package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManager;

public class CompatReal_EntityRenderer extends EntityRenderer implements CompatI_EntityRenderer {
	@SuppressWarnings("unused")
	private Compat_EntityRenderer thisFake;

	public CompatReal_EntityRenderer(Compat_EntityRenderer thisFake, Minecraft mc, IResourceManager resourceManager) {
		super(mc, resourceManager);
		this.thisFake = thisFake;
	}

	@Override
	public EntityRenderer get() {
		return this;
	}
}
