package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class CompatReal_World extends World implements CompatI_World {
	@SuppressWarnings("unused")
	private Compat_World thisFake;

	public CompatReal_World(Compat_World thisFake) {
		super(null, null, null, null, false); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public World get() {
		return this;
	}

	@Override
	protected IChunkProvider createChunkProvider() {
		// TODO
		return null;
	}

	@Override
	protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
		// TODO
		return false;
	}
}
