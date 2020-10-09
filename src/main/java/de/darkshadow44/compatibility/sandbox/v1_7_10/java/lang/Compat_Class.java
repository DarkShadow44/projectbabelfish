package de.darkshadow44.compatibility.sandbox.v1_7_10.java.lang;

import de.darkshadow44.compatibility.sandbox.v1_7_10.java.lang.reflect.Compat_Field;

public class Compat_Class {

	private Class<?> original;

	public Compat_Class(Class<?> original) {
		this.original = original;
	}

	public String Compat_getName() {
		return original.getName();
	}

	public Compat_Field Compat_getDeclaredField(String name) {
		return new Compat_Field(); // TODO
	}
}
