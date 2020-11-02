package compat.autogen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Callback {
	public boolean skipDuringConstructor() default false;
}
