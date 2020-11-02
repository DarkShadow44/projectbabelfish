package compat.sandbox.net.minecraft.entity.effect;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;

public class Compat_EntityWeatherEffect extends Compat_Entity {
	private CompatI_EntityWeatherEffect wrapper;

	// When called from Mod
	public Compat_EntityWeatherEffect() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWeatherEffect.class, this));
	}

	// When called from child
	protected Compat_EntityWeatherEffect(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWeatherEffect(EntityWeatherEffect original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWeatherEffect.class, original));
	}

	protected void initialize(CompatI_EntityWeatherEffect wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWeatherEffect getReal() {
		return wrapper.get();
	}
}
