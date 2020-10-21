package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Compat_ModelResourceLocation extends Compat_ResourceLocation {
	private ModelResourceLocation original;
	private CompatI_ModelResourceLocation thisReal;

	// When called from Mod
	public Compat_ModelResourceLocation() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelResourceLocation.class, this), null);
	}

	// When called from child
	protected Compat_ModelResourceLocation(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelResourceLocation(ModelResourceLocation original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelResourceLocation thisReal, ModelResourceLocation original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelResourceLocation getReal() {
		return original == null ? thisReal.get() : original;
	}
}
