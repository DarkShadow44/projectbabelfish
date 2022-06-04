package net.projectbabelfish.sandbox;

public class Compat_Object {
	private Object wrapper;

	public Compat_Object(Object wrapper) {
		this.wrapper = wrapper;
	}

	public Object getReal() {
		return wrapper;
	}
}
