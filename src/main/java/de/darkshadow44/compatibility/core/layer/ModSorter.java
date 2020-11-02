package de.darkshadow44.compatibility.core.layer;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.core.ModInfo;

public class ModSorter {

	private final List<ModInfo> modsToLoad;
	private final List<ModInfo> sortedMods = new ArrayList<>();

	public ModSorter(List<ModInfo> modsToLoad) {
		this.modsToLoad = modsToLoad;
	}

	private boolean modExists(String id) {
		for (ModInfo mod : modsToLoad) {
			if (mod.id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean isModLoaded(String id) {
		for (ModInfo mod : sortedMods) {
			if (mod.id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean dependenciesSatisfied(ModInfo mod) {
		for (String dep : mod.requiredDependencies) {
			if (!isModLoaded(dep)) {
				return false;
			}
		}
		for (String dep : mod.optionalDependencies) {
			if (modExists(dep) && !isModLoaded(dep)) {
				return false;
			}
		}
		return true;
	}

	public List<ModInfo> sortMods() {
		int lastSize = 0;
		while (sortedMods.size() != modsToLoad.size()) {
			for (ModInfo mod : modsToLoad) {
				if (!isModLoaded(mod.id) && dependenciesSatisfied(mod)) {
					sortedMods.add(mod);
				}
			}
			if (lastSize == sortedMods.size()) {
				throw new RuntimeException("Missing mod!");
			}
			lastSize = sortedMods.size();
		}
		return sortedMods;
	}
}
