package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.registry;

import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class Compat_VillagerRegistry {

	VillagerRegistry original;

	public Compat_VillagerRegistry(VillagerRegistry original) {
		this.original = original;
	}

	public static Compat_VillagerRegistry Compat_instance() {
		return new Compat_VillagerRegistry(VillagerRegistry.instance());
	}

	public void Compat_registerVillagerId(int sd) {
		// TODO
	}
}
