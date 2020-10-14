package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.settings.Compat_GameSettings;
import net.minecraft.client.Minecraft;

public class Compat_Minecraft {
	private Minecraft original;
	private CompatI_Minecraft thisReal;

	// When called from Mod
	public Compat_Minecraft() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Minecraft.class, this), null);
	}

	// When called from child
	protected Compat_Minecraft(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Minecraft(Minecraft original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Minecraft thisReal, Minecraft original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Minecraft getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_Minecraft Compat_func_71410_x() {
		return new Compat_Minecraft(Minecraft.getMinecraft());
	}

	public Compat_GameSettings Compat_get_field_71474_y() {
		return new Compat_GameSettings(original.gameSettings);
	}
}
