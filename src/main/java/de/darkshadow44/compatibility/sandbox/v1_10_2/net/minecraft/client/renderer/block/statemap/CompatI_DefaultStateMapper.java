package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import java.util.Map;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;

public interface CompatI_DefaultStateMapper extends CompatI_StateMapperBase {
	public DefaultStateMapper get();

	public String getPropertyStringSuper(Map<IProperty<?>, Comparable<?>> map2);
}
