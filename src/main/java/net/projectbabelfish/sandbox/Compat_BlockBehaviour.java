package net.projectbabelfish.sandbox;

import generated.net.projectbabelfish.sandbox.CompatI_BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.projectbabelfish.ap.Callback;
import net.projectbabelfish.ap.CompatClass;
import net.projectbabelfish.ap.CompatGetter;
import net.projectbabelfish.ap.MethodGeneration;

@CompatClass(target = BlockBehaviour.class, names = {})
public abstract class Compat_BlockBehaviour extends Compat_Object {

	private CompatI_BlockBehaviour wrapper;

	public Compat_BlockBehaviour(CompatI_BlockBehaviour wrapper) {
		super(wrapper);
		this.wrapper = wrapper;
	}

	@Callback
	public Item asItem() {
		throw new RuntimeException();
	}

	@Callback
	public Block asBlock() {
		throw new RuntimeException();
	}

	@CompatGetter(names = {}, generation = MethodGeneration.NONE)
	public void get_properties() {

	}
}
