package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;

public class Compat_EntityItemFrame extends Compat_EntityHanging {
	private CompatI_EntityItemFrame wrapper;

	// When called from Mod
	public Compat_EntityItemFrame() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItemFrame.class, this));
	}

	// When called from child
	protected Compat_EntityItemFrame(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityItemFrame(EntityItemFrame original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityItemFrame.class, original));
	}

	protected void initialize(CompatI_EntityItemFrame wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityItemFrame getReal() {
		return wrapper.get();
	}
}
