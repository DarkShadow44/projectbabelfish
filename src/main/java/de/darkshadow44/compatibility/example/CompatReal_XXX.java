package de.darkshadow44.compatibility.example;

public class CompatReal_XXX extends XXX implements CompatI_XXX {
	@SuppressWarnings("unused")
	private Compat_XXX thisFake;

	public CompatReal_XXX(Compat_XXX thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public XXX get() {
		return this;
	}
}
