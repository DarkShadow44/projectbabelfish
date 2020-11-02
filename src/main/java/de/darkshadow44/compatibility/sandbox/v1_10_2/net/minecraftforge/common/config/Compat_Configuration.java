package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.config;

import java.io.File;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.common.config.Configuration;

public class Compat_Configuration {
	private CompatI_Configuration wrapper;

	// When called from Mod
	public Compat_Configuration(File file) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Configuration.class, this, file));
	}

	// When called from child
	protected Compat_Configuration(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Configuration(Configuration original) {
		this.initialize(Factory.createWrapper(CompatI_Configuration.class, original));
	}

	protected void initialize(CompatI_Configuration wrapper) {
		this.wrapper = wrapper;
	}

	public Configuration getReal() {
		return wrapper.get();
	}

	public void Compat_load() {
		wrapper.loadSuper();
	}

	public void Compat_save() {
		wrapper.saveSuper();
	}

	public int Compat_getInt(String name, String category, int standard, int min, int max, String comment) {
		return wrapper.getIntSuper(name, category, standard, min, max, comment);
	}

	public boolean Compat_getBoolean(String name, String category, boolean standard, String comment) {
		return wrapper.getBooleanSuper(name, category, standard, comment);
	}
}
