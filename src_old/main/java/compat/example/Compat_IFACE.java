package compat.example;

public interface Compat_IFACE {
	public static Compat_IFACE getFake(IFACE real) {
		if (real instanceof Wrapper2_IFACE) {
			return ((Wrapper2_IFACE) real).getFake();
		}
		return new Wrapper_IFACE(real);
	}

	public static IFACE getReal(Compat_IFACE fake) {
		if (fake instanceof Wrapper_IFACE) {
			return ((Wrapper_IFACE) fake).getReal();
		}
		return new Wrapper2_IFACE(fake);
	}
}
