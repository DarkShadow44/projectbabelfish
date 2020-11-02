package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.core.CompatibilityMod;
import compat.core.RegistrationInfoIcon;
import compat.sandbox.net.minecraft.util.Compat_IIcon;

public class Wrapper_IIconRegister implements Compat_IIconRegister {

	@Override
	public Compat_IIcon Compat_func_94245_a(String name) {
		name = name.toLowerCase();
		CompatibilityMod.LAYER_1_7_10.iconsToRegister.add(new RegistrationInfoIcon(name));
		return new Wrapper_IIcon(name);
	}

}
