package de.darkshadow44.compatibility.core;

import java.util.ArrayList;
import java.util.List;

public class ModInfo {
	public final String id;
	public final String className;
	public final List<Object> eventObjects = new ArrayList<>();
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
		eventObjects.add(mod);
	}

	public Object getProxy() {
		return proxy;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
		eventObjects.add(proxy);
	}

	public void addEventObject(Object obj) {
		eventObjects.add(obj);
	}
}
