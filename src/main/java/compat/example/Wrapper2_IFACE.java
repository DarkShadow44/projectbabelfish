package compat.example;

public class Wrapper2_IFACE implements IFACE {

	private final Compat_IFACE original;

	public Wrapper2_IFACE(Compat_IFACE original) {
		this.original = original;
	}

	public Compat_IFACE getFake() {
		return original;
	}

}
