package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class Compat_PlayerEvent_ItemCraftedEvent extends Compat_PlayerEvent {
	private CompatI_PlayerEvent_ItemCraftedEvent wrapper;

	// When called from Mod
	public Compat_PlayerEvent_ItemCraftedEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerEvent_ItemCraftedEvent.class, this));
	}

	// When called from child
	protected Compat_PlayerEvent_ItemCraftedEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerEvent_ItemCraftedEvent(ItemCraftedEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_PlayerEvent_ItemCraftedEvent.class, original));
	}

	protected void initialize(CompatI_PlayerEvent_ItemCraftedEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemCraftedEvent getReal() {
		return wrapper.get();
	}
}
