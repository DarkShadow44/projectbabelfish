package de.darkshadow44.compatibility.core.layer;

import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Wrapper_IIconRegister;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.CompatI_Item;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CompatibilityLayer_1_7_10 extends CompatibilityLayer {

	public CompatibilityLayer_1_7_10(String pathSandbox) {
		super(pathSandbox);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		// Get icons to register
		Wrapper_IIconRegister iconRegister = new Wrapper_IIconRegister();
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Compat_Item item = ((CompatI_Item) itemRegister.getItem()).getFake();
			item.Compat_func_94581_a(iconRegister);
		}

		// Register translations
		for (String key : translationsToRegister.keySet()) {
			registerTranslation(key);
		}
	}

	private void registerTranslation(String key) {
		String text = translationsToRegister.get(key);
		String lines[] = text.split("\n");

		StringBuilder json = new StringBuilder();
		json.append("{\n");

		boolean first = true;
		for (String line : lines) {
			line = line.trim();
			if (line.length() > 1) {
				String split[] = line.split("=");

				if (first) {
					first = false;
				} else {
					json.append(",\n");
				}
				json.append("\titem.\"" + split[0] + "\" = " + "\"" + split[1] + "\"");
			}
		}

		json.append("\n}\n");

		// classLoader.addResource("/" + MODID + "/lang/" + key + ".json",
		// json.toString().getBytes());
	}

}
