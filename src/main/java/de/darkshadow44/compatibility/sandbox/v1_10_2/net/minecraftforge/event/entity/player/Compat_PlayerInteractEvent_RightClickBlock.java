package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_ItemStack;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumHand;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

public class Compat_PlayerInteractEvent_RightClickBlock {
	private final RightClickBlock original;

	public Compat_PlayerInteractEvent_RightClickBlock(RightClickBlock original) {
		this.original = original;
	}

	public RightClickBlock getReal() {
		return original;
	}

	public Compat_World Compat_getWorld() {
		return Compat_World.get_fake(original.getWorld());
	}

	public Compat_EnumHand Compat_getHand() {
		return Compat_EnumHand.map_real_to_fake(original.getHand());
	}

	public Compat_ItemStack Compat_getItemStack() {
		return new Compat_ItemStack(original.getItemStack());
	}

}
