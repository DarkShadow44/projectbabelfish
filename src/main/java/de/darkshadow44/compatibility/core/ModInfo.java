package de.darkshadow44.compatibility.core;

public class ModInfo {
	public final String id;
	public final String className;
	private Object mod;
	private Object proxy;

	public ModInfo(String id, String className) {
		this.id = id;
		this.className = className;
	}

	public Object getMod() {
		return mod;
	}

	public void setMod(Object mod) {
		this.mod = mod;
	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
}
