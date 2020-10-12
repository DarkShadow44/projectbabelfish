package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.potion;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Compat_PotionEffect {
	private PotionEffect original;
	private CompatI_PotionEffect thisReal;

	// When called from Mod
	public Compat_PotionEffect(int id, int duration, int amplifier) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PotionEffect.class, this, Potion.getPotionById(id), duration, amplifier), null);
	}

	// When called from Mod
	public Compat_PotionEffect(int id, int duration) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_PotionEffect.class, this, Potion.getPotionById(id), duration), null);
	}

	// When called from child
	protected Compat_PotionEffect(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PotionEffect(PotionEffect original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PotionEffect thisReal, PotionEffect original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public PotionEffect getReal() {
		return original == null ? thisReal.get() : original;
	}
}
