package compat.sandbox.net.minecraft.util;

import net.minecraft.util.ActionResult;

public class Compat_ActionResult<T> {

	@SuppressWarnings("unused")
	private final ActionResult<T> original;

	public Compat_ActionResult(ActionResult<T> original) {
		this.original = original;
	}

}
