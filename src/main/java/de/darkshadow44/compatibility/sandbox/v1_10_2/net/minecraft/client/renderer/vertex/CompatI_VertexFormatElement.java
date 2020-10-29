package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public interface CompatI_VertexFormatElement {
	public VertexFormatElement get();

	public EnumUsage getUsageSuper();

	public int getIndexSuper();
}
