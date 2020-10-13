package de.darkshadow44.compatibility.example;

public class Compat_ENUM {

	private static final Compat_ENUM VALUE = new Compat_ENUM(ENUM.VALUE);

	private ENUM original;

	public Compat_ENUM(ENUM original) {
		this.original = original;
	}

	public ENUM getReal() {
		return original;
	}

	public static Compat_ENUM Compat_get_VALUE()
	{
		return VALUE;
	}
}
