package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumActionResult;

public enum Compat_EnumActionResult {

	SUCCESS(EnumActionResult.SUCCESS), PASS(EnumActionResult.PASS), FAIL(EnumActionResult.FAIL);

	private EnumActionResult original;

	private Compat_EnumActionResult(EnumActionResult original) {
		this.original = original;
	}

	public EnumActionResult getReal() {
		return original;
	}

	public static EnumActionResult map_fake_to_real(Compat_EnumActionResult fake) {
		switch (fake) {
		case SUCCESS:
			return EnumActionResult.SUCCESS;
		case PASS:
			return EnumActionResult.PASS;
		case FAIL:
			return EnumActionResult.FAIL;
		}
		return null;
	}

	public static Compat_EnumActionResult map_real_to_fake(EnumActionResult real) {
		switch (real) {
		case SUCCESS:
			return SUCCESS;
		case PASS:
			return PASS;
		case FAIL:
			return FAIL;
		}
		return null;
	}

	public static Compat_EnumActionResult Compat_get_SUCCESS() {
		return SUCCESS;
	}

	public static Compat_EnumActionResult Compat_get_PASS() {
		return PASS;
	}

	public static Compat_EnumActionResult Compat_get_FAIL() {
		return FAIL;
	}
}
