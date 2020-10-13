package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.effect;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.Compat_Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;

public class Compat_EntityWeatherEffect extends Compat_Entity {
	private EntityWeatherEffect original;
	private CompatI_EntityWeatherEffect thisReal;

	// When called from Mod
	public Compat_EntityWeatherEffect() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWeatherEffect.class, this), null);
	}

	// When called from child
	protected Compat_EntityWeatherEffect(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWeatherEffect(EntityWeatherEffect original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityWeatherEffect thisReal, EntityWeatherEffect original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityWeatherEffect getReal() {
		return original == null ? thisReal.get() : original;
	}
}
