package compat.sandbox.net.minecraft.util;

public class Compat_Tuple<A, B> {

	private A a;
	private B b;

	public Compat_Tuple(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getFirst() {
		return a;
	}

	public B getSecond() {
		return b;
	}
}
