package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_BlockStateContainer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab.Compat_CreativeTabs;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class Compat_Block extends Compat_IForgeRegistryEntry_Impl<Block> {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this, material.getReal()), null);

		workaround_init();
	}

	protected void workaround_init() {
		// Workaround, since we need skipDuringConstructor
		Block block = (Block) thisReal;
		block.blockState = this.createBlockState();
		thisReal.setDefaultStateSuper(block.blockState.getBaseState());
		boolean fullBlock = block.getDefaultState().isOpaqueCube();
		thisReal.set_fullBlock(fullBlock);
		block.setLightOpacity(fullBlock ? 255 : 0);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}

	public static Compat_AxisAlignedBB Compat_get_field_185505_j() {
		return new Compat_AxisAlignedBB(Block.FULL_BLOCK_AABB);
	}

	public Compat_IBlockState Compat_func_176223_P() {
		IBlockState state;
		if (original == null)
			state = thisReal.getDefaultStateSuper();
		else
			state = original.getDefaultState();

		return new Wrapper_IBlockState(state);
	}

	@Callback(skipDuringConstructor = true)
	public BlockStateContainer createBlockState() {
		return Compat_func_180661_e().getReal();
	}

	public Compat_BlockStateContainer Compat_func_180661_e() {
		if (original == null)
			return new Compat_BlockStateContainer(thisReal.createBlockStateSuper());
		else
			throw new RuntimeException("Should not happen");
	}

	public void Compat_func_180632_j(Compat_IBlockState state) {
		if (original == null)
			thisReal.setDefaultStateSuper(state.getReal());
		else
			throw new RuntimeException("Should not happen");
	}

	public Compat_Block Compat_func_149711_c(float hardness) {
		if (original == null)
			thisReal.setHardnessSuper(hardness);
		else
			original.setHardness(hardness);
		return this;
	}

	public Compat_Block Compat_func_149663_c(String name) {
		if (original == null)
			thisReal.setUnlocalizedNameSuper(name);
		else
			original.setUnlocalizedName(name);
		return this;
	}

	public Compat_Block Compat_func_149647_a(Compat_CreativeTabs tabs) {
		if (original == null)
			thisReal.setCreativeTabSuper(tabs.getReal());
		else
			original.setCreativeTab(tabs.getReal());
		return this;
	}

	@Callback
	public int getMetaFromState(IBlockState state) {
		return Compat_func_176201_c(new Wrapper_IBlockState(state));
	}

	public int Compat_func_176201_c(Compat_IBlockState state) {
		if (original == null)
			return thisReal.getMetaFromStateSuper(state.getReal());
		else
			return original.getMetaFromState(state.getReal());
	}
}
