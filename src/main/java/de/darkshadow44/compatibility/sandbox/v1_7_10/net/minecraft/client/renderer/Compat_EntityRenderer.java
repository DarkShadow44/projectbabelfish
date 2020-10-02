package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManager;

public class Compat_EntityRenderer extends EntityRenderer {

	public Compat_EntityRenderer(Minecraft mcIn, IResourceManager resourceManagerIn) {
		super(mcIn, resourceManagerIn);
	}

}
