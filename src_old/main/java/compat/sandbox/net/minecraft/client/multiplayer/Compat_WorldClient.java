package compat.sandbox.net.minecraft.client.multiplayer;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_SoundCategory;
import compat.sandbox.net.minecraft.util.Compat_SoundEvent;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.client.multiplayer.WorldClient;

public class Compat_WorldClient extends Compat_World {
	private CompatI_WorldClient wrapper;

	// When called from Mod
	public Compat_WorldClient() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldClient.class, this));
	}

	// When called from child
	protected Compat_WorldClient(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldClient(WorldClient original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldClient.class, original));
	}

	protected void initialize(CompatI_WorldClient wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldClient getReal() {
		return wrapper.get();
	}

	public void Compat_func_184156_a(Compat_BlockPos pos, Compat_SoundEvent sound, Compat_SoundCategory category, float volume, float pitch, boolean distanceDelay) {
		wrapper.playSoundSuper(pos.getReal(), sound.getReal(), category.getReal(), volume, pitch, distanceDelay);
	}
}
