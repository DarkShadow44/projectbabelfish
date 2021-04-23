package compat.autogen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import compat.core.Version;

@Retention(RetentionPolicy.RUNTIME)
public @interface HasCallback {
	public Version[] value();
}
