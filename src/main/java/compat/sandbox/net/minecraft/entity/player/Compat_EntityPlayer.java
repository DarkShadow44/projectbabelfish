package compat.sandbox.net.minecraft.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.entity.Compat_EntityLivingBase;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.server.Compat_MinecraftServer;
import compat.sandbox.net.minecraft.stats.Compat_StatBase;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.util.text.Compat_ITextComponent;
import compat.sandbox.net.minecraft.world.Compat_IInteractionObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class Compat_EntityPlayer extends Compat_EntityLivingBase {
	private CompatI_EntityPlayer wrapper;

	// When called from Mod
	public Compat_EntityPlayer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayer.class, this));
	}

	// When called from child
	protected Compat_EntityPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayer(EntityPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPlayer.class, original));
	}

	protected void initialize(CompatI_EntityPlayer wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityPlayer getReal() {
		return wrapper.get();
	}

	public boolean Compat_func_175151_a(Compat_BlockPos pos, Compat_EnumFacing facing, Compat_ItemStack stack) {
		return wrapper.canPlayerEditSuper(pos.getReal(), facing.getReal(), stack.getReal());
	}

	public static Compat_EntityPlayer getFake(EntityPlayer real) {
		if (real instanceof EntityPlayerMP) {
			return new Compat_EntityPlayerMP((EntityPlayerMP) real);
		} else {
			return new Compat_EntityPlayer(real);
		}
	}

	public boolean Compat_func_184812_l_() {
		return wrapper.isCreativeSuper();
	}

	public float Compat_func_70047_e() {
		return wrapper.getEyeHeightSuper();
	}

	public Compat_PlayerCapabilities Compat_get_field_71075_bZ() {
		return new Compat_PlayerCapabilities(wrapper.get_capabilities());
	}

	public void Compat_func_145747_a(Compat_ITextComponent text) {
		wrapper.sendMessageSuper(Compat_ITextComponent.getReal(text));
	}

	public void Compat_func_180468_a(Compat_IInteractionObject obj) {
		wrapper.displayGuiSuper(obj.getReal());
	}

	public Compat_MinecraftServer Compat_func_184102_h() {
		return new Compat_MinecraftServer(wrapper.getServerSuper());
	}

	public Compat_ItemStack Compat_func_184586_b(Compat_EnumHand hand) {
		return Compat_ItemStack.getFake(wrapper.getHeldItemSuper(hand.getReal()));
	}

	public Compat_ItemStack Compat_func_184607_cu() {
		return Compat_ItemStack.getFake(wrapper.getActiveItemStackSuper());
	}

	public void Compat_func_184609_a(Compat_EnumHand hand) {
		wrapper.swingArmSuper(hand.getReal());
	}

	public void Compat_func_184611_a(Compat_EnumHand hand, Compat_ItemStack stack) {
		wrapper.setHeldItemSuper(hand.getReal(), stack.getReal());
	}

	public double Compat_func_70092_e(double x, double y, double z) {
		return wrapper.getDistanceSqSuper(x, y, z);
	}

	public void Compat_func_71029_a(Compat_StatBase stat) {
		wrapper.addStatSuper(stat.getReal());
	}

	public float Compat_getDigSpeed(Compat_IBlockState state, Compat_BlockPos pos) {
		return wrapper.getDigSpeedSuper(state.getReal(), pos.getReal());
	}

	public float Compat_get_field_70177_z() {
		return wrapper.get_rotationYaw();
	}

	public Compat_InventoryPlayer Compat_get_field_71071_by() {
		return new Compat_InventoryPlayer(wrapper.get_inventory());
	}

}
