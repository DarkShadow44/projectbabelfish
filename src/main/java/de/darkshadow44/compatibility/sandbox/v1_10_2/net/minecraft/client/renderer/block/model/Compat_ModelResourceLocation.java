package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Compat_ModelResourceLocation extends Compat_ResourceLocation {
	private CompatI_ModelResourceLocation wrapper;

	// When called from Mod
	public Compat_ModelResourceLocation(String p1, String p2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelResourceLocation.class, this, p1, p2));
	}

	// When called from Mod
	public Compat_ModelResourceLocation(Compat_ResourceLocation p1, String p2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ModelResourceLocation.class, this, p1.getReal(), p2));
	}

	// When called from child
	protected Compat_ModelResourceLocation(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelResourceLocation(ModelResourceLocation original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelResourceLocation.class, original));
	}

	protected void initialize(CompatI_ModelResourceLocation wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ModelResourceLocation getReal() {
		return wrapper.get();
	}

	public String Compat_func_177518_c() {
		return wrapper.getVariantSuper();
	}
}
