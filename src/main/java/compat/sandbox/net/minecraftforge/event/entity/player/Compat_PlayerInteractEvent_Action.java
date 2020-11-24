package compat.sandbox.net.minecraftforge.event.entity.player;

public enum Compat_PlayerInteractEvent_Action {

	RIGHT_CLICK_AIR,
	RIGHT_CLICK_BLOCK,
	LEFT_CLICK_BLOCK;

	private Compat_PlayerInteractEvent_Action() {

	}

	public static Compat_PlayerInteractEvent_Action Compat_get_RIGHT_CLICK_AIR() {
		return RIGHT_CLICK_AIR;
	}
}
