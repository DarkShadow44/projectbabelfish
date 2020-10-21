package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelBakery;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap.Compat_IStateMapper;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap.Wrapper_IStateMapper;
import net.minecraftforge.client.model.ModelLoader;

public class Compat_ModelLoader extends Compat_ModelBakery {
	private ModelLoader original;

	// When called from Minecraft
	public Compat_ModelLoader(ModelLoader original) {
		super(ParentSelector.NULL);
		this.original = original;
	}

	public ModelLoader getReal() {
		return original;
	}

	public static void Compat_setCustomStateMapper(Compat_Block block, Compat_IStateMapper stateMapper) {
		ModelLoader.setCustomStateMapper(block.getReal(), new Wrapper_IStateMapper(stateMapper));
	}
}
