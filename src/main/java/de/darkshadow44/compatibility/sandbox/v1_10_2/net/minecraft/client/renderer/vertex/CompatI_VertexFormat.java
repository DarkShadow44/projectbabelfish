package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;

public interface CompatI_VertexFormat {
	public VertexFormat get();

	public int getElementCountSuper();

	public VertexFormatElement getElementSuper(int index);
}
