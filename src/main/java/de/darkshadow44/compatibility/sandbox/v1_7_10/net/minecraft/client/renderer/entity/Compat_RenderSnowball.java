package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.Compat_RenderItem;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_Item;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;

public class Compat_RenderSnowball<T extends Entity> extends Compat_Render<T> {
	private RenderSnowball<T> original;
	private CompatI_RenderSnowball<T> thisReal;

	// When called from Mod
	public Compat_RenderSnowball(Compat_RenderManager renderManager, Compat_Item item, Compat_RenderItem renderItem) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderSnowball.class, this, renderManager.getReal(), item.getReal(), renderItem.getReal()), null);
	}

	// When called from child
	protected Compat_RenderSnowball(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderSnowball(RenderSnowball<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderSnowball<T> thisReal, RenderSnowball<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderSnowball<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
