package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public enum Compat_TickEvent_Phase {

	START(Phase.START),
	END(Phase.END);

	private Phase original;

	private Compat_TickEvent_Phase(Phase original) {
		this.original = original;
	}

	public Phase getReal() {
		return original;
	}

	public static Compat_TickEvent_Phase getFake(Phase real) {
		switch (real) {
		case START:
			return START;
		case END:
			return END;
		default:
			throw new RuntimeException("Unhandled " + real.name());
		}
	}

	public static Compat_TickEvent_Phase Compat_get_START() {
		return START;
	}

	public static Compat_TickEvent_Phase Compat_get_END() {
		return END;
	}
}
