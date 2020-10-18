package de.darkshadow44.compatibility.core.model;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTest extends Item {

	public ItemTest() {
		super();
		this.setRegistryName("testitem");
		this.setUnlocalizedName("testitem");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		stack.setItemDamage((stack.getItemDamage() + 1) % 3);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
