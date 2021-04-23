package compat.sandbox.net.minecraft.util.text.event;

import net.minecraft.util.text.event.ClickEvent.Action;

public enum Compat_ClickEvent_Action {

	OPEN_URL(Action.OPEN_URL),
	OPEN_FILE(Action.OPEN_FILE),
	RUN_COMMAND(Action.RUN_COMMAND),
	SUGGEST_COMMAND(Action.SUGGEST_COMMAND),
	CHANGE_PAGE(Action.CHANGE_PAGE);

	private Action original;

	private Compat_ClickEvent_Action(Action original) {
		this.original = original;
	}

	public static Compat_ClickEvent_Action getFake(Action real) {
		switch (real) {
		case OPEN_URL:
			return OPEN_URL;
		case OPEN_FILE:
			return OPEN_FILE;
		case RUN_COMMAND:
			return RUN_COMMAND;
		case SUGGEST_COMMAND:
			return SUGGEST_COMMAND;
		case CHANGE_PAGE:
			return CHANGE_PAGE;
		default:
			throw new RuntimeException("Unimplemented " + real.name());
		}
	}

	public Action getReal() {
		return original;
	}

	public Compat_ClickEvent_Action Compat_get_OPEN_URL() {
		return OPEN_URL;
	}
}
