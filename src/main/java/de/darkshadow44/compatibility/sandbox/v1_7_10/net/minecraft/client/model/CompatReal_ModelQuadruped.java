package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelQuadruped;

public class CompatReal_ModelQuadruped extends ModelQuadruped implements CompatI_ModelQuadruped {
	@SuppressWarnings("unused")
	private Compat_ModelQuadruped thisFake;

	public CompatReal_ModelQuadruped(Compat_ModelQuadruped thisFake, int p1, float p2) {
		super(p1, p2);
		this.thisFake = thisFake;
	}

	@Override
	public ModelQuadruped get() {
		return this;
	}
}
