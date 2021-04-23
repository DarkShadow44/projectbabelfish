package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.properties.Compat_PropertyInteger;
import net.minecraft.block.BlockRedstoneWire;

public class Compat_BlockRedstoneWire extends Compat_Block {
	private CompatI_BlockRedstoneWire wrapper;

	private static final Compat_PropertyInteger POWER = new Compat_PropertyInteger(BlockRedstoneWire.POWER);

	// When called from Mod
	public Compat_BlockRedstoneWire() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockRedstoneWire.class, this));
	}

	// When called from child
	protected Compat_BlockRedstoneWire(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockRedstoneWire(BlockRedstoneWire original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockRedstoneWire.class, original));
	}

	protected void initialize(CompatI_BlockRedstoneWire wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockRedstoneWire getReal() {
		return wrapper.get();
	}

	public Compat_PropertyInteger Compat_get_field_176351_O() {
		return POWER;
	}

	public static Compat_BlockRedstoneWire getFake(BlockRedstoneWire block) {
		return getFakeInternal(block, () -> new Compat_BlockRedstoneWire(block));
	}
}
