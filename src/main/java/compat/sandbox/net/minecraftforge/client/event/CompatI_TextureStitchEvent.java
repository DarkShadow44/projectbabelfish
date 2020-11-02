package compat.sandbox.net.minecraftforge.client.event;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.client.event.TextureStitchEvent;

public interface CompatI_TextureStitchEvent extends CompatI_Event {
	public TextureStitchEvent get();
}
