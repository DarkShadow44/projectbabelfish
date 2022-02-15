package net.projectbabelfish.sandbox;

import generated.net.projectbabelfish.sandbox.CompatI_Block;
import net.minecraft.world.level.block.Block;
import net.projectbabelfish.ap.CompatClass;
import net.projectbabelfish.ap.CompatMethod;
import net.projectbabelfish.ap.MethodGeneration;

@CompatClass(target = Block.class, names = {})
public class Compat_Block extends Compat_BlockBehaviour {

	private CompatI_Block wrapper;

	public Block getReal() {
		return wrapper.get();
	}

	// Set real method like with .class and stuff?
	@CompatMethod(names = { "func_149711_c" }, generation = MethodGeneration.NONE)
	public Compat_Block setHardness(float hardness) {
		//if (wrapper.isChild())
		{
			wrapper.get_properties().destroyTime(hardness);
		}
		return this;
	}
}
