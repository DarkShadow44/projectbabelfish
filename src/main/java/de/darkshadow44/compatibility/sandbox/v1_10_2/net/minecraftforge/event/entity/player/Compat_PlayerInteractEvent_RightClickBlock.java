package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

public class Compat_PlayerInteractEvent_RightClickBlock extends Compat_PlayerInteractEvent {
	private RightClickBlock original;
	private CompatI_PlayerInteractEvent_RightClickBlock thisReal;

	// When called from Mod
	public Compat_PlayerInteractEvent_RightClickBlock() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractEvent_RightClickBlock.class, this), null);
	}

	// When called from child
	protected Compat_PlayerInteractEvent_RightClickBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerInteractEvent_RightClickBlock(RightClickBlock original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PlayerInteractEvent_RightClickBlock thisReal, RightClickBlock original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RightClickBlock getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Vec3d Compat_getHitVec() {
		return new Compat_Vec3d(original.getHitVec());
	}
}
