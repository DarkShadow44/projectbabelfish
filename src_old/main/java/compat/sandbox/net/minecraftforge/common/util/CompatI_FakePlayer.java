package compat.sandbox.net.minecraftforge.common.util;

import compat.sandbox.net.minecraft.entity.player.CompatI_EntityPlayerMP;
import net.minecraftforge.common.util.FakePlayer;

public interface CompatI_FakePlayer extends CompatI_EntityPlayerMP {
	public FakePlayer get();
}
