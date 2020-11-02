package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;

public class Compat_PlayerInteractEvent_LeftClickBlock extends Compat_PlayerInteractEvent {
	private CompatI_PlayerInteractEvent_LeftClickBlock wrapper;

	// When called from Mod
	public Compat_PlayerInteractEvent_LeftClickBlock() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractEvent_LeftClickBlock.class, this));
	}

	// When called from child
	protected Compat_PlayerInteractEvent_LeftClickBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerInteractEvent_LeftClickBlock(LeftClickBlock original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerInteractEvent_LeftClickBlock.class, original));
	}

	protected void initialize(CompatI_PlayerInteractEvent_LeftClickBlock wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public LeftClickBlock getReal() {
		return wrapper.get();
	}
}
