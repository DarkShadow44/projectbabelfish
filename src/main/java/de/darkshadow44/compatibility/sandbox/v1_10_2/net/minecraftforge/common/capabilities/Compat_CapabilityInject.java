package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Compat_CapabilityInject {
	public Class<?> value();
}
