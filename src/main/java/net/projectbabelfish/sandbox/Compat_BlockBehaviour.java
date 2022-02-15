package net.projectbabelfish.sandbox;

import generated.net.projectbabelfish.sandbox.CompatI_BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.projectbabelfish.ap.CompatClass;
import net.projectbabelfish.ap.CompatGetter;
import net.projectbabelfish.ap.MethodGeneration;

@CompatClass(target = BlockBehaviour.class, names = {})
public abstract class Compat_BlockBehaviour {

	private CompatI_BlockBehaviour wrapper;

	public BlockBehaviour getReal() {
		return wrapper.get();
	}

	@CompatGetter(names = {}, generation = MethodGeneration.ONLY_CHILD)
	public void get_properties() {

	}
}
