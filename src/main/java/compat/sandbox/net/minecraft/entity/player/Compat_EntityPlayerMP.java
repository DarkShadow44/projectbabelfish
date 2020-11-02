package compat.sandbox.net.minecraft.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.server.management.Compat_PlayerInteractionManager;
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

	public Compat_PlayerInteractionManager Compat_get_field_71134_c() {
		return new Compat_PlayerInteractionManager(wrapper.get_interactionManager());
	}
}
