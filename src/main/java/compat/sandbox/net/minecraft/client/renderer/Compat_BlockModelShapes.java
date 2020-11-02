package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelManager;
import net.minecraft.client.renderer.BlockModelShapes;

public class Compat_BlockModelShapes {

	private final BlockModelShapes original;

	public Compat_BlockModelShapes(BlockModelShapes original) {
		this.original = original;
	}

	public BlockModelShapes getReal() {
		return original;
	}

	public Compat_ModelManager Compat_func_178126_b() {
		return new Compat_ModelManager(original.getModelManager());
	}
}
