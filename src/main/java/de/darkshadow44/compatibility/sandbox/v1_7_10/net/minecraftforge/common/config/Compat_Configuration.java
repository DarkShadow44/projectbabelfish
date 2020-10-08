package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Compat_Configuration extends Configuration {
	public Compat_Configuration(File file) {
		super(file);
	}

	public void Compat_load() {
		load();
	}

	public Compat_Property Compat_get(String category, String key, boolean defaultValue) {
		return new Compat_Property(get(category, key, defaultValue));
	}

	public Compat_Property Compat_get(String category, String key, int defaultValue) {
		return new Compat_Property(get(category, key, defaultValue));
	}

	public Compat_Property Compat_get(String category, String key, String[] defaultValues) {
		return new Compat_Property(get(category, key, defaultValues));
	}
}
