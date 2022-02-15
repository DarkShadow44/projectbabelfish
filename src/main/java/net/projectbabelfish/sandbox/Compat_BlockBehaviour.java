package net.projectbabelfish.sandbox;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.projectbabelfish.ap.CompatClass;
import net.projectbabelfish.ap.CompatGetter;
import net.projectbabelfish.ap.MethodGeneration;

@CompatClass(target = BlockBehaviour.class, names = {})
public abstract class Compat_BlockBehaviour {

	private CompatI_BlockBehavior wrapper;

	public Block getReal() {
		return wrapper.get();
	}

	@CompatGetter(names = {}, generation = MethodGeneration.ONLY_CHILD)
	public void get_properties() {

	}
}
