package compat.sandbox.net.minecraft.client.multiplayer;

import compat.sandbox.net.minecraft.world.CompatI_World;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;

public interface CompatI_WorldClient extends CompatI_World {
	public WorldClient get();

	public void playSoundSuper(BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch, boolean distanceDelay);
}
