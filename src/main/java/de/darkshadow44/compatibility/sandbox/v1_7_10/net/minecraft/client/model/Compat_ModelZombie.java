package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelZombie;

public class Compat_ModelZombie extends Compat_ModelBiped {
	private ModelZombie original;
	private CompatI_ModelZombie thisReal;

	// When called from Mod
	public Compat_ModelZombie() {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_ModelZombie(this), null);
	}

	// When called from child
	protected Compat_ModelZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelZombie(ModelZombie original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_ModelZombie thisReal, ModelZombie original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelZombie getReal() {
		return original == null ? thisReal.get() : original;
	}
}
