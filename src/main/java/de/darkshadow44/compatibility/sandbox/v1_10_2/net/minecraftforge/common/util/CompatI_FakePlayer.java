package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.util;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.CompatI_EntityPlayerMP;
import net.minecraftforge.common.util.FakePlayer;

public interface CompatI_FakePlayer extends CompatI_EntityPlayerMP {
	public FakePlayer get();
}
