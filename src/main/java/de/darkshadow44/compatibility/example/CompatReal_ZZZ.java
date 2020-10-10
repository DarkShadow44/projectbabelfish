package de.darkshadow44.compatibility.example;

public class CompatReal_ZZZ extends ZZZ implements CompatI_ZZZ {
	@SuppressWarnings("unused")
	private Compat_ZZZ thisFake;

	public CompatReal_ZZZ(Compat_ZZZ thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ZZZ get() {
		return this;
	}
}
