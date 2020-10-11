package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.common.util;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.player.Compat_EntityPlayerMP;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_WorldServer;
import net.minecraftforge.common.util.FakePlayer;

public class Compat_FakePlayer extends Compat_EntityPlayerMP {
	private FakePlayer original;
	private CompatI_FakePlayer thisReal;

	// When called from Mod
	public Compat_FakePlayer(Compat_WorldServer world) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_FakePlayer(this, world.getReal(), null), null); // TODO
	}

	// When called from child
	protected Compat_FakePlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_FakePlayer(FakePlayer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_FakePlayer thisReal, FakePlayer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public FakePlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}