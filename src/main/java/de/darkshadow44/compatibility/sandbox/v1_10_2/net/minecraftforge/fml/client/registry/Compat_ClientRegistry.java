package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.client.registry;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.settings.Compat_KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Compat_ClientRegistry {

	public static void Compat_registerKeyBinding(Compat_KeyBinding keybinding) {
		ClientRegistry.registerKeyBinding(keybinding.getReal());
	}
}
