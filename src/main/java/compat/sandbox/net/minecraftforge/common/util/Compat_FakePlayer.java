package compat.sandbox.net.minecraftforge.common.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayerMP;
import compat.sandbox.net.minecraft.world.Compat_WorldServer;
import net.minecraftforge.common.util.FakePlayer;

public class Compat_FakePlayer extends Compat_EntityPlayerMP {
	private CompatI_FakePlayer wrapper;

	// When called from Mod
	public Compat_FakePlayer(Compat_WorldServer world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FakePlayer.class, this, world.getReal(), null)); // TODO
	}

	// When called from child
	protected Compat_FakePlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_FakePlayer(FakePlayer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_FakePlayer.class, original));
	}

	protected void initialize(CompatI_FakePlayer wrapper) {
		this.wrapper = wrapper;
	}

	public FakePlayer getReal() {
		return wrapper.get();
	}
}
