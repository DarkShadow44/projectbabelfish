package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public interface CompatI_Configuration {
	public Configuration get();

	public void loadSuper();

	public boolean getBooleanSuper(String name, String category, boolean standard, String comment);

	public int getIntSuper(String name, String category, int standard, int min, int max, String comment);

	public void saveSuper();

	public boolean hasChangedSuper();

	public Property getSuper(String category, String key, double defaultValue);

	public Property getSuper(String category, String key, String[] defaultValues);

	public Property getSuper(String category, String key, boolean defaultValue);
}
