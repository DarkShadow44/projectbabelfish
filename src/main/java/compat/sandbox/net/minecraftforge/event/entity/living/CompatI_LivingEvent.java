package compat.sandbox.net.minecraftforge.event.entity.living;

import compat.sandbox.net.minecraftforge.event.entity.CompatI_EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public interface CompatI_LivingEvent extends CompatI_EntityEvent {
	public LivingEvent get();
}
