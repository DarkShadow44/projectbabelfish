package compat.sandbox.net.minecraftforge.event.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class Compat_BonemealEvent extends Compat_PlayerEvent {
	private CompatI_BonemealEvent wrapper;

	// When called from Mod
	public Compat_BonemealEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BonemealEvent.class, this));
	}

	// When called from child
	protected Compat_BonemealEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BonemealEvent(BonemealEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BonemealEvent.class, original));
	}

	protected void initialize(CompatI_BonemealEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BonemealEvent getReal() {
		return wrapper.get();
	}

	public Compat_Block Compat_get_block() {
		IBlockState result = wrapper.getBlockSuper();
		return Compat_Block.getFake(result.getBlock());
	}

	public Compat_World Compat_get_world() {
		World result = wrapper.getWorldSuper();
		return Compat_World.getFake(result);
	}

	public int Compat_get_x() {
		BlockPos result = wrapper.getPosSuper();
		return result.getX();
	}

	public int Compat_get_y() {
		BlockPos result = wrapper.getPosSuper();
		return result.getY();
	}

	public int Compat_get_z() {
		BlockPos result = wrapper.getPosSuper();
		return result.getZ();
	}
}
