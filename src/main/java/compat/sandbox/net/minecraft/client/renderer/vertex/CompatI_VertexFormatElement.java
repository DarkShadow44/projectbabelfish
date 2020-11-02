package compat.sandbox.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public interface CompatI_VertexFormatElement {
	public VertexFormatElement get();

	public EnumUsage getUsageSuper();

	public int getIndexSuper();

	public EnumType getTypeSuper();
}
