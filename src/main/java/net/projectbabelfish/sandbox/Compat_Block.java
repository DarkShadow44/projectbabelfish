package net.projectbabelfish.sandbox;

import generated.net.projectbabelfish.sandbox.CompatI_Block;
import net.minecraft.world.level.block.Block;
import net.projectbabelfish.ap.CompatClass;
import net.projectbabelfish.ap.CompatMethod;

@CompatClass(target = Block.class, names = {})
public class Compat_Block {

	private CompatI_Block wrapper;

	public Block getReal() {
		return wrapper.get();
	}

	@CompatMethod(names = { "func_149711_c" })
	public Compat_Block setHardness(float hardness) {
		wrapper.setHardnessSuper(hardness);
		return this;
	}
}
