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
	private CompatI_BakedQuad wrapper;

	// When called from Mod
	public Compat_BakedQuad() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BakedQuad.class, this));
	}

	// When called from child
	protected Compat_BakedQuad(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BakedQuad(BakedQuad original) {
		this.initialize(Factory.createWrapper(CompatI_BakedQuad.class, original));
	}

	protected void initialize(CompatI_BakedQuad wrapper) {
		this.wrapper = wrapper;
	}

	public BakedQuad getReal() {
		return wrapper.get();
	}

	public Compat_VertexFormat Compat_getFormat() {
		VertexFormat result = wrapper.getFormatSuper();
		return new Compat_VertexFormat(result);
	}

	public boolean Compat_func_178212_b() {
		return wrapper.hasTintIndexSuper();
	}

	public int Compat_func_178211_c() {
		return wrapper.getTintIndexSuper();
	}

	public Compat_EnumFacing Compat_func_178210_d() {
		EnumFacing result = wrapper.getFaceSuper();
		return Compat_EnumFacing.map_real_to_fake(result);
	}
}
