package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

import java.util.List;
import java.util.Map;

import darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.client.Minecraft;

public class ModLoader {

	// public static void addAchievementDesc(Achievement achievement, String
	// name, String description) {
	// }

	public static String tmpLocale;

	public static int addAllFuel(int id, int metadata) {
		return metadata;
	}

	public static void addAllRenderers(Map<Class<? extends Entity>, Render> renderers) {
	}

	public static void addAnimation(TextureFX anim) {

	}

	public static int addArmor(String armor) {
		return 0;

	}

	public static void addBiome(BiomeGenBase biome) {

	}

	public static void addLocalization(String key, String value) {
		tmpLocale += key + "=" + value + "\n";
	}

	public static void addLocalization(String key, String lang, String value) {

	}

	public static void addName(Object instance, String name) {
		if (instance instanceof Item) {
			Item item = (Item) instance;
			tmpLocale += "item." + item.unlocalisedName + ".name=" + name + "\n";
		}
	}

	public static void addName(Object instance, String lang, String name) {

	}

	public static int addOverride(String fileToOverride, String fileToAdd) {
		return 0;

	}

	public static void addOverride(String path, String overlayPath, int index) {

	}

	public static void addRecipe(ItemStack output, Object... params) {

	}

	public static void addShapelessRecipe(ItemStack output, Object... params) {

	}

	public static void addSmelting(int input, ItemStack output) {

	}

	public static void addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType spawnList) {
	}

	public static void addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType spawnList, BiomeGenBase... biomes) {
	}

	public static void addSpawn(String entityName, int weightedProb, int min, int max, EnumCreatureType spawnList) {
	}

	public static void addSpawn(String entityName, int weightedProb, int min, int max, EnumCreatureType spawnList, BiomeGenBase... biomes) {
	}

	public static boolean dispenseEntity(World world, double x, double y, double z, int xVel, int zVel, ItemStack item) {
		return false;
	}

	public static void genericContainerRemoval(World world, int x, int y, int z) {

	}

	public static List<BaseMod> getLoadedMods() {
		return null;
	}

	// public static Logger getLogger() {
	// }

	public static Minecraft getMinecraftInstance() {
		return Minecraft.instance;
	}

	public static Object getMinecraftServerInstance() {
		return null;
	}

	public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, int fieldindex) {
		return null;
	}

	public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, String field) {
		return null;
	}

	public static int getUniqueBlockModelID(BaseMod mod, boolean inventoryRenderer) {
		return 0;
	}

	public static int getUniqueEntityId() {
		return 0;
	}

	public static int getUniqueSpriteIndex(String path) {
		return 0;
	}

	public static boolean isChannelActive(EntityPlayer player, String channel) {
		return false;
	}

	public static boolean isGUIOpen(Class<? extends GuiScreen> gui) {
		return false;
	}

	public static boolean isModLoaded(String modname) {
		return false;
	}

	public static void loadConfig() {
	}

	// public static BufferedImage loadImage(RenderEngine renderEngine, String
	// path) throws Exception {
	// }

	public static void onItemPickup(EntityPlayer player, ItemStack item) {
	}

	public static void onTick(float tick, Minecraft game) {
	}

	public static void openGUI(EntityPlayer player, GuiScreen gui) {
	}

	public static void populateChunk(IChunkProvider generator, int chunkX, int chunkZ, World world) {
	}

	// public static void receivePacket(Packet250CustomPayload packet) {
	// }

	public static KeyBinding[] registerAllKeys(KeyBinding[] keys) {
		return keys;
	}

	public static void registerAllTextureOverrides(RenderEngine cache) {
	}

	public static void registerBlock(Block block) {
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass) {
	}

	public static void registerEntityID(Class<? extends Entity> entityClass, String entityName, int id) {
	}

	public static void registerEntityID(Class<? extends Entity> entityClass, String entityName, int id, int background, int foreground) {
	}

	public static void registerKey(BaseMod mod, KeyBinding keyHandler, boolean allowRepeat) {
	}

	public static void registerPacketChannel(BaseMod mod, String channel) {
	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {

	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id, TileEntitySpecialRenderer renderer) {

	}

	public static void removeBiome(BiomeGenBase biome) {

	}

	public static void removeSpawn(Class<? extends EntityLiving> entityClass, EnumCreatureType spawnList) {
	}

	public static void removeSpawn(Class<? extends EntityLiving> entityClass, EnumCreatureType spawnList, BiomeGenBase... biomes) {
	}

	public static void removeSpawn(String entityName, EnumCreatureType spawnList) {
	}

	public static void removeSpawn(String entityName, EnumCreatureType spawnList, BiomeGenBase... biomes) {
	}

	public static boolean renderBlockIsItemFull3D(int modelID) {
		return false;
	}

	public static void renderInvBlock(RenderBlocks renderer, Block block, int metadata, int modelID) {
	}

	public static boolean renderWorldBlock(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, Block block, int modelID) {
		return false;
	}

	public static void saveConfig() {
	}

	// public static void sendPacket(Packet packet) {
	// }

	public static void serverChat(String text) {

	}

	// public static void serverLogin(NetClientHandler handler, Packet1Login
	// loginPacket) {
	// }

	public static void setInGameHook(BaseMod mod, boolean enable, boolean useClock) {

	}

	public static void setInGUIHook(BaseMod mod, boolean enable, boolean useClock) {

	}

	public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, int fieldindex, E value) {

	}

	public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, String field, E value) {

	}

	public static void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory matrix) {
	}

	public static void takenFromFurnace(EntityPlayer player, ItemStack item) {
	}

	public static void throwException(String message, Throwable e) {

	}

	public static void throwException(Throwable e) {

	}
}
