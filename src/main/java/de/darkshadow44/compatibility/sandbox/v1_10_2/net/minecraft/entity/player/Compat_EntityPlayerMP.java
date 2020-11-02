package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.player.EntityPlayerMP;

public class Compat_EntityPlayerMP extends Compat_EntityPlayer {
	private CompatI_EntityPlayerMP wrapper;

	// When called from Mod
	public Compat_EntityPlayerMP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayerMP.class, this));
	}

	// When called from child
	protected Compat_EntityPlayerMP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayerMP(EntityPlayerMP original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPlayerMP.class, original));
	}

	protected void initialize(CompatI_EntityPlayerMP wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityPlayerMP getReal() {
		return wrapper.get();
	}
}
