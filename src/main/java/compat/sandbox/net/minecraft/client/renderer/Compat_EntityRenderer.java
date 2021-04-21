package compat.sandbox.net.minecraft.client.renderer;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.Compat_Minecraft;
import net.minecraft.client.renderer.GameRenderer;

public class Compat_EntityRenderer {
	private CompatI_EntityRenderer wrapper;

	// When called from Mod
	public Compat_EntityRenderer(Compat_Minecraft mc) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityRenderer.class, this, mc.getReal(), null)); // TODO
	}

	// When called from child
	protected Compat_EntityRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityRenderer(GameRenderer original) {
		this.initialize(Factory.createWrapper(CompatI_EntityRenderer.class, original));
	}

	protected void initialize(CompatI_EntityRenderer wrapper) {
		this.wrapper = wrapper;
	}

	public GameRenderer getReal() {
		return wrapper.get();
	}

	public static boolean Compat_get_field_78517_a() {
		//return GameRenderer.anaglyphEnable;
		return false;
	}
}
