package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityLivingBase;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.player.EntityPlayer;

public class Compat_EntityPlayer extends Compat_EntityLivingBase {
	private EntityPlayer original;
	private CompatI_EntityPlayer thisReal;

	// When called from Mod
	public Compat_EntityPlayer(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_EntityPlayer(this, world.getReal(), null), null); // TODO
	}

	// When called from child
	protected Compat_EntityPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayer(EntityPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityPlayer thisReal, EntityPlayer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
