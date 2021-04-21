package compat.sandbox.net.minecraft.block.properties;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.state.AbstractProperty;

public class Compat_PropertyHelper<T extends Comparable<T>> implements Compat_IProperty<T> {
	private CompatI_PropertyHelper<T> wrapper;

	// When called from Mod
	public Compat_PropertyHelper() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PropertyHelper.class, this));
	}

	// When called from child
	protected Compat_PropertyHelper(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PropertyHelper(AbstractProperty<T> original) {
		this.initialize(Factory.createWrapper(CompatI_PropertyHelper.class, original));
	}

	protected void initialize(CompatI_PropertyHelper<T> wrapper) {
		this.wrapper = wrapper;
	}

	public AbstractProperty<T> getReal() {
		return wrapper.get();
	}
}
