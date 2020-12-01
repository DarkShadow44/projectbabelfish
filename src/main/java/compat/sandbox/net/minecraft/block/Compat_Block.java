package compat.sandbox.net.minecraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.core.Version;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import compat.sandbox.net.minecraft.block.state.Compat_BlockStateContainer;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.client.particle.Compat_ParticleManager;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_IIconRegister;
import compat.sandbox.net.minecraft.client.renderer.texture.Wrapper_IIcon;
import compat.sandbox.net.minecraft.creativetab.Compat_CreativeTabs;
import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.entity.Compat_EntityLivingBase;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayer;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.Compat_BlockRenderLayer;
import compat.sandbox.net.minecraft.util.Compat_EnumBlockRenderType;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.Compat_EnumHand;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.util.math.Compat_RayTraceResult;
import compat.sandbox.net.minecraft.util.math.Compat_Vec3d;
import compat.sandbox.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey;
import compat.sandbox.net.minecraft.util.registry.Compat_RegistryNamespacedDefaultedByKey_Block;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import compat.sandbox.net.minecraft.world.Compat_World;
import compat.sandbox.net.minecraft.world.Compat_WorldServer;
import compat.sandbox.net.minecraft.world.Wrapper_IBlockAccess;
import compat.sandbox.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.world.WorldServer;

public class Compat_Block extends Compat_IForgeRegistryEntry_Impl<Block> {
	private CompatI_Block wrapper;

	private Version version = Version.UNKNOWN;

	private Compat_IIcon blockIcon;

	private String unlocalizedName;

	private String textureName;

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
		version = Version.get(this);
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

	@HasCallback({ Version.V1_10_2 })
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
		this.unlocalizedName = name;
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

	@HasCallback({ Version.V1_10_2 })
	public int Compat_func_176201_c(Compat_IBlockState state) {
		return wrapper.getMetaFromStateSuper(state.getReal());
	}

	public boolean Compat_func_176200_f(Compat_IBlockAccess world, Compat_BlockPos pos) {
		return wrapper.isReplaceableSuper(world.getReal(), pos.getReal());
	}

	// From ITileEntityProvider
	public TileEntity createNewTileEntity(World world, int meta) {
		return Compat_func_149915_a(new Compat_World(world), meta).getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_TileEntity Compat_func_149915_a(Compat_World world, int meta) {
		// To be overriden
		return null;
	}

	@Callback
	public boolean isFullBlock(IBlockState state) {
		return Compat_func_149730_j(new Wrapper_IBlockState(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_149730_j(Compat_IBlockState state) {
		return wrapper.isFullBlockSuper(state.getReal());
	}

	@Callback
	public boolean isFullCube(IBlockState state) {
		switch (version) {
		case V1_10_2:
			return Compat_func_149686_d(new Wrapper_IBlockState(state));
		case V1_7_10:
			return Compat_func_149686_d();
		default:
			throw version.makeException();
		}
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_149686_d(Compat_IBlockState state) {
		return wrapper.isFullCubeSuper(state.getReal());
	}

	@HasCallback({ Version.V1_7_10 })
	public boolean Compat_func_149686_d() {
		return wrapper.isFullCubeSuper(wrapper.getDefaultStateSuper());
	}

	@Callback(skipDuringConstructor = true)
	public boolean isOpaqueCube(IBlockState state) {
		switch (version) {
		case V1_10_2:
			return Compat_func_149662_c(new Wrapper_IBlockState(state));
		case V1_7_10:
			return Compat_func_149662_c();
		default:
			throw version.makeException();
		}
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_149662_c(Compat_IBlockState state) {
		return wrapper.isOpaqueCubeSuper(state.getReal());
	}

	@HasCallback({ Version.V1_7_10 })
	public boolean Compat_func_149662_c() {
		return wrapper.isOpaqueCubeSuper(wrapper.getDefaultStateSuper());
	}

	@Callback
	public boolean isBlockNormalCube(IBlockState state) {
		return Compat_func_149637_q(new Wrapper_IBlockState(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_149637_q(Compat_IBlockState state) {
		return wrapper.isBlockNormalCubeSuper(state.getReal());
	}

	@Callback
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return Compat_func_149645_b(new Wrapper_IBlockState(state)).getReal();
	}

	@HasCallback({ Version.V1_10_2 })
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

	@HasCallback({ Version.V1_10_2 })
	public Compat_IBlockState Compat_getExtendedState(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos) {
		IBlockState result = wrapper.getExtendedStateSuper(state.getReal(), world.getReal(), pos.getReal());

		return new Wrapper_IBlockState(result);
	}

	@Callback
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
		Compat_RayTraceResult result = Compat_func_180636_a(new Wrapper_IBlockState(state), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), new Compat_Vec3d(start), new Compat_Vec3d(end));
		return result == null ? null : result.getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_RayTraceResult Compat_func_180636_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_Vec3d start, Compat_Vec3d end) {
		RayTraceResult result = wrapper.collisionRayTraceSuper(state.getReal(), world.getReal(), pos.getReal(), start.getReal(), end.getReal());
		return result == null ? null : new Compat_RayTraceResult(result);
	}

	@Callback
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
		return Compat_func_180640_a(new Wrapper_IBlockState(state), Compat_World.getFake(world), Compat_BlockPos.getFake(pos)).getReal();
	}

	@HasCallback({ Version.V1_10_2 })
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

		Compat_Entity entity2 = entity == null ? null : new Compat_Entity(entity);

		Compat_func_185477_a(new Wrapper_IBlockState(state), Compat_World.getFake(world), new Compat_BlockPos(pos), new Compat_AxisAlignedBB(entityBox), list2, entity2);

		boxes.clear();
		for (Compat_AxisAlignedBB box : list2) {
			boxes.add(box.getReal());
		}
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_185477_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_AxisAlignedBB entityBox, List<Compat_AxisAlignedBB> boxes, Compat_Entity entity) {
		List<AxisAlignedBB> list2 = new ArrayList<>();

		for (Compat_AxisAlignedBB box : boxes) {
			list2.add(box.getReal());
		}

		wrapper.addCollisionBoxToListSuper(state.getReal(), world.getReal(), pos.getReal(), entityBox.getReal(), list2, Compat_Entity.getReal(entity), true);

		boxes.clear();
		for (AxisAlignedBB box : list2) {
			boxes.add(new Compat_AxisAlignedBB(box));
		}
	}

	@Callback
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		return Compat_canRenderInLayer(new Wrapper_IBlockState(state), Compat_BlockRenderLayer.getFake(layer));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_canRenderInLayer(Compat_BlockRenderLayer layer) {
		return wrapper.canRenderInLayerSuper(null, layer.getReal());
	}

	@HasCallback({ Version.V1_10_2 })
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
		this.textureName = name;
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
		Compat_func_180649_a(Compat_World.getFake(world), new Compat_BlockPos(pos), Compat_EntityPlayer.getFake(player));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_180649_a(Compat_World world, Compat_BlockPos pos, Compat_EntityPlayer player) {
		wrapper.onBlockClickedSuper(world.getReal(), pos.getReal(), player.getReal());
	}

	@Callback
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z) {
		ItemStack stack = player.getHeldItem(hand);
		Compat_ItemStack stack2 = stack == null ? null : new Compat_ItemStack(stack);
		return Compat_func_180639_a(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), Compat_EntityPlayer.getFake(player), Compat_EnumHand.getFake(hand), stack2, Compat_EnumFacing.getFake(facing), x, y, z);
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_180639_a(Compat_World world, Compat_BlockPos pos, Compat_IBlockState state, Compat_EntityPlayer player, Compat_EnumHand hand, Compat_ItemStack stack, Compat_EnumFacing facing, float x, float y, float z) {
		return wrapper.onBlockActivatedSuper(world.getReal(), pos.getReal(), state.getReal(), player.getReal(), hand.getReal(), facing.getReal(), x, y, z);
	}

	public static Compat_Block getFake(Block block) {
		if (block instanceof CompatI_Block) {
			return ((CompatI_Block) block).getFake();
		}
		return new Compat_Block(block);
	}

	@Callback
	public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager) {
		return Compat_addDestroyEffects(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), new Compat_ParticleManager(manager));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_addDestroyEffects(Compat_World world, Compat_BlockPos pos, Compat_ParticleManager manager) {
		return wrapper.addDestroyEffectsSuper(world.getReal(), pos.getReal(), manager.getReal());
	}

	@Callback
	public boolean addHitEffects(IBlockState state, World world, RayTraceResult target, ParticleManager manager) {
		return Compat_addHitEffects(Compat_IBlockState.getFake(state), Compat_World.getFake(world), new Compat_RayTraceResult(target), new Compat_ParticleManager(manager));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_addHitEffects(Compat_IBlockState state, Compat_World world, Compat_RayTraceResult ray, Compat_ParticleManager manager) {
		return wrapper.addHitEffectsSuper(state.getReal(), world.getReal(), ray.getReal(), manager.getReal());
	}

	@Callback
	public boolean addLandingEffects(IBlockState state, WorldServer world, BlockPos pos, IBlockState state2, EntityLivingBase entity, int p1) {
		return Compat_addLandingEffects(Compat_IBlockState.getFake(state), new Compat_WorldServer(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state2), new Compat_EntityLivingBase(entity), p1);
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_addLandingEffects(Compat_IBlockState state, Compat_WorldServer world, Compat_BlockPos pos, Compat_IBlockState state2, Compat_EntityLivingBase entity, int p1) {
		return wrapper.addLandingEffectsSuper(state.getReal(), world.getReal(), pos.getReal(), state2.getReal(), entity.getReal(), p1);
	}

	@Callback
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return Compat_canConnectRedstone(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_canConnectRedstone(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.canConnectRedstoneSuper(state.getReal(), world.getReal(), pos.getReal(), Compat_EnumFacing.getReal(facing));
	}

	@Callback
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return Compat_canPlaceTorchOnTop(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_canPlaceTorchOnTop(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos) {
		return wrapper.canPlaceTorchOnTopSuper(state.getReal(), world.getReal(), pos.getReal());
	}

	@Callback
	public boolean canProvidePower(IBlockState state) {
		return Compat_func_149744_f(new Wrapper_IBlockState(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_func_149744_f(Compat_IBlockState state) {
		return wrapper.canProvidePowerSuper(state.getReal());
	}

	@Callback
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		Compat_func_176199_a(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), new Compat_Entity(entity));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_176199_a(Compat_World world, Compat_BlockPos pos, Compat_Entity entity) {
		wrapper.onEntityWalkSuper(world.getReal(), pos.getReal(), entity.getReal());
	}

	@Callback
	public IBlockState getStateFromMeta(int meta) {
		Compat_IBlockState result = Compat_func_176203_a(meta);
		return result.getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_IBlockState Compat_func_176203_a(int meta) {
		return new Wrapper_IBlockState(wrapper.getStateFromMetaSuper(meta));
	}

	@Callback
	public int getStrongPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return Compat_func_176211_b(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(side));
	}

	@HasCallback({ Version.V1_10_2 })
	public int Compat_func_176211_b(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.getStrongPowerSuper(state.getReal(), world.getReal(), pos.getReal(), Compat_EnumFacing.getReal(facing));
	}

	@Callback
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		Compat_func_180634_a(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), new Compat_Entity(entity));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_180634_a(Compat_World world, Compat_BlockPos pos, Compat_IBlockState state, Compat_Entity entity) {
		wrapper.onEntityCollidedWithBlockSuper(world.getReal(), pos.getReal(), state.getReal(), entity.getReal());
	}

	@Callback
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World world, BlockPos pos) {
		return Compat_func_180647_a(Compat_IBlockState.getFake(state), Compat_EntityPlayer.getFake(player), Compat_World.getFake(world), Compat_BlockPos.getFake(pos));
	}

	@HasCallback({ Version.V1_10_2 })
	public float Compat_func_180647_a(Compat_IBlockState state, Compat_EntityPlayer player, Compat_World world, Compat_BlockPos pos) {
		return wrapper.getPlayerRelativeBlockHardnessSuper(state.getReal(), player.getReal(), world.getReal(), pos.getReal());
	}

	@Callback
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		Compat_func_180655_c(Compat_IBlockState.getFake(state), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), random);
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_180655_c(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Random random) {
		wrapper.randomDisplayTickSuper(state.getReal(), world.getReal(), pos.getReal(), random);
	}

	@Callback
	public int getWeakPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return Compat_func_180656_a(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback({ Version.V1_10_2 })
	public int Compat_func_180656_a(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.getWeakPowerSuper(state.getReal(), world.getReal(), pos.getReal(), Compat_EnumFacing.getReal(facing));
	}

	@Callback
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile, ItemStack stack) {
		Compat_func_180657_a(Compat_World.getFake(world), Compat_EntityPlayer.getFake(player), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), Compat_TileEntity.getFake(tile), Compat_ItemStack.getFake(stack));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_180657_a(Compat_World world, Compat_EntityPlayer player, Compat_BlockPos pos, Compat_IBlockState state, Compat_TileEntity tile, Compat_ItemStack stack) {
		wrapper.harvestBlockSuper(world.getReal(), player.getReal(), pos.getReal(), state.getReal(), tile.getReal(), stack.getReal());
	}

	@Callback
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		Compat_func_189540_a(Compat_IBlockState.getFake(state), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_Block.getFake(block));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_189540_a(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_Block block) {
		wrapper.neighborChangedSuper(state.getReal(), world.getReal(), pos.getReal(), block.getReal(), pos.getReal());
	}

	@Callback
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<Compat_ItemStack> result = Compat_getDrops(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), fortune);
		List<ItemStack> ret = new ArrayList<>();

		for (Compat_ItemStack stack : result) {
			ret.add(stack.getReal());
		}

		return ret;
	}

	@HasCallback({ Version.V1_10_2 })
	public List<Compat_ItemStack> Compat_getDrops(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_IBlockState state, int fortune) {
		List<ItemStack> result = wrapper.getDropsSuper(world.getReal(), pos.getReal(), state.getReal(), fortune);
		List<Compat_ItemStack> ret = new ArrayList<>();

		for (ItemStack stack : result) {
			ret.add(Compat_ItemStack.getFake(stack));
		}

		return ret;
	}

	@Callback
	public int getHarvestLevel(IBlockState state) {
		return Compat_getHarvestLevel(Compat_IBlockState.getFake(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public int Compat_getHarvestLevel(Compat_IBlockState state) {
		return wrapper.getHarvestLevelSuper(state.getReal());
	}

	@Callback
	public String getHarvestTool(IBlockState state) {
		return Compat_getHarvestTool(Compat_IBlockState.getFake(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public String Compat_getHarvestTool(Compat_IBlockState state) {
		return wrapper.getHarvestToolSuper(state.getReal());
	}

	@Callback
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		return Compat_getLightValue(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos));
	}

	@HasCallback({ Version.V1_10_2 })
	public int Compat_getLightValue(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos) {
		return wrapper.getLightValueSuper(state.getReal(), world.getReal(), pos.getReal());
	}

	@Callback
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		Compat_ItemStack result = Compat_getPickBlock(Compat_IBlockState.getFake(state), Compat_RayTraceResult.getFake(target), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_EntityPlayer.getFake(player));
		return result == null ? null : result.getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_ItemStack Compat_getPickBlock(Compat_IBlockState state, Compat_RayTraceResult target, Compat_World world, Compat_BlockPos pos, Compat_EntityPlayer player) {
		ItemStack result = wrapper.getPickBlockSuper(state.getReal(), target.getReal(), world.getReal(), pos.getReal(), player.getReal());
		return Compat_ItemStack.getFake(result);
	}

	@Callback
	public boolean getWeakChanges(IBlockAccess world, BlockPos pos) {
		return Compat_getWeakChanges(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_getWeakChanges(Compat_IBlockAccess world, Compat_BlockPos pos) {
		return wrapper.getWeakChangesSuper(world.getReal(), pos.getReal());
	}

	@Callback
	public Boolean isAABBInsideMaterial(World world, BlockPos pos, AxisAlignedBB bb, Material material) {
		return Compat_isAABBInsideMaterial(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_AxisAlignedBB.getFake(bb), Compat_Material.getFake(material));
	}

	@HasCallback({ Version.V1_10_2 })
	public Boolean Compat_isAABBInsideMaterial(Compat_World world, Compat_BlockPos pos, Compat_AxisAlignedBB bb, Compat_Material material) {
		return wrapper.isAABBInsideMaterialSuper(world.getReal(), pos.getReal(), bb.getReal(), material.getReal());
	}

	@Callback
	public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos pos, IBlockState state, Entity entity, double d, Material material, boolean testingHead) {
		return Compat_isEntityInsideMaterial(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), Compat_Entity.getFake(entity), d, Compat_Material.getFake(material), testingHead);
	}

	@HasCallback({ Version.V1_10_2 })
	public Boolean Compat_isEntityInsideMaterial(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_IBlockState state, Compat_Entity entity, double d, Compat_Material material, boolean testingHead) {
		return wrapper.isEntityInsideMaterialSuper(world.getReal(), pos.getReal(), state.getReal(), entity.getReal(), d, material.getReal(), testingHead);
	}

	@Callback
	public boolean isSideSolid(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return Compat_isSideSolid(Compat_IBlockState.getFake(state), Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(facing));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_isSideSolid(Compat_IBlockState state, Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing) {
		return wrapper.isSideSolidSuper(state.getReal(), world.getReal(), pos.getReal(), Compat_EnumFacing.getReal(facing));
	}

	@Callback
	public boolean isToolEffective(String type, IBlockState state) {
		return Compat_isToolEffective(type, Compat_IBlockState.getFake(state));
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_isToolEffective(String type, Compat_IBlockState state) {
		return wrapper.isToolEffectiveSuper(type, state.getReal());
	}

	@Callback
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		Compat_onNeighborChange(Compat_IBlockAccess.getFake(world), Compat_BlockPos.getFake(pos), Compat_BlockPos.getFake(neighbor));
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_onNeighborChange(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_BlockPos posNeighbor) {
		wrapper.onNeighborChangeSuper(world.getReal(), pos.getReal(), posNeighbor.getReal());
	}

	@Callback
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
		return Compat_removedByPlayer(Compat_IBlockState.getFake(state), Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_EntityPlayer.getFake(player), willHarvest);
	}

	@HasCallback({ Version.V1_10_2 })
	public boolean Compat_removedByPlayer(Compat_IBlockState state, Compat_World world, Compat_BlockPos pos, Compat_EntityPlayer player, boolean willHarvest) {
		return wrapper.removedByPlayerSuper(state.getReal(), world.getReal(), pos.getReal(), player.getReal(), willHarvest);
	}

	@Callback
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float x, float y, float z, int meta, EntityLivingBase entity) {
		Compat_IBlockState result = Compat_func_180642_a(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_EnumFacing.getFake(facing), x, y, z, meta, Compat_EntityLivingBase.getFake(entity));
		return result.getReal();
	}

	@HasCallback({ Version.V1_10_2 })
	public Compat_IBlockState Compat_func_180642_a(Compat_World world, Compat_BlockPos pos, Compat_EnumFacing facing, float x, float y, float z, int meta, Compat_EntityLivingBase entity) {
		IBlockState result = wrapper.getStateForPlacementSuper(world.getReal(), pos.getReal(), Compat_EnumFacing.getReal(facing), x, y, z, meta, entity.getReal());
		return new Wrapper_IBlockState(result);
	}

	@Callback
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		Compat_func_180650_b(Compat_World.getFake(world), Compat_BlockPos.getFake(pos), Compat_IBlockState.getFake(state), random);
	}

	@HasCallback({ Version.V1_10_2 })
	public void Compat_func_180650_b(Compat_World world, Compat_BlockPos pos, Compat_IBlockState state, Random random) {
		wrapper.updateTickSuper(world.getReal(), pos.getReal(), state.getReal(), random);
	}

	public void Compat_func_149683_g() {
		// TODO setBlockBoundsForItemRender
	}

	public Compat_IIcon Compat_func_149691_a(int side, int meta) {
		if (wrapper instanceof CompatI_Block) {
			return blockIcon;
		}

		Block block = wrapper.get();
		IBlockState state = block.getDefaultState();

		IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getModelForState(state);

		List<BakedQuad> quads = model.getQuads(state, Compat_EnumFacing.getFromSide(side).getReal(), meta);

		if (quads.size() != 1) {
			throw new RuntimeException("Unexpected");
		}

		return new Wrapper_IIcon(quads.get(0).getSprite());
	}

	public int Compat_func_149645_b() {
		return 0;
	}

	public void Compat_func_149651_a(Compat_IIconRegister iconRegister) {
		this.blockIcon = iconRegister.Compat_func_94245_a(Compat_func_149641_N());
	}

	public void Compat_set_field_149761_L(Compat_IIcon icon) {
		this.blockIcon = icon;
	}

	public String Compat_func_149641_N() {
		return (this.textureName == null) ? ("MISSING_ICON_BLOCK_" + this.unlocalizedName) : this.textureName;
	}

	public int Compat_getLightValue(Compat_IBlockAccess world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		return wrapper.getLightValueSuper(world.getReal().getBlockState(pos), world.getReal(), pos);
	}

	public boolean Compat_func_149751_l() {
		return wrapper.getDefaultStateSuper().getMaterial().blocksLight();
	}

	public float Compat_func_149685_I() {
		return wrapper.getDefaultStateSuper().getAmbientOcclusionLightValue();
	}

	public int Compat_func_149677_c(Compat_IBlockAccess world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		return world.getReal().getBlockState(pos).getPackedLightmapCoords(world.getReal(), pos);
	}


}
