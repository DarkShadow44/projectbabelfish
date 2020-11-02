package compat.sandbox.cpw.mods.fml.common.registry;

import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
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

	public void Compat_registerVillagerSkin(int p1, Compat_ResourceLocation location) {
		// TODO
	}

	public void Compat_registerVillageCreationHandler(Compat_VillagerRegistry_IVillageCreationHandler handler) {
		// TODO
	}

	public void Compat_registerVillageTradeHandler(int p1, Compat_VillagerRegistry_IVillageTradeHandler handler) {
		// TODO
	}
}
