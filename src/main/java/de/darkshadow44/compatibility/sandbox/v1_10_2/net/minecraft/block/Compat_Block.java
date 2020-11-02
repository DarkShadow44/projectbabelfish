package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.autogen.HasCallback;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_BlockStateContainer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab.Compat_CreativeTabs;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_Entity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_BlockRenderLayer;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumBlockRenderType;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_RayTraceResult;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_Vec3d;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_IBlockAccess;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Wrapper_IBlockAccess;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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

	@HasCallback
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

	@HasCallback
	public int Compat_func_176201_c(Compat_IBlockState state) {
		if (original == null)
			return thisReal.getMetaFromStateSuper(state.getReal());
		else
			return original.getMetaFromState(state.getReal());
	}

	public boolean Compat_func_176200_f(Compat_IBlockAccess world, Compat_BlockPos pos) {
		if (original == null)
			return thisReal.isReplaceableSuper(world.getReal(), pos.getReal());
		else
			return original.isReplaceable(world.getReal(), pos.getReal());
	}

	// From ITileEnttiyProvider
	public TileEntity createNewTileEntity(World world, int meta) {
		if (!(this instanceof Compat_ITileEntityProvider)) {
			return null;
		}
		return Compat_func_149915_a(new Compat_World(world), meta).getReal();
	}

	@HasCallback
	public Compat_TileEntity Compat_func_149915_a(Compat_World world, int meta) {
		// To be overriden
		throw new RuntimeException();
	}

	@Callback
	public boolean isFullBlock(IBlockState state) {
		return Compat_func_149730_j(new Wrapper_IBlockState(state));
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public boolean Compat_func_149730_j(Compat_IBlockState state) {
		if (original == null)
			return thisReal.isFullBlockSuper(state.getReal());
		else
			return original.isFullBlock(state.getReal());
	}

	@Callback
	public boolean isFullCube(IBlockState state) {
		return Compat_func_149686_d(new Wrapper_IBlockState(state));
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public boolean Compat_func_149686_d(Compat_IBlockState state) {
		if (original == null)
			return thisReal.isFullCubeSuper(state.getReal());
		else
			return original.isFullCube(state.getReal());
	}

	@Callback(skipDuringConstructor = true)
	public boolean isOpaqueCube(IBlockState state) {
		return Compat_func_149662_c(new Wrapper_IBlockState(state));
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public boolean Compat_func_149662_c(Compat_IBlockState state) {
		if (original == null)
			return thisReal.isOpaqueCubeSuper(state.getReal());
		else
			return original.isOpaqueCube(state.getReal());
	}

	@Callback
	public boolean isBlockNormalCube(IBlockState state) {
		return Compat_func_149637_q(new Wrapper_IBlockState(state));
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public boolean Compat_func_149637_q(Compat_IBlockState state) {
		if (original == null)
			return thisReal.isBlockNormalCubeSuper(state.getReal());
		else
			return original.isBlockNormalCube(state.getReal());
	}

	@Callback
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return Compat_func_149645_b(new Wrapper_IBlockState(state)).getReal();
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public Compat_EnumBlockRenderType Compat_func_149645_b(Compat_IBlockState state) {
		if (original == null)
			return Compat_EnumBlockRenderType.get_fake(thisReal.getRenderTypeSuper(state.getReal()));
		else
			return Compat_EnumBlockRenderType.get_fake(original.getRenderType(state.getReal()));
	}

	public static Compat_RegistryNamespacedDefaultedByKey Compat_get_field_149771_c() {
		return new Compat_RegistryNamespacedDefaultedByKey_Block(Block.REGISTRY);
	}

	@Callback
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		Compat_IBlockState ret = Compat_getExtendedState(Compat_IBlockState.getFake(state), new Wrapper_IBlockAccess(world), new Compat_BlockPos(pos));
		return ret.getReal();
	}

	@HasCallback
	public Compat_IBlockState Compat_getExtendedState(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos) {
		IBlockState ret;

		if (original == null)
			ret = thisReal.getExtendedStateSuper(state.getReal(), world.getReal(), pos.getReal());
		else
			ret = original.getExtendedState(state.getReal(), world.getReal(), pos.getReal());

		return new Wrapper_IBlockState(ret);
	}

	@Callback
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
		Compat_RayTraceResult result = Compat_func_180636_a(new Wrapper_IBlockState(state), Compat_World.get_fake(world), new Compat_BlockPos(pos), new Compat_Vec3d(start), new Compat_Vec3d(end));
		return result == null ? null : result.getReal();
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public Compat_RayTraceResult Compat_func_180636_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_Vec3d start, Compat_Vec3d end) {
		RayTraceResult result;
		if (original == null)
			result = thisReal.collisionRayTraceSuper(state.getReal(), world.getReal(), pos.getReal(), start.getReal(), end.getReal());
		else
			result = original.collisionRayTrace(state.getReal(), world.getReal(), pos.getReal(), start.getReal(), end.getReal());
		return result == null ? null : new Compat_RayTraceResult(result);
	}

	@Callback
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
		return Compat_func_180640_a(new Wrapper_IBlockState(state), Compat_World.get_fake(world), new Compat_BlockPos(pos)).getReal();
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public Compat_AxisAlignedBB Compat_func_180640_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos) {
		AxisAlignedBB result;
		if (original == null)
			result = thisReal.getSelectedBoundingBoxSuper(state.getReal(), world.getReal(), pos.getReal());
		else
			result = original.getSelectedBoundingBox(state.getReal(), world.getReal(), pos.getReal());
		return new Compat_AxisAlignedBB(result);
	}

	@Callback
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> boxes, Entity entity, boolean isActualState) {
		List<Compat_AxisAlignedBB> list2 = new ArrayList<>();

		for (AxisAlignedBB box : boxes) {
			list2.add(new Compat_AxisAlignedBB(box));
		}

		Compat_func_185477_a(new Wrapper_IBlockState(state), Compat_World.get_fake(world), new Compat_BlockPos(pos), new Compat_AxisAlignedBB(entityBox), list2, new Compat_Entity(entity));

		boxes.clear();
		for (Compat_AxisAlignedBB box : list2) {
			boxes.add(box.getReal());
		}
	}

	@SuppressWarnings("deprecation")
	@HasCallback
	public void Compat_func_185477_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_AxisAlignedBB entityBox, List<Compat_AxisAlignedBB> boxes, Compat_Entity entity) {
		List<AxisAlignedBB> list2 = new ArrayList<>();

		for (Compat_AxisAlignedBB box : boxes) {
			list2.add(box.getReal());
		}

		if (original == null)
			thisReal.addCollisionBoxToListSuper(state.getReal(), world.getReal(), pos.getReal(), entityBox.getReal(), list2, entity.getReal(), true);
		else
			original.addCollisionBoxToList(state.getReal(), world.getReal(), pos.getReal(), entityBox.getReal(), list2, entity.getReal(), true);

		boxes.clear();
		for (AxisAlignedBB box : list2) {
			boxes.add(new Compat_AxisAlignedBB(box));
		}
	}

	@Callback
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		return Compat_canRenderInLayer(new Wrapper_IBlockState(state), Compat_BlockRenderLayer.getFake(layer));
	}

	@HasCallback
	public boolean Compat_canRenderInLayer(Compat_BlockRenderLayer layer) {
		if (original == null)
			return thisReal.canRenderInLayerSuper(null, layer.getReal());
		else
			return original.canRenderInLayer(null, layer.getReal());
	}

	@HasCallback
	public boolean Compat_canRenderInLayer(Compat_IBlockState state, Compat_BlockRenderLayer layer) {
		return Compat_canRenderInLayer(layer);
	}

}
