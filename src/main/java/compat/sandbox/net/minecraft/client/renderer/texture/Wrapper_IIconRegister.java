package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.core.CompatibilityMod;
import compat.core.RegistrationInfoIcon;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.util.ResourceLocation;

public class Wrapper_IIconRegister implements Compat_IIconRegister {

	public enum Type {
		ITEM("items/"),
		BLOCK("blocks/");

		public final String PATH;

		private Type(String path) {
			this.PATH = path;
		}
	}

	private final Type type;

	public Wrapper_IIconRegister(Type type) {
		this.type = type;
	}

	@Override
	public Compat_IIcon Compat_func_94245_a(String name) {

		ResourceLocation location;
		if (!name.contains(":")) {
			location = new ResourceLocation(CompatibilityMod.CURRENT_LAYER.getCurrentModId(), type.PATH + name);
		} else {
			String[] split = name.toLowerCase().split(":");
			if (split.length != 2) {
				throw new RuntimeException("Unexpected");
			}
			location = new ResourceLocation(split[0], type.PATH + split[1]);
		}

		Compat_IIcon icon = new Wrapper_IIcon(location);

		CompatibilityMod.CURRENT_LAYER.iconsToRegister.add(new RegistrationInfoIcon(icon));
		return icon;
	}

}
