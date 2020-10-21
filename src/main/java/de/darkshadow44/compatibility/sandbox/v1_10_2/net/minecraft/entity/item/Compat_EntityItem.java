package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.item.EntityItem;

public class Compat_EntityItem extends Compat_Entity {
	private EntityItem original;
	private CompatI_EntityItem thisReal;

	// When called from Mod
	public Compat_EntityItem() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItem.class, this), null);
	}

	// When called from child
	protected Compat_EntityItem(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityItem(EntityItem original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityItem thisReal, EntityItem original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityItem getReal() {
		return original == null ? thisReal.get() : original;
	}
}
