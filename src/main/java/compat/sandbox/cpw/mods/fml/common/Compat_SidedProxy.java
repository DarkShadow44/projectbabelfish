package compat.sandbox.cpw.mods.fml.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Compat_SidedProxy {
	String clientSide() default "";

	String serverSide() default "";
}
