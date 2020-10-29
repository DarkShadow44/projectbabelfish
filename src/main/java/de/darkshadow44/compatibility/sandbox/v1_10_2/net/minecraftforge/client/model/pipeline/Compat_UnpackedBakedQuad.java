package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_BakedQuad;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;

public class Compat_UnpackedBakedQuad extends Compat_BakedQuad {
	private UnpackedBakedQuad original;
	private CompatI_UnpackedBakedQuad thisReal;

	// When called from Mod
	public Compat_UnpackedBakedQuad(float[][][] data, int tint, Compat_EnumFacing facing, Compat_TextureAtlasSprite sprite, boolean diffuseLighting, Compat_VertexFormat format) {
		super(ParentSelector.NULL);
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UnpackedBakedQuad.class, this, data, tint, facing2, sprite.getReal(), diffuseLighting, format.getReal()), null);
	}

	// When called from child
	protected Compat_UnpackedBakedQuad(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_UnpackedBakedQuad(UnpackedBakedQuad original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_UnpackedBakedQuad thisReal, UnpackedBakedQuad original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public UnpackedBakedQuad getReal() {
		return original == null ? thisReal.get() : original;
	}
}
