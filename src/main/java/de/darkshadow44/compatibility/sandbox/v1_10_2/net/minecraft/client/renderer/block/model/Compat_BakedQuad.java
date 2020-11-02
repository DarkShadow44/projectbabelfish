package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;

public class Compat_BakedQuad {
	private BakedQuad original;
	private CompatI_BakedQuad thisReal;

	// When called from Mod
	public Compat_BakedQuad() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BakedQuad.class, this), null);
	}

	// When called from child
	protected Compat_BakedQuad(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BakedQuad(BakedQuad original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BakedQuad thisReal, BakedQuad original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public BakedQuad getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_VertexFormat Compat_getFormat() {
		VertexFormat result;
		if (original == null)
			result = thisReal.getFormatSuper();
		else
			result = original.getFormat();
		return new Compat_VertexFormat(result);
	}

	public boolean Compat_func_178212_b() {
		if (original == null)
			return thisReal.hasTintIndexSuper();
		else
			return original.hasTintIndex();
	}

	public int Compat_func_178211_c() {
		if (original == null)
			return thisReal.getTintIndexSuper();
		else
			return original.getTintIndex();
	}

	public Compat_EnumFacing Compat_func_178210_d() {
		EnumFacing result;
		if (original == null)
			result = thisReal.getFaceSuper();
		else
			result = original.getFace();
		return Compat_EnumFacing.map_real_to_fake(result);
	}
}
