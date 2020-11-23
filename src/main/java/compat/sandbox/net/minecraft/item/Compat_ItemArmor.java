package compat.sandbox.net.minecraft.item;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.core.Version;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.inventory.Compat_EntityEquipmentSlot;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Compat_ItemArmor extends Compat_Item {
	private CompatI_ItemArmor wrapper;

	// When called from Mod
	public Compat_ItemArmor(Compat_ItemArmor_ArmorMaterial material, int renderIndex, Compat_EntityEquipmentSlot slot) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemArmor.class, this, material.getReal(), renderIndex, slot.getReal()));
	}

	// When called from child
	protected Compat_ItemArmor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemArmor(ItemArmor original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemArmor.class, original));
	}

	protected void initialize(CompatI_ItemArmor wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemArmor getReal() {
		return wrapper.get();
	}

	public int Compat_get_field_77879_b() {
		return wrapper.get_damageReduceAmount();
	}

	@Callback
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return Compat_getArmorTexture(Compat_ItemStack.getFake(stack), Compat_Entity.getFake(entity), Compat_EntityEquipmentSlot.getFake(slot), type);
	}

	@HasCallback({ Version.V1_10_2 })
	public String Compat_getArmorTexture(Compat_ItemStack stack, Compat_Entity entity, Compat_EntityEquipmentSlot slot, String type) {
		return wrapper.getArmorTextureSuper(stack.getReal(), entity.getReal(), slot.getReal(), type);
	}
}
