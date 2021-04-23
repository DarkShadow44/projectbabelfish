package net.projectbabelfish;

import generated.net.projectbabelfish.TestImpl;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
		
		ITest test = new TestImpl();
	}
}
