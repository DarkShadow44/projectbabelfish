package net.projectbabelfish.sandbox.net.minecraftforge.fml.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Compat_Mod {
	String modid() default "";

	String dependencies() default "";
}
