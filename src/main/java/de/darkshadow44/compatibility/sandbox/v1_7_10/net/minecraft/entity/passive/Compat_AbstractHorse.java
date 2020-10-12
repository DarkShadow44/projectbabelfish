package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.AbstractHorse;

public class Compat_AbstractHorse extends Compat_EntityAnimal {
	private AbstractHorse original;
	private CompatI_AbstractHorse thisReal;

	// When called from Mod
	public Compat_AbstractHorse(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, world.getReal()), null);
	}

	// When called from child
	protected Compat_AbstractHorse(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractHorse(AbstractHorse original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AbstractHorse thisReal, AbstractHorse original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public AbstractHorse getReal() {
		return original == null ? thisReal.get() : original;
	}
}
