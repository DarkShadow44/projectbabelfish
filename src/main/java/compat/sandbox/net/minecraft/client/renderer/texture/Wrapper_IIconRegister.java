package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.core.CompatibilityMod;
import compat.core.RegistrationInfoIcon;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.util.ResourceLocation;

public class Wrapper_IIconRegister implements Compat_IIconRegister {

	@Override
	public Compat_IIcon Compat_func_94245_a(String name) {
		String[] split = name.toLowerCase().split(":");
		if (split.length != 2) {
			throw new RuntimeException("Unexpected");
		}
		ResourceLocation location = new ResourceLocation(split[0], "items/" + split[1]);
		CompatibilityMod.CURRENT_LAYER.iconsToRegister.add(new RegistrationInfoIcon(location));
		return new Wrapper_IIcon(location);
	}

}
