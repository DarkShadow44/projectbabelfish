package compat.sandbox.net.minecraft.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_IIconRegister;
import compat.sandbox.net.minecraft.creativetab.Compat_CreativeTabs;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.nbt.Compat_NBTTagCompound;
import compat.sandbox.net.minecraft.util.Compat_ActionResult;
import compat.sandbox.net.minecraft.util.Compat_EnumActionResult;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Compat_Item extends Compat_IForgeRegistryEntry_Impl<Item> {
	private CompatI_Item wrapper;

	// When called from Mod
	public Compat_Item() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this));
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_Item.class, original));
	}

	protected void initialize(CompatI_Item wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Item getReal() {
		return wrapper.get();
	}

	public Compat_Item Compat_func_77655_b(String name) {
		wrapper.setUnlocalizedNameSuper(name);
		return this;
	}

	public Compat_Item Compat_func_77625_d(int size) {
		wrapper.setMaxStackSizeSuper(size);
		return this;
	}

	public Compat_Item Compat_func_77656_e(int damage) {
		wrapper.setMaxDamageSuper(damage);
		return this;
	}

	public Compat_Item Compat_func_77637_a(Compat_CreativeTabs tab) {
		wrapper.setCreativeTabSuper(tab.getReal());
		return this;
	}

	@Callback
	public String getUnlocalizedName(ItemStack stack) {
		return Compat_func_77667_c(Compat_ItemStack.getFake(stack));
	}

	@HasCallback
	public String Compat_func_77667_c(Compat_ItemStack stack) {
		return wrapper.getUnlocalizedNameSuper(stack.getReal());
	}

	@Callback
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		List<Compat_ItemStack> list = new ArrayList<>();
		Compat_func_150895_a(this, Compat_CreativeTabs.getFake(tab), list);

		for (Compat_ItemStack stack : list) {
			items.add(stack.getReal());
		}
	}

	@HasCallback
	public void Compat_func_150895_a(Compat_Item item, Compat_CreativeTabs tab, List<Compat_ItemStack> list) {
		NonNullList<ItemStack> list2 = NonNullList.create();
		wrapper.getSubItemsSuper(tab.getReal(), list2);

		for (ItemStack stack : list2) {
			list.add(new Compat_ItemStack(stack));
		}
	}

	@Callback
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		Compat_func_77663_a(new Compat_ItemStack(stack), new Compat_World(world), new Compat_Entity(entity), itemSlot, isSelected);
	}

	@HasCallback
	public void Compat_func_77663_a(Compat_ItemStack stack, Compat_World world, Compat_Entity entity, int itemSlot, boolean isSelected) {
		wrapper.onUpdateSuper(stack.getReal(), world.getReal(), entity.getReal(), itemSlot, isSelected);
	}

	@Callback
	public boolean canItemEditBlocks() {
		return Compat_func_82788_x();
	}

	@HasCallback
	public boolean Compat_func_82788_x() {
		return wrapper.canItemEditBlocksSuper();
	}

	@Callback
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Compat_ItemStack stack = new Compat_ItemStack(player.getHeldItem(hand));

		return Compat_func_180614_a(stack, new Compat_EntityPlayer(player), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumHand.getFake(hand), Compat_EnumFacing.getFake(facing), hitX, hitY, hitZ).getReal();
	}

	@HasCallback
	public Compat_EnumActionResult Compat_func_180614_a(Compat_ItemStack stack, Compat_EntityPlayer player, Compat_World world, Compat_BlockPos pos, Compat_EnumHand hand, Compat_EnumFacing facing, float hitX, float hitY, float hitZ) {
		EnumActionResult result = wrapper.onItemUseSuper(player.getReal(), world.getReal(), pos.getReal(), hand.getReal(), facing.getReal(), hitX, hitY, hitZ);
		return Compat_EnumActionResult.map_real_to_fake(result);
	}

	// Item objects are unique and can only exist once.
	private static Map<Item, Compat_Item> cacheToFake = new HashMap<>();

	public static Compat_Item get_fake(Item item) {
		if (item instanceof CompatI_Item) {
			return ((CompatI_Item) item).getFake();
		}
		if (!cacheToFake.containsKey(item)) {
			cacheToFake.put(item, new Compat_Item(item));
		}
		return cacheToFake.get(item);
	}

	public static int Compat_func_150891_b(Compat_Item item) {
		return Item.getIdFromItem(item.getReal());
	}

	public Compat_Item Compat_func_77627_a(boolean hasSubtypes) {
		wrapper.setHasSubtypesSuper(hasSubtypes);
		return this;
	}

	private String iconString = null;

	public Compat_Item Compat_func_111206_d(String name) {
		iconString = name;
		return this;
	}

	@SideOnly(Side.CLIENT)
	protected String Compat_func_111208_A() { // getIconString
		return (this.iconString == null) ? ("MISSING_ICON_ITEM") : this.iconString;
	}

	public Compat_Item Compat_setNoRepair() {
		wrapper.setNoRepairSuper();
		return this;
	}

	public Compat_Item Compat_func_77664_n() {
		wrapper.setFull3DSuper();
		return this;
	}

	public void Compat_set_field_77787_bX(boolean hasSubtypes) {
		wrapper.setHasSubtypesSuper(hasSubtypes);
	}

	public Compat_Item Compat_func_77642_a(Compat_Item containerItem) {
		wrapper.setContainerItemSuper(containerItem.getReal());
		return this;
	}

	@SideOnly(Side.CLIENT)
	public void Compat_func_94581_a(Compat_IIconRegister iconRegister) {
		icon = iconRegister.Compat_func_94245_a(Compat_func_111208_A());
	}

	@SideOnly(Side.CLIENT)
	public Compat_IIcon Compat_func_77617_a(int damage) {
		// To be overriden
		return icon;
	}

	private Compat_IIcon icon;

	public void Compat_set_field_77791_bV(Compat_IIcon icon) {
		this.icon = icon;
	}

	public Compat_IIcon Compat_get_field_77791_bV() {
		return icon;
	}

	@Callback
	public String getItemStackDisplayName(ItemStack stack) {
		return Compat_func_77653_i(Compat_ItemStack.getFake(stack));
	}

	@HasCallback
	public String Compat_func_77653_i(Compat_ItemStack itemstack) {
		return wrapper.getItemStackDisplayNameSuper(itemstack.getReal());
	}

	public String Compat_func_77658_a() {
		return wrapper.getUnlocalizedNameSuper();
	}

	public static Compat_Item Compat_func_150898_a(Compat_Block block) {
		Item result = Item.getItemFromBlock(block.getReal());
		return Compat_Item.get_fake(result);
	}

	public int Compat_func_77647_b(int damage) {
		return wrapper.getMetadataSuper(damage);
	}

	@Callback
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		Compat_ItemStack stack = Compat_ItemStack.getFake(player.getHeldItem(hand));
		Compat_ActionResult<ItemStack> result = Compat_func_77659_a(stack, Compat_World.getFake(world), Compat_EntityPlayer.getFake(player), Compat_EnumHand.getFake(hand));
		return result.getReal();
	}

	@HasCallback
	public Compat_ActionResult<ItemStack> Compat_func_77659_a(Compat_ItemStack stack, Compat_World world, Compat_EntityPlayer player, Compat_EnumHand hand) {
		ActionResult<ItemStack> result = wrapper.onItemRightClickSuper(world.getReal(), player.getReal(), hand.getReal());
		return new Compat_ActionResult<ItemStack>(result);
	}

	public int Compat_getHarvestLevel(Compat_ItemStack stack, String toolClass, Compat_EntityPlayer player, Compat_IBlockState state) {
		return wrapper.getHarvestLevelSuper(stack.getReal(), toolClass, player.getReal(), state.getReal());
	}

	@Callback
	public NBTTagCompound getNBTShareTag(ItemStack stack) {
		Compat_NBTTagCompound result = Compat_getNBTShareTag(Compat_ItemStack.getFake(stack));
		return result.getReal();
	}

	@HasCallback
	public Compat_NBTTagCompound Compat_getNBTShareTag(Compat_ItemStack stack) {
		NBTTagCompound result = wrapper.getNBTShareTagSuper(stack.getReal());
		return new Compat_NBTTagCompound(result);
	}

	public Set<String> Compat_getToolClasses(Compat_ItemStack stack) {
		Set<String> result = wrapper.getToolClassesSuper(stack.getReal());
		return result; // TODO ?
	}

	@Callback
	public boolean isRepairable() {
		return Compat_isRepairable();
	}

	@HasCallback
	public boolean Compat_isRepairable() {
		return wrapper.isRepairableSuper();
	}

	@Callback
	public boolean getHasSubtypes() {
		return Compat_func_77614_k();
	}

	@HasCallback
	public boolean Compat_func_77614_k() {
		return wrapper.getHasSubtypesSuper();
	}

}
