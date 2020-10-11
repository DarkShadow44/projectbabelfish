package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import net.minecraft.client.renderer.Tessellator;

public class CompatReal_Tessellator extends Tessellator implements CompatI_Tessellator {
	@SuppressWarnings("unused")
	private Compat_Tessellator thisFake;

	public CompatReal_Tessellator(Compat_Tessellator thisFake, int p1) {
		super(p1);
		this.thisFake = thisFake;
	}

	@Override
	public Tessellator get() {
		return this;
	}
}
