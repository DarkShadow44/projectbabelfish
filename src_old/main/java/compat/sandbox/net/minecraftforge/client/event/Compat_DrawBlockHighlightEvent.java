package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.util.math.Compat_RayTraceResult;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public class Compat_DrawBlockHighlightEvent extends Compat_Event {
	private CompatI_DrawBlockHighlightEvent wrapper;

	// When called from Mod
	public Compat_DrawBlockHighlightEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_DrawBlockHighlightEvent.class, this));
	}

	// When called from child
	protected Compat_DrawBlockHighlightEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_DrawBlockHighlightEvent(DrawBlockHighlightEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_DrawBlockHighlightEvent.class, original));
	}

	protected void initialize(CompatI_DrawBlockHighlightEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public DrawBlockHighlightEvent getReal() {
		return wrapper.get();
	}

	public Compat_RayTraceResult Compat_getTarget() {
		return Compat_RayTraceResult.getFake(wrapper.getTargetSuper());
	}

	public Compat_EntityPlayer Compat_getPlayer() {
		EntityPlayer player = wrapper.getPlayerSuper();
		return player == null ? null : new Compat_EntityPlayer(player);
	}

	public float Compat_getPartialTicks() {
		return wrapper.getPartialTicksSuper();
	}
}
