package compat.sandbox.net.minecraftforge.fml.client.config;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.gui.Compat_GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class Compat_GuiConfig extends Compat_GuiScreen {
	private CompatI_GuiConfig wrapper;

	// When called from Mod
	public Compat_GuiConfig() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GuiConfig.class, this));
	}

	// When called from child
	protected Compat_GuiConfig(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GuiConfig(GuiConfig original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GuiConfig.class, original));
	}

	protected void initialize(CompatI_GuiConfig wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public GuiConfig getReal() {
		return wrapper.get();
	}
}
