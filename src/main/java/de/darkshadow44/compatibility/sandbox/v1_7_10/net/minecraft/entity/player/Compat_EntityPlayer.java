package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Compat_EntityPlayer extends Compat_EntityLivingBase {
	private CompatI_EntityPlayer wrapper;

	// When called from Mod
	public Compat_EntityPlayer(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayer.class, this, world.getReal(), null)); // TODO
	}

	// When called from child
	protected Compat_EntityPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayer(EntityPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPlayer.class, original));
	}

	protected void initialize(CompatI_EntityPlayer wrapper) {
		this.wrapper = wrapper;
	}

	public EntityPlayer getReal() {
		return wrapper.get();
	}
}
