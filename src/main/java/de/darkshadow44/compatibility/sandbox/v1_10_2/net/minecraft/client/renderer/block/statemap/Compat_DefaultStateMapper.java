package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;

public class Compat_DefaultStateMapper extends Compat_StateMapperBase {
	private DefaultStateMapper original;
	private CompatI_DefaultStateMapper thisReal;

	// When called from Mod
	public Compat_DefaultStateMapper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_DefaultStateMapper.class, this), null);
	}

	// When called from child
	protected Compat_DefaultStateMapper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_DefaultStateMapper(DefaultStateMapper original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_DefaultStateMapper thisReal, DefaultStateMapper original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public DefaultStateMapper getReal() {
		return original == null ? thisReal.get() : original;
	}
}
