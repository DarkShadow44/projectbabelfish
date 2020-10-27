package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.config;

import net.minecraftforge.common.config.Configuration;

public interface CompatI_Configuration {
	public Configuration get();

	public void loadSuper();

	public boolean getBooleanSuper(String name, String category, boolean standard, String comment);

	public int getIntSuper(String name, String category, int standard, int min, int max, String comment);

	public void saveSuper();
}
