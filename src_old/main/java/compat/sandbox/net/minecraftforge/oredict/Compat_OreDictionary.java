package compat.sandbox.net.minecraftforge.oredict;

import java.util.ArrayList;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class Compat_OreDictionary {
	public static int[] Compat_getOreIDs(Compat_ItemStack stack) {
		return OreDictionary.getOreIDs(stack.getReal());
	}

	public static String Compat_getOreName(int id) {
		return OreDictionary.getOreName(id);
	}

	public static ArrayList<Compat_ItemStack> Compat_getOres(String key) {
		NonNullList<ItemStack> result = OreDictionary.getOres(key);
		ArrayList<Compat_ItemStack> ret = new ArrayList<>();
		for (ItemStack stack : result) {
			ret.add(new Compat_ItemStack(stack));
		}
		return ret;
	}

	public static void Compat_registerOre(String name, Compat_ItemStack ore) {
		OreDictionary.registerOre(name, ore.getReal());
	}

	public static void Compat_registerOre(String name, Compat_Block block) {
		OreDictionary.registerOre(name, block.getReal());
	}

	public static void Compat_registerOre(String name, Compat_Item item) {
		OreDictionary.registerOre(name, item.getReal());
	}
}
