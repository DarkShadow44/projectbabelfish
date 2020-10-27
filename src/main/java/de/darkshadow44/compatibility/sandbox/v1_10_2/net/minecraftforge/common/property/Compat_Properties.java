package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;

public class Compat_Properties {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Compat_IUnlistedProperty<?> Compat_toUnlisted(Compat_IProperty<?> property) {
		IUnlistedProperty<?> result = Properties.toUnlisted(property.getReal());
		return new Wrapper2_IUnlistedProperty(result);
	}
}
