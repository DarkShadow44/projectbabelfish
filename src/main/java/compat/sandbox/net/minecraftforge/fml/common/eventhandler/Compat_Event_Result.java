package compat.sandbox.net.minecraftforge.fml.common.eventhandler;

import net.minecraftforge.eventbus.api.Event.Result;

public enum Compat_Event_Result {
	DENY(Result.DENY),
	DEFAULT(Result.DEFAULT),
	ALLOW(Result.ALLOW);

	private Result original;

	private Compat_Event_Result(Result original) {
		this.original = original;
	}

	public Result getReal() {
		return original;
	}

	public static Compat_Event_Result Compat_get_DENY() {
		return DENY;
	}

	public static Compat_Event_Result Compat_get_DEFAULT() {
		return DEFAULT;
	}

	public static Compat_Event_Result Compat_get_ALLOW() {
		return ALLOW;
	}
}
