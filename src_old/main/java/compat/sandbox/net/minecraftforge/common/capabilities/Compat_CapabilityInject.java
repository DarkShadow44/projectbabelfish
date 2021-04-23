package compat.sandbox.net.minecraftforge.common.capabilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Compat_CapabilityInject {
	public Class<?> value();
}
