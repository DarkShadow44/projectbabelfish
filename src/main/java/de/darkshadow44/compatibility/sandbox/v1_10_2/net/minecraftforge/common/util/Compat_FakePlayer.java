package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.util;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_WorldServer;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player.Compat_EntityPlayerMP;
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
