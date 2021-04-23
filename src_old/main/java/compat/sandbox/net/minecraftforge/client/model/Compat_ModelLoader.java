package compat.sandbox.net.minecraftforge.client.model;

import compat.core.CompatibilityMod;
import compat.core.ParentSelector;
import compat.core.layer.ModelLocationInfo;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelBakery;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import compat.sandbox.net.minecraft.client.renderer.block.statemap.Compat_IStateMapper;
import compat.sandbox.net.minecraft.client.renderer.block.statemap.Wrapper_IStateMapper;
import compat.sandbox.net.minecraft.item.Compat_Item;
import net.minecraftforge.client.model.ModelLoader;

public class Compat_ModelLoader extends Compat_ModelBakery {
	private final ModelLoader original;

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

	public static void Compat_setCustomModelResourceLocation(Compat_Item item, int metadata, Compat_ModelResourceLocation location) {
		CompatibilityMod.CURRENT_LAYER.modelLocationInfo.add(new ModelLocationInfo(item.getReal(), metadata, location.getReal()));
	}
}
