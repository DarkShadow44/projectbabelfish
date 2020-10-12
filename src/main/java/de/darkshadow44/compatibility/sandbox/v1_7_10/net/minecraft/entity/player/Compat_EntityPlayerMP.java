package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.player.EntityPlayerMP;

public class Compat_EntityPlayerMP extends Compat_EntityPlayer {
	private EntityPlayerMP original;
	private CompatI_EntityPlayerMP thisReal;

	// When called from Mod
	public Compat_EntityPlayerMP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_EntityPlayerMP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayerMP(EntityPlayerMP original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityPlayerMP thisReal, EntityPlayerMP original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPlayerMP getReal() {
		return original == null ? thisReal.get() : original;
	}
}
