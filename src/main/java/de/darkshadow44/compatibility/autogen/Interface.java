package de.darkshadow44.compatibility.autogen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Interface {
	Class<?> value();
}
