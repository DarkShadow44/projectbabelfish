package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public class Compat_VertexFormatElement {
	private VertexFormatElement original;
	private CompatI_VertexFormatElement thisReal;

	// When called from Mod
	public Compat_VertexFormatElement() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_VertexFormatElement.class, this), null);
	}

	// When called from child
	protected Compat_VertexFormatElement(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_VertexFormatElement(VertexFormatElement original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_VertexFormatElement thisReal, VertexFormatElement original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public VertexFormatElement getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_VertexFormatElement_EnumUsage Compat_func_177375_c() {
		EnumUsage result;
		if (original == null)
			result = thisReal.getUsageSuper();
		else
			result = original.getUsage();
		return Compat_VertexFormatElement_EnumUsage.getFake(result);
	}

	public int Compat_func_177369_e() {
		if (original == null)
			return thisReal.getIndexSuper();
		else
			return original.getIndex();
	}
}
