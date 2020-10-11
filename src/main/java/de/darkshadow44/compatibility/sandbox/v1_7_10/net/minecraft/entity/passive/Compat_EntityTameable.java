package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityTameable;

public class Compat_EntityTameable extends Compat_EntityAnimal {
	private EntityTameable original;
	private CompatI_EntityTameable thisReal;

	// When called from Mod
	public Compat_EntityTameable(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_EntityTameable(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityTameable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityTameable(EntityTameable original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityTameable thisReal, EntityTameable original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityTameable getReal() {
		return original == null ? thisReal.get() : original;
	}
}
