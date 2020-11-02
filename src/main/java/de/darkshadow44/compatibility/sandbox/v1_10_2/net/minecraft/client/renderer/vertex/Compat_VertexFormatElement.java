package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public class Compat_VertexFormatElement {
	private CompatI_VertexFormatElement wrapper;

	// When called from Mod
	public Compat_VertexFormatElement() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_VertexFormatElement.class, this));
	}

	// When called from child
	protected Compat_VertexFormatElement(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_VertexFormatElement(VertexFormatElement original) {
		this.initialize(Factory.createWrapper(CompatI_VertexFormatElement.class, original));
	}

	protected void initialize(CompatI_VertexFormatElement wrapper) {
		this.wrapper = wrapper;
	}

	public VertexFormatElement getReal() {
		return wrapper.get();
	}

	public Compat_VertexFormatElement_EnumUsage Compat_func_177375_c() {
		EnumUsage result = wrapper.getUsageSuper();
		return Compat_VertexFormatElement_EnumUsage.getFake(result);
	}

	public int Compat_func_177369_e() {
		return wrapper.getIndexSuper();
	}

	public Compat_VertexFormatElement_EnumType Compat_func_177367_b() {
		EnumType result = wrapper.getTypeSuper();
		return Compat_VertexFormatElement_EnumType.getFake(result);
	}
}
