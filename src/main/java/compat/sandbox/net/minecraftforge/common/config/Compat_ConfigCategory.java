package compat.sandbox.net.minecraftforge.common.config;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.common.config.ConfigCategory;

public class Compat_ConfigCategory {
	private CompatI_ConfigCategory wrapper;

	// When called from Mod
	public Compat_ConfigCategory() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ConfigCategory.class, this));
	}

	// When called from child
	protected Compat_ConfigCategory(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ConfigCategory(ConfigCategory original) {
		this.initialize(Factory.createWrapper(CompatI_ConfigCategory.class, original));
	}

	protected void initialize(CompatI_ConfigCategory wrapper) {
		this.wrapper = wrapper;
	}

	public ConfigCategory getReal() {
		return wrapper.get();
	}
}
