package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.Wrapper_IRegistry_Model;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.registry.Compat_IRegistry;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;

public class Compat_ModelBakeEvent {

	private final ModelBakeEvent original;

	public Compat_ModelBakeEvent(ModelBakeEvent original) {
		this.original = original;
	}

	public ModelBakeEvent getReal() {
		return original;
	}

	public Compat_IRegistry<ModelResourceLocation, IBakedModel> Compat_getModelRegistry() {
		return new Wrapper_IRegistry_Model(original.getModelRegistry());
	}
}
