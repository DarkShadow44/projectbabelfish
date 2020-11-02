package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class Compat_TickEvent_ServerTickEvent {

	private final ServerTickEvent original;

	public Compat_TickEvent_ServerTickEvent(ServerTickEvent original) {
		this.original = original;
	}

	public ServerTickEvent getReal() {
		return original;
	}
}
