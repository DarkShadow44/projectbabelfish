package compat.sandbox.cpw.mods.fml.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Compat_Mod {
	public String modid() default "";

	public String dependencies() default "";
}
