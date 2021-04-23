package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraftforge.event.entity.living.Compat_LivingEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class Compat_PlayerEvent extends Compat_LivingEvent {
	private CompatI_PlayerEvent wrapper;

	// When called from Mod
	public Compat_PlayerEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerEvent.class, this));
	}

	// When called from child
	protected Compat_PlayerEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerEvent(PlayerEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerEvent.class, original));
	}

	protected void initialize(CompatI_PlayerEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PlayerEvent getReal() {
		return wrapper.get();
	}

	public Compat_EntityPlayer Compat_getEntityPlayer() {
		EntityPlayer result = wrapper.getEntityPlayerSuper();
		return Compat_EntityPlayer.getFake(result);
	}

	public Compat_EntityPlayer Compat_get_entityPlayer() {
		return Compat_getEntityPlayer();
	}
}
