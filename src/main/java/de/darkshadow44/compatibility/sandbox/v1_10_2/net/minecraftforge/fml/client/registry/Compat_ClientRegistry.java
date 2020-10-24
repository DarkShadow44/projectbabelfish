package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.client.registry;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity.Compat_TileEntitySpecialRenderer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.settings.Compat_KeyBinding;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Compat_ClientRegistry {

	public static void Compat_registerKeyBinding(Compat_KeyBinding keybinding) {
		ClientRegistry.registerKeyBinding(keybinding.getReal());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Compat_TileEntity> void Compat_bindTileEntitySpecialRenderer(Class<T> tileEntityClass, Compat_TileEntitySpecialRenderer<? super T> specialRenderer) {
		ClientRegistry.bindTileEntitySpecialRenderer((Class) tileEntityClass, specialRenderer.getReal()); // TODO: test
	}
}
