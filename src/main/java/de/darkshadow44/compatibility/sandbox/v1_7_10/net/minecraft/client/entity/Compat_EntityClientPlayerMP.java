package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player.Compat_EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;

public class Compat_EntityClientPlayerMP extends Compat_EntityPlayerMP {
	private EntityPlayerMP original;
	private CompatI_EntityClientPlayerMP thisReal;

	// When called from Mod
	public Compat_EntityClientPlayerMP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityClientPlayerMP.class, this), null);
	}

	// When called from child
	protected Compat_EntityClientPlayerMP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityClientPlayerMP(EntityPlayerMP original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityClientPlayerMP thisReal, EntityPlayerMP original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPlayerMP getReal() {
		return original == null ? thisReal.get() : original;
	}
}
