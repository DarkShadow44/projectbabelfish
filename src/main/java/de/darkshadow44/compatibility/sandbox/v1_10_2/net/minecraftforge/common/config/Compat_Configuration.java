package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.config;

import java.io.File;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.common.config.Configuration;

public class Compat_Configuration {
	private Configuration original;
	private CompatI_Configuration thisReal;

	// When called from Mod
	public Compat_Configuration(File file) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Configuration.class, this, file), null);
	}

	// When called from child
	protected Compat_Configuration(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Configuration(Configuration original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Configuration thisReal, Configuration original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Configuration getReal() {
		return original == null ? thisReal.get() : original;
	}

	public void Compat_load() {
		if (this.original == null)
			thisReal.loadSuper();
		else
			original.load();
	}

	public void Compat_save() {
		if (this.original == null)
			thisReal.saveSuper();
		else
			original.save();
	}

	public int Compat_getInt(String name, String category, int standard, int min, int max, String comment) {
		if (this.original == null)
			return thisReal.getIntSuper(name, category, standard, min, max, comment);
		else
			return original.getInt(name, category, standard, min, max, comment);
	}

	public boolean Compat_getBoolean(String name, String category, boolean standard, String comment) {
		if (this.original == null)
			return thisReal.getBooleanSuper(name, category, standard, comment);
		else
			return original.getBoolean(name, category, standard, comment);
	}
}
