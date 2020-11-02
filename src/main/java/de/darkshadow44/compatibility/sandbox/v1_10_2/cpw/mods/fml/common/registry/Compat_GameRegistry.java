package de.darkshadow44.compatibility.sandbox.v1_10_2.cpw.mods.fml.common.registry;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import de.darkshadow44.compatibility.core.RegistrationInfoBlock;
import de.darkshadow44.compatibility.core.RegistrationInfoItem;
import de.darkshadow44.compatibility.sandbox.v1_10_2.cpw.mods.fml.common.Compat_IFuelHandler;
import de.darkshadow44.compatibility.sandbox.v1_10_2.cpw.mods.fml.common.Compat_IWorldGenerator;
import de.darkshadow44.compatibility.sandbox.v1_10_2.cpw.mods.fml.common.Wrapper_IWorldGenerator;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_Item;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.crafting.Compat_IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Compat_GameRegistry {
	public static void Compat_registerWorldGenerator(Compat_IWorldGenerator generator, int modGenerationWeight) {
		GameRegistry.registerWorldGenerator(new Wrapper_IWorldGenerator(generator), modGenerationWeight);
	}

	public static Compat_Block Compat_registerBlock(Compat_Block block, String name) {
		// TODO
		CompatibilityMod.LAYER_1_7_10.blocksToRegister.add(new RegistrationInfoBlock(block.getReal(), name, null));
		return block;
	}

	public static Compat_Block Compat_registerBlock(Compat_Block block, Class<?> clazz, String name) {
		// TODO ItemBlock
		CompatibilityMod.LAYER_1_7_10.blocksToRegister.add(new RegistrationInfoBlock(block.getReal(), name, null));
		return block;
	}

	public static void Compat_registerFuelHandler(Compat_IFuelHandler handler) {
		// TODO
	}

	public static void Compat_registerTileEntity(Class<?> clazz, String name) {
		// TODO
	}

	public static void Compat_registerItem(Compat_Item item, String name) {
		// TODO
		CompatibilityMod.LAYER_1_7_10.itemsToRegister.add(new RegistrationInfoItem(item.getReal(), name, null));
	}

	public static void Compat_addShapelessRecipe(Compat_ItemStack stack, Object[] params) {
		// TODO
	}

	public static void Compat_addRecipe(Compat_ItemStack stack, Object[] params) {
		// TODO
	}

	public static void Compat_addRecipe(Compat_IRecipe recipe) {
		// TODO
	}

	public static Compat_IRecipe Compat_addShapedRecipe(Compat_ItemStack stack, Object[] objects) {
		// TODO
		return null;
	}

	public static void Compat_addSmelting(Compat_ItemStack input, Compat_ItemStack output, float xp) {
		GameRegistry.addSmelting(input.getReal(), output.getReal(), xp);
	}

}
