package compat.sandbox.net.minecraftforge.fml.common.registry;

import java.lang.reflect.Constructor;
import java.util.HashSet;

import compat.core.CompatibilityMod;
import compat.core.RegistrationInfoBlock;
import compat.core.RegistrationInfoItem;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraft.item.Compat_ItemBlock;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.item.crafting.Compat_IRecipe;
import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import compat.sandbox.net.minecraft.util.Compat_SoundEvent;
import compat.sandbox.net.minecraftforge.fml.common.Compat_IFuelHandler;
import compat.sandbox.net.minecraftforge.fml.common.Compat_IWorldGenerator;
import compat.sandbox.net.minecraftforge.fml.common.Wrapper_IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Compat_GameRegistry {

	public static Compat_IForgeRegistryEntry<?> Compat_register(Compat_IForgeRegistryEntry<?> p1, Compat_ResourceLocation p2) {

		if (p1 instanceof Compat_Block) {
			Block block = ((Compat_Block) p1).getReal();
			CompatibilityMod.CURRENT_LAYER.blocksToRegister.add(new RegistrationInfoBlock(block, p2.getReal()));
		} else if (p1 instanceof Compat_Item) {
			Item item = ((Compat_Item) p1).getReal();
			CompatibilityMod.CURRENT_LAYER.itemsToRegister.add(new RegistrationInfoItem(item, null, p2.getReal()));
		} else if (p1 instanceof Compat_SoundEvent) {
			// TODO
		} else {
			throw new RuntimeException();
		}

		return p1;
	}

	public static Compat_IForgeRegistryEntry<?> Compat_register(Compat_IForgeRegistryEntry<?> p1) {

		if (p1 instanceof Compat_Block) {
			Block block = ((Compat_Block) p1).getReal();
			CompatibilityMod.CURRENT_LAYER.blocksToRegister.add(new RegistrationInfoBlock(block, null));
		} else if (p1 instanceof Compat_Item) {
			Item item = ((Compat_Item) p1).getReal();
			CompatibilityMod.CURRENT_LAYER.itemsToRegister.add(new RegistrationInfoItem(item, null, null));
		} else {
			throw new RuntimeException();
		}

		return p1;
	}

	public static void Compat_registerTileEntityWithAlternatives(Class<? extends TileEntity> tileEntityClass, String id, String... alternatives) {
		GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(id));
		// TODO
	}

	private static HashSet<Class<?>> tiles = new HashSet<>();

	public static void Compat_registerTileEntity(Class<? extends TileEntity> clazz, String key) {
		if (tiles.contains(clazz)) {
			System.out.println("########## Compatibility: Found duplicate tile entity registration: " + clazz.getName());
			return; // TODO
		}
		tiles.add(clazz);
		GameRegistry.registerTileEntity(clazz, new ResourceLocation(key)); // TODO class?
	}

	public static void Compat_addRecipe(Compat_IRecipe recipe) {
		// TODO
	}

	public static void Compat_registerWorldGenerator(Compat_IWorldGenerator generator, int modGenerationWeight) {
		GameRegistry.registerWorldGenerator(new Wrapper_IWorldGenerator(generator), modGenerationWeight);
	}

	public static Compat_Block Compat_registerBlock(Compat_Block block, String name) {
		return Compat_registerBlock(block, Compat_ItemBlock.class, name);
	}

	public static Compat_Block Compat_registerBlock(Compat_Block block, Class<?> itemClass, String name) {
		ResourceLocation location = new ResourceLocation(CompatibilityMod.CURRENT_LAYER.getCurrentModId(), name);
		CompatibilityMod.CURRENT_LAYER.blocksToRegister.add(new RegistrationInfoBlock(block.getReal(), location));

		try {
			Constructor<?> ctorItem = itemClass.getConstructor(Compat_Block.class);
			Compat_ItemBlock itemBlock = (Compat_ItemBlock) ctorItem.newInstance(block);
			Compat_registerItem(itemBlock, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		return block;
	}

	public static void Compat_registerFuelHandler(Compat_IFuelHandler handler) {
		// TODO
	}

	public static void Compat_registerItem(Compat_Item item, String name) {
		// TODO
		CompatibilityMod.CURRENT_LAYER.itemsToRegister.add(new RegistrationInfoItem(item.getReal(), name, null));
	}

	public static void Compat_addShapelessRecipe(Compat_ItemStack stack, Object[] params) {
		// TODO
	}

	public static void Compat_addRecipe(Compat_ItemStack stack, Object[] params) {
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
