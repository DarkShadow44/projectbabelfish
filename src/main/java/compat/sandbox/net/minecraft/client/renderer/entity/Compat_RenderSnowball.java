package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_Item;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;

public class Compat_RenderSnowball<T extends Entity> extends Compat_Render<T> {
	private CompatI_RenderSnowball<T> wrapper;

	// When called from Mod
	public Compat_RenderSnowball(Compat_RenderManager renderManager, Compat_Item item, Compat_RenderItem renderItem) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderSnowball.class, this, renderManager.getReal(), item.getReal(), renderItem.getReal()));
	}

	// When called from child
	protected Compat_RenderSnowball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderSnowball(RenderSnowball<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderSnowball.class, original));
	}

	protected void initialize(CompatI_RenderSnowball<T> wrapper) {
		this.wrapper = wrapper;
	}

	public RenderSnowball<T> getReal() {
		return wrapper.get();
	}
}
