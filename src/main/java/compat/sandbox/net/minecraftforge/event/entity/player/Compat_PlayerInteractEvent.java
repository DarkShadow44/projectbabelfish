package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event_Result;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;

public class Compat_PlayerInteractEvent extends Compat_PlayerEvent {
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

	public Compat_BlockPos Compat_getPos() {
		return new Compat_BlockPos(wrapper.getPosSuper());
	}

	public Compat_EnumFacing Compat_getFace() {
		return Compat_EnumFacing.getFake(wrapper.getFaceSuper());
	}

	public Compat_PlayerInteractEvent_Action Compat_get_action() {
		if (getReal() instanceof RightClickBlock) {
			return Compat_PlayerInteractEvent_Action.RIGHT_CLICK_BLOCK;
		}
		if (getReal() instanceof LeftClickEmpty) {
			return Compat_PlayerInteractEvent_Action.LEFT_CLICK_BLOCK;
		}

		if (getReal() instanceof RightClickEmpty) {
			return Compat_PlayerInteractEvent_Action.RIGHT_CLICK_AIR;
		}
		throw new RuntimeException("Don't know what to do!");
	}

	public int Compat_get_face() {
		EnumFacing result = wrapper.getFaceSuper();
		return Compat_EnumFacing.getSideInt(result);
	}

	public Compat_World Compat_get_world() {
		World result = wrapper.getWorldSuper();
		return Compat_World.getFake(result);
	}

	public int Compat_get_x() {
		return wrapper.getPosSuper().getX();
	}

	public int Compat_get_y() {
		return wrapper.getPosSuper().getY();
	}

	public int Compat_get_z() {
		return wrapper.getPosSuper().getZ();
	}

	public void Compat_set_useItem(Compat_Event_Result result) {
		wrapper.setResultSuper(result.getReal());
	}
}
