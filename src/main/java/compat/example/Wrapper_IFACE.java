package compat.example;

public class Wrapper_IFACE implements Compat_IFACE {
	private final IFACE original;

	public Wrapper_IFACE(IFACE original) {
		this.original = original;
	}

	public IFACE getReal() {
		return original;
	}
}
