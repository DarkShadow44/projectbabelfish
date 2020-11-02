package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

public class Compat_PlayerInteractEvent_RightClickBlock extends Compat_PlayerInteractEvent {
	private CompatI_PlayerInteractEvent_RightClickBlock wrapper;

	// When called from Mod
	public Compat_PlayerInteractEvent_RightClickBlock() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractEvent_RightClickBlock.class, this));
	}

	// When called from child
	protected Compat_PlayerInteractEvent_RightClickBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerInteractEvent_RightClickBlock(RightClickBlock original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerInteractEvent_RightClickBlock.class, original));
	}

	protected void initialize(CompatI_PlayerInteractEvent_RightClickBlock wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public RightClickBlock getReal() {
		return wrapper.get();
	}

	public Compat_Vec3d Compat_getHitVec() {
		return new Compat_Vec3d(wrapper.getHitVecSuper());
	}
}
