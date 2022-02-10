package net.projectbabelfish.core;

import java.util.ArrayList;
import java.util.List;

public class ModInfo {
	public final String id;
	public final String className;
	public final List<Object> eventObjects = new ArrayList<>();
	public final List<String> optionalDependencies = new ArrayList<>();
	public final List<String> requiredDependencies = new ArrayList<>();
	private Object mod;
	private Object proxy;

	public ModInfo(String id, String className, String dependencies) {
		this.id = id.toLowerCase();
		this.className = className;
		setupDependencies(dependencies.toLowerCase());
	}

	private void setupDependencies(String dependencyString) {
		if (dependencyString.isEmpty()) {
			return;
		}
		String[] dependencies = dependencyString.split("\\;");
		for (String dependency : dependencies) {
			String[] split = dependency.split("\\:");
			String req = split[0];
			String mod = split[1];
			if (mod.contains("@")) {
				mod = mod.substring(0, mod.indexOf("@"));
			}
			if (mod.equals("forge")) {
				continue;
			}
			if (req.equals("required-after")) {
				requiredDependencies.add(mod);
			} else {
				throw new RuntimeException();
			}
		}
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