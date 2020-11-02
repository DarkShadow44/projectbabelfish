package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.effect;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.effect.EntityLightningBolt;

public class Compat_EntityLightningBolt extends Compat_EntityWeatherEffect {
	private CompatI_EntityLightningBolt wrapper;

	// When called from Mod
	public Compat_EntityLightningBolt() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityLightningBolt.class, this));
	}

	// When called from child
	protected Compat_EntityLightningBolt(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityLightningBolt(EntityLightningBolt original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityLightningBolt.class, original));
	}

	protected void initialize(CompatI_EntityLightningBolt wrapper) {
		this.wrapper = wrapper;
	}

	public EntityLightningBolt getReal() {
		return wrapper.get();
	}
}
