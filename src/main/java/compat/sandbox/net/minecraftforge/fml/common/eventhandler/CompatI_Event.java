package compat.sandbox.net.minecraftforge.fml.common.eventhandler;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public interface CompatI_Event {
	public Event get();

	public void setCanceledSuper(boolean value);

	public void setResultSuper(Result result);
}
