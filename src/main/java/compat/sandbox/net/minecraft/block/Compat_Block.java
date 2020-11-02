package compat.sandbox.net.minecraft.block;

import java.util.ArrayList;
import java.util.List;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import compat.sandbox.net.minecraft.block.state.Compat_BlockStateContainer;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.creativetab.Compat_CreativeTabs;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.Compat_BlockRenderLayer;
import compat.sandbox.net.minecraft.util.Compat_EnumBlockRenderType;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.util.math.Compat_RayTraceResult;
import compat.sandbox.net.minecraft.util.math.Compat_Vec3d;
import compat.sandbox.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey;
import compat.sandbox.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey_Block;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraft.world.Wrapper_IBlockAccess;
import compat.sandbox.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Compat_Block extends Compat_IForgeRegistryEntry_Impl<Block> {
	private CompatI_Block wrapper;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Block.class, this, material.getReal()));

		workaround_init();
	}

	protected void workaround_init() {
		// Workaround, since we need skipDuringConstructor
		Block block = (Block) wrapper;
		block.blockState = this.createBlockState();
		wrapper.setDefaultStateSuper(block.blockState.getBaseState());
		boolean fullBlock = block.getDefaultState().isOpaqueCube();
		wrapper.set_fullBlock(fullBlock);
		block.setLightOpacity(fullBlock ? 255 : 0);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_Block.class, original));
	}

	protected void initialize(CompatI_Block wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public Block getReal() {
		return wrapper.get();
	}

	public static Compat_AxisAlignedBB Compat_get_field_185505_j() {
		return new Compat_AxisAlignedBB(Block.FULL_BLOCK_AABB);
	}

	public Compat_IBlockState Compat_func_176223_P() {
		IBlockState result = wrapper.getDefaultStateSuper();

		return new Wrapper_IBlockState(result);
	}

	@Callback(skipDuringConstructor = true)
	public BlockStateContainer createBlockState() {
		return Compat_func_180661_e().getReal();
	}

	@HasCallback
	public Compat_BlockStateContainer Compat_func_180661_e() {
		return new Compat_BlockStateContainer(wrapper.createBlockStateSuper());
	}

	public void Compat_func_180632_j(Compat_IBlockState state) {
		wrapper.setDefaultStateSuper(state.getReal());
	}

	public Compat_Block Compat_func_149711_c(float hardness) {
		wrapper.setHardnessSuper(hardness);
		return this;
	}

	public Compat_Block Compat_func_149663_c(String name) {
		wrapper.setUnlocalizedNameSuper(name);
		// TODO 1.7.10: wrapper.setRegistryNameSuper(name);
		return this;
	}

	public Compat_Block Compat_func_149647_a(Compat_CreativeTabs creativeTabs) {
		CreativeTabs real = creativeTabs == null ? null : creativeTabs.getReal();
		wrapper.setCreativeTabSuper(real);
		return this;
	}

	@Callback
	public int getMetaFromState(IBlockState state) {
		return Compat_func_176201_c(new Wrapper_IBlockState(state));
	}

	@HasCallback
	public int Compat_func_176201_c(Compat_IBlockState state) {
		return wrapper.getMetaFromStateSuper(state.getReal());
	}

	public boolean Compat_func_176200_f(Compat_IBlockAccess world, Compat_BlockPos pos) {
		return wrapper.isReplaceableSuper(world.getReal(), pos.getReal());
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

	@HasCallback
	public boolean Compat_func_149730_j(Compat_IBlockState state) {
		return wrapper.isFullBlockSuper(state.getReal());
	}

	@Callback
	public boolean isFullCube(IBlockState state) {
		return Compat_func_149686_d(new Wrapper_IBlockState(state));
	}

	@HasCallback
	public boolean Compat_func_149686_d(Compat_IBlockState state) {
		return wrapper.isFullCubeSuper(state.getReal());
	}

	@Callback(skipDuringConstructor = true)
	public boolean isOpaqueCube(IBlockState state) {
		return Compat_func_149662_c(new Wrapper_IBlockState(state));
	}

	@HasCallback
	public boolean Compat_func_149662_c(Compat_IBlockState state) {
		return wrapper.isOpaqueCubeSuper(state.getReal());
	}

	@Callback
	public boolean isBlockNormalCube(IBlockState state) {
		return Compat_func_149637_q(new Wrapper_IBlockState(state));
	}

	@HasCallback
	public boolean Compat_func_149637_q(Compat_IBlockState state) {
		return wrapper.isBlockNormalCubeSuper(state.getReal());
	}

	@Callback
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return Compat_func_149645_b(new Wrapper_IBlockState(state)).getReal();
	}

	@HasCallback
	public Compat_EnumBlockRenderType Compat_func_149645_b(Compat_IBlockState state) {
		return Compat_EnumBlockRenderType.get_fake(wrapper.getRenderTypeSuper(state.getReal()));
	}

	public static Compat_RegistryNamespacedDefaultedByKey Compat_get_field_149771_c() {
		return new Compat_RegistryNamespacedDefaultedByKey_Block(Block.REGISTRY);
	}

	@Callback
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		Compat_IBlockState result = Compat_getExtendedState(Compat_IBlockState.getFake(state), new Wrapper_IBlockAccess(world), new Compat_BlockPos(pos));
		return result.getReal();
	}

	@HasCallback
	public Compat_IBlockState Compat_getExtendedState(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos) {
		IBlockState result = wrapper.getExtendedStateSuper(state.getReal(), world.getReal(), pos.getReal());

		return new Wrapper_IBlockState(result);
	}

	@Callback
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
		Compat_RayTraceResult result = Compat_func_180636_a(new Wrapper_IBlockState(state), Compat_World.get_fake(world), new Compat_BlockPos(pos), new Compat_Vec3d(start), new Compat_Vec3d(end));
		return result == null ? null : result.getReal();
	}

	@HasCallback
	public Compat_RayTraceResult Compat_func_180636_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_Vec3d start, Compat_Vec3d end) {
		RayTraceResult result = wrapper.collisionRayTraceSuper(state.getReal(), world.getReal(), pos.getReal(), start.getReal(), end.getReal());
		return result == null ? null : new Compat_RayTraceResult(result);
	}

	@Callback
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
		return Compat_func_180640_a(new Wrapper_IBlockState(state), Compat_World.get_fake(world), new Compat_BlockPos(pos)).getReal();
	}

	@HasCallback
	public Compat_AxisAlignedBB Compat_func_180640_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos) {
		AxisAlignedBB result = wrapper.getSelectedBoundingBoxSuper(state.getReal(), world.getReal(), pos.getReal());
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

	@HasCallback
	public void Compat_func_185477_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_AxisAlignedBB entityBox, List<Compat_AxisAlignedBB> boxes, Compat_Entity entity) {
		List<AxisAlignedBB> list2 = new ArrayList<>();

		for (Compat_AxisAlignedBB box : boxes) {
			list2.add(box.getReal());
		}

		wrapper.addCollisionBoxToListSuper(state.getReal(), world.getReal(), pos.getReal(), entityBox.getReal(), list2, entity.getReal(), true);

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
		return wrapper.canRenderInLayerSuper(null, layer.getReal());
	}

	@HasCallback
	public boolean Compat_canRenderInLayer(Compat_IBlockState state, Compat_BlockRenderLayer layer) {
		return Compat_canRenderInLayer(layer);
	}

	public Compat_Block Compat_func_149675_a(boolean shouldTick) {
		wrapper.setTickRandomlySuper(shouldTick);
		return this;
	}

	public void Compat_func_149676_a(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		// TODO: setBlockBounds
	}

	public static Compat_Block_SoundType Compat_get_field_149779_h() {
		return new Compat_Block_SoundType(SoundType.PLANT);
	}

	public Compat_Block Compat_func_149672_a(Compat_Block_SoundType sound) {
		wrapper.setSoundTypeSuper(sound.getReal());
		return this;
	}

	public Compat_Block Compat_func_149649_H() {
		wrapper.disableStatsSuper();
		return this;
	}

	public Compat_Block Compat_func_149658_d(String name) {
		// TODO
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149766_f() {
		return new Compat_Block_SoundType(SoundType.WOOD);
	}

	public Compat_Block Compat_func_149713_g(int opacity) {
		wrapper.setLightOpacitySuper(opacity);
		return this;
	}

	public Compat_Block Compat_func_149722_s() {
		wrapper.setBlockUnbreakableSuper();
		return this;
	}

	public Compat_Block Compat_func_149752_b(float resistance) {
		wrapper.setResistanceSuper(resistance);
		return this;
	}

	public Compat_Block Compat_func_149715_a(float value) {
		wrapper.setLightLevelSuper(value);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149775_l() {
		return new Compat_Block_SoundType(SoundType.CLOTH);
	}

	public static Compat_Block_SoundType Compat_get_field_149767_g() {
		return new Compat_Block_SoundType(SoundType.GROUND);
	}

	public static Compat_Block_SoundType Compat_get_field_149777_j() {
		return new Compat_Block_SoundType(SoundType.METAL);
	}

	public static Compat_Block_SoundType Compat_get_field_149769_e() {
		return new Compat_Block_SoundType(SoundType.STONE);
	}

	public static Compat_Block_SoundType Compat_get_field_149773_n() {
		return new Compat_Block_SoundType(SoundType.SNOW);
	}

	public static Compat_Block_SoundType Compat_get_field_149780_i() {
		return new Compat_Block_SoundType(SoundType.WOOD); // TODO
	}

	public static Compat_Block_SoundType Compat_get_field_149778_k() {
		return new Compat_Block_SoundType(SoundType.GLASS);
	}

	public void Compat_set_field_149765_K(float value) {
		wrapper.setDefaultSlipperinessSuper(value);
	}

	public void Compat_set_field_149787_q(boolean opaque) {
		// TODO opaque
	}

	@Callback
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
		Compat_func_180649_a(Compat_World.get_fake(world), new Compat_BlockPos(pos), Compat_EntityPlayer.get_fake(player));
	}

	@HasCallback
	public void Compat_func_180649_a(Compat_World world, Compat_BlockPos pos, Compat_EntityPlayer player) {
		wrapper.onBlockClickedSuper(world.getReal(), pos.getReal(), player.getReal());
	}

	@Callback
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z) {
		ItemStack stack = player.getHeldItem(hand);
		Compat_ItemStack stack2 = stack == null ? null : new Compat_ItemStack(stack);
		return Compat_func_180639_a(Compat_World.get_fake(world), new Compat_BlockPos(pos), new Wrapper_IBlockState(state), Compat_EntityPlayer.get_fake(player), Compat_EnumHand.map_real_to_fake(hand), stack2, Compat_EnumFacing.map_real_to_fake(facing), x, y, z);
	}

	@HasCallback
	public boolean Compat_func_180639_a(Compat_World world, Compat_BlockPos pos, Compat_IBlockState state, Compat_EntityPlayer player, Compat_EnumHand hand, Compat_ItemStack stack, Compat_EnumFacing facing, float x, float y, float z) {
		return wrapper.onBlockActivatedSuper(world.getReal(), pos.getReal(), state.getReal(), player.getReal(), hand.getReal(), facing.getReal(), x, y, z);
	}

}
