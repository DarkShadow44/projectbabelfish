package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Compat_PlayerInteractEvent extends Compat_Event {
	private CompatI_PlayerInteractEvent wrapper;

	// When called from Mod
	public Compat_PlayerInteractEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractEvent.class, this));
	}

	// When called from child
	protected Compat_PlayerInteractEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerInteractEvent(PlayerInteractEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerInteractEvent.class, original));
	}

	protected void initialize(CompatI_PlayerInteractEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public PlayerInteractEvent getReal() {
		return wrapper.get();
	}

	public Compat_World Compat_getWorld() {
		return Compat_World.getFake(wrapper.getWorldSuper());
	}

	public Compat_EnumHand Compat_getHand() {
		return Compat_EnumHand.getFake(wrapper.getHandSuper());
	}

	public Compat_ItemStack Compat_getItemStack() {
		ItemStack stack = wrapper.getItemStackSuper();
		return stack == null || stack.isEmpty() ? null : new Compat_ItemStack(stack);
	}

	public Compat_EntityPlayer Compat_getEntityPlayer() {
		return new Compat_EntityPlayer(wrapper.getEntityPlayerSuper());
	}

	public Compat_BlockPos Compat_getPos() {
		return new Compat_BlockPos(wrapper.getPosSuper());
	}

	public Compat_EnumFacing Compat_getFace() {
		return Compat_EnumFacing.getFake(wrapper.getFaceSuper());
	}
}
