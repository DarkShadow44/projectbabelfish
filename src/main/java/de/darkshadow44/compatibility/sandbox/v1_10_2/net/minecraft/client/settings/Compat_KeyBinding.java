package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.settings;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.settings.KeyBinding;

public class Compat_KeyBinding implements Comparable<Compat_KeyBinding> {
	private KeyBinding original;
	private CompatI_KeyBinding thisReal;

	// When called from Mod
	public Compat_KeyBinding(String p1, int p2, String p3) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_KeyBinding.class, this, p1, p2, p3), null);
	}

	// When called from child
	protected Compat_KeyBinding(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_KeyBinding(KeyBinding original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_KeyBinding thisReal, KeyBinding original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public KeyBinding getReal() {
		return original == null ? thisReal.get() : original;
	}

	@Override
	public int compareTo(Compat_KeyBinding other) {
		return this.getReal().compareTo(other.getReal());
	}
}
