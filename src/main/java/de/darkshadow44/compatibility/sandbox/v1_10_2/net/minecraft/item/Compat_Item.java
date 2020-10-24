package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab.Compat_CreativeTabs;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_Entity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumActionResult;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumHand;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Compat_Item extends Compat_IForgeRegistryEntry_Impl<Item> {
	private Item original;
	private CompatI_Item thisReal;

	// When called from Mod
	public Compat_Item() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this), null);
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Item thisReal, Item original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Item getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Item Compat_func_77655_b(String name) {
		if (this.original == null)
			thisReal.setUnlocalizedNameSuper(name);
		else
			this.original.setUnlocalizedName(name);
		return this;
	}

	public Compat_Item Compat_func_77625_d(int size) {
		if (this.original == null)
			thisReal.setMaxStackSizeSuper(size);
		else
			this.original.setMaxStackSize(size);
		return this;
	}

	public Compat_Item Compat_func_77656_e(int damage) {
		if (this.original == null)
			thisReal.setMaxDamageSuper(damage);
		else
			this.original.setMaxDamage(damage);
		return this;
	}

	public Compat_Item Compat_func_77637_a(Compat_CreativeTabs tab) {
		if (this.original == null)
			thisReal.setCreativeTabSuper(tab.getReal());
		else
			this.original.setCreativeTab(tab.getReal());
		return this;
	}

	@Callback
	public String getUnlocalizedName(ItemStack stack) {
		return Compat_func_77667_c(new Compat_ItemStack(stack));
	}

	public String Compat_func_77667_c(Compat_ItemStack stack) {
		if (this.original == null)
			return thisReal.getUnlocalizedNameSuper(stack.getReal());
		else
			return this.original.getUnlocalizedName(stack.getReal());
	}

	@Callback
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		List<Compat_ItemStack> list = new ArrayList<>();
		Compat_func_150895_a(this, new Compat_CreativeTabs(tab), list);

		for (Compat_ItemStack stack : list) {
			items.add(stack.getReal());
		}
	}

	public void Compat_func_150895_a(Compat_Item item, Compat_CreativeTabs tab, List<Compat_ItemStack> list) {
		NonNullList<ItemStack> list2 = NonNullList.create();
		if (original == null)
			thisReal.getSubItemsSuper(tab.getReal(), list2);
		else
			original.getSubItems(tab.getReal(), list2);

		for (ItemStack stack : list2) {
			list.add(new Compat_ItemStack(stack));
		}
	}

	@Callback
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		Compat_func_77663_a(new Compat_ItemStack(stack), new Compat_World(world), new Compat_Entity(entity), itemSlot, isSelected);
	}

	public void Compat_func_77663_a(Compat_ItemStack stack, Compat_World world, Compat_Entity entity, int itemSlot, boolean isSelected) {
		if (original == null)
			thisReal.onUpdateSuper(stack.getReal(), world.getReal(), entity.getReal(), itemSlot, isSelected);
		else
			original.onUpdate(stack.getReal(), world.getReal(), entity.getReal(), itemSlot, isSelected);
	}

	@Callback
	public boolean canItemEditBlocks() {
		return Compat_func_82788_x();
	}

	public boolean Compat_func_82788_x() {
		if (original == null)
			return thisReal.canItemEditBlocksSuper();
		else
			return original.canItemEditBlocks();
	}

	@Callback
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Compat_ItemStack stack = new Compat_ItemStack(player.getHeldItem(hand));
		return Compat_func_180614_a(stack, new Compat_EntityPlayer(player), new Compat_World(world), new Compat_BlockPos(pos), Compat_EnumHand.map_real_to_fake(hand), Compat_EnumFacing.map_real_to_fake(facing), hitX, hitY, hitZ).getReal();
	}

	public Compat_EnumActionResult Compat_func_180614_a(Compat_ItemStack stack, Compat_EntityPlayer player, Compat_World world, Compat_BlockPos pos, Compat_EnumHand hand, Compat_EnumFacing facing, float hitX, float hitY, float hitZ) {
		EnumActionResult result;
		if (original == null)
			result = thisReal.onItemUseSuper(player.getReal(), world.getReal(), pos.getReal(), hand.getReal(), facing.getReal(), hitX, hitY, hitZ);
		else
			result = original.onItemUse(player.getReal(), world.getReal(), pos.getReal(), hand.getReal(), facing.getReal(), hitX, hitY, hitZ);
		return Compat_EnumActionResult.map_real_to_fake(result);
	}

}
