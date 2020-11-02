package compat.sandbox.net.minecraftforge.fml.client.registry;

import compat.sandbox.net.minecraft.client.renderer.tileentity.Compat_TileEntitySpecialRenderer;
import compat.sandbox.net.minecraft.client.settings.Compat_KeyBinding;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
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
