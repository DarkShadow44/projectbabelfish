package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockDoublePlant.EnumBlockHalf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.EnumPlantType;

public class Compat_BlockDoublePlant extends Compat_BlockBush {
	private CompatI_BlockDoublePlant wrapper;

	// When called from Mod
	public Compat_BlockDoublePlant() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockDoublePlant.class, this));
	}

	// When called from child
	protected Compat_BlockDoublePlant(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockDoublePlant(BlockDoublePlant original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockDoublePlant.class, original));
	}

	protected void initialize(CompatI_BlockDoublePlant wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockDoublePlant getReal() {
		return wrapper.get();
	}

	public static Compat_BlockDoublePlant getFake(BlockDoublePlant block) {
		return getFakeInternal(block, () -> new Compat_BlockDoublePlant(block));
	}

	public static boolean Compat_func_149887_c(int p1) // true if plant is upper part, aka "state.getValue(HALF) ==
												// BlockDoublePlant.EnumBlockHalf.UPPER"
	{
		return (p1 & 8) != 0;
	}

	public static int Compat_func_149890_d(int p1) // get variant part from meta
	{
		return p1 & 7;
	}

	public Compat_IIcon Compat_func_149888_a(boolean isUpper, int variant) {
		IBlockState state = Blocks.DOUBLE_PLANT.getDefaultState();
		state = state.withProperty(BlockDoublePlant.HALF, isUpper ? EnumBlockHalf.UPPER : EnumBlockHalf.LOWER);
		state = state.withProperty(BlockDoublePlant.VARIANT, Compat_BlockDoublePlant_EnumPlantType.getFromInt(variant));
		return getIconForState(state, 0, variant);
	}

	public Compat_IIcon[] Compat_get_field_149891_b() {
		IBlockState state = Blocks.DOUBLE_PLANT.getDefaultState();
		state = state.withProperty(BlockDoublePlant.VARIANT, EnumPlantType.SUNFLOWER);
		IBlockState stateUpper = state.withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER);
		IBlockState stateLower = state.withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER);

		Compat_IIcon iconUpper = getIconForState(stateUpper, 0, EnumPlantType.SUNFLOWER.ordinal());
		Compat_IIcon iconLower = getIconForState(stateLower, 0, EnumPlantType.SUNFLOWER.ordinal());

		return new Compat_IIcon[] { iconUpper, iconLower }; // TODO ?
	}
}
