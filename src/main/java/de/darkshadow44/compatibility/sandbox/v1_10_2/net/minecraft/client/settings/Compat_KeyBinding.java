package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.settings;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.settings.KeyBinding;

public class Compat_KeyBinding implements Comparable<Compat_KeyBinding> {
	private CompatI_KeyBinding wrapper;

	// When called from Mod
	public Compat_KeyBinding(String p1, int p2, String p3) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_KeyBinding.class, this, p1, p2, p3));
	}

	// When called from child
	protected Compat_KeyBinding(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_KeyBinding(KeyBinding original) {
		this.initialize(Factory.createWrapper(CompatI_KeyBinding.class, original));
	}

	protected void initialize(CompatI_KeyBinding wrapper) {
		this.wrapper = wrapper;
	}

	public KeyBinding getReal() {
		return wrapper.get();
	}

	@Override
	public int compareTo(Compat_KeyBinding other) {
		return this.getReal().compareTo(other.getReal());
	}
}
