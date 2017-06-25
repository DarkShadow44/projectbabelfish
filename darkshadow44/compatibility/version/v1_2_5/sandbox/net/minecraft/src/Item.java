package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

import darkshadow44.compatibility.version.v1_2_5.sandbox.Core;
import darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src.ItemShim;

public class Item {

	private ItemShim itemShim;
	public String unlocalisedName;

	public int bR;
	public float a;
	public boolean canRepair;
	public int shiftedIndex;
	static boolean dummy = false;

	public static Item[] itemsList = new Item[32000];

	public static Item shovelSteel;
	public static Item pickaxeSteel;
	public static Item axeSteel;
	public static Item flintAndSteel;
	public static Item appleRed;
	public static Item bow;
	public static Item arrow;
	public static Item coal;
	public static Item diamond;
	public static Item ingotIron;
	public static Item ingotGold;
	public static Item swordSteel;
	public static Item swordWood;
	public static Item shovelWood;
	public static Item pickaxeWood;
	public static Item axeWood;
	public static Item swordStone;
	public static Item shovelStone;
	public static Item pickaxeStone;
	public static Item axeStone;
	public static Item swordDiamond;
	public static Item shovelDiamond;
	public static Item pickaxeDiamond;
	public static Item axeDiamond;
	public static Item stick;
	public static Item bowlEmpty;
	public static Item bowlSoup;
	public static Item swordGold;
	public static Item shovelGold;
	public static Item pickaxeGold;
	public static Item axeGold;
	public static Item silk;
	public static Item feather;
	public static Item gunpowder;
	public static Item hoeWood;
	public static Item hoeStone;
	public static Item hoeSteel;
	public static Item hoeDiamond;
	public static Item hoeGold;
	public static Item seeds;
	public static Item wheat;
	public static Item bread;
	public static Item helmetLeather;
	public static Item plateLeather;
	public static Item legsLeather;
	public static Item bootsLeather;
	public static Item helmetChain;
	public static Item plateChain;
	public static Item legsChain;
	public static Item bootsChain;
	public static Item helmetSteel;
	public static Item plateSteel;
	public static Item legsSteel;
	public static Item bootsSteel;
	public static Item helmetDiamond;
	public static Item plateDiamond;
	public static Item legsDiamond;
	public static Item bootsDiamond;
	public static Item helmetGold;
	public static Item plateGold;
	public static Item legsGold;
	public static Item bootsGold;
	public static Item flint;
	public static Item porkRaw;
	public static Item porkCooked;
	public static Item painting;
	public static Item appleGold;
	public static Item sign;
	public static Item doorWood;
	public static Item bucketEmpty;
	public static Item bucketWater;
	public static Item bucketLava;
	public static Item minecartEmpty;
	public static Item saddle;
	public static Item doorSteel;
	public static Item redstone;
	public static Item snowball;
	public static Item boat;
	public static Item leather;
	public static Item bucketMilk;
	public static Item brick;
	public static Item clay;
	public static Item reed;
	public static Item paper;
	public static Item book;
	public static Item slimeBall;
	public static Item minecartCrate;
	public static Item minecartPowered;
	public static Item egg;
	public static Item compass;
	public static Item fishingRod;
	public static Item pocketSundial;
	public static Item lightStoneDust;
	public static Item fishRaw;
	public static Item fishCooked;
	public static Item dyePowder;
	public static Item bone;
	public static Item sugar;
	public static Item cake;
	public static Item bed;
	public static Item redstoneRepeater;
	public static Item cookie;
	public static ItemMap map;
	public static ItemShears shears;
	public static Item melon;
	public static Item pumpkinSeeds;
	public static Item melonSeeds;
	public static Item beefRaw;
	public static Item beefCooked;
	public static Item chickenRaw;
	public static Item chickenCooked;
	public static Item rottenFlesh;
	public static Item enderPearl;
	public static Item blazeRod;
	public static Item ghastTear;
	public static Item goldNugget;
	public static Item netherStalkSeeds;
	public static ItemPotion potion;
	public static Item glassBottle;
	public static Item spiderEye;
	public static Item fermentedSpiderEye;
	public static Item blazePowder;
	public static Item magmaCream;
	public static Item brewingStand;
	public static Item cauldron;
	public static Item eyeOfEnder;
	public static Item speckledMelon;
	public static Item monsterPlacer;
	public static Item expBottle;
	public static Item fireballCharge;
	public static Item record13;
	public static Item recordCat;
	public static Item recordBlocks;
	public static Item recordChirp;
	public static Item recordFar;
	public static Item recordMall;
	public static Item recordMellohi;
	public static Item recordStal;
	public static Item recordStrad;
	public static Item recordWard;
	public static Item record11;

	static {
		InitItems();
	}

	public static void InitItems() {
		dummy = true;
		shovelSteel = (new ItemSpade(0, EnumToolMaterial.IRON)).setIconCoord(2, 5).setItemName("shovelIron");
		pickaxeSteel = (new ItemPickaxe(1, EnumToolMaterial.IRON)).setIconCoord(2, 6).setItemName("pickaxeIron");
		axeSteel = (new ItemAxe(2, EnumToolMaterial.IRON)).setIconCoord(2, 7).setItemName("hatchetIron");
		flintAndSteel = (new ItemFlintAndSteel(3)).setIconCoord(5, 0).setItemName("flintAndSteel");
		appleRed = (new ItemFood(4, 4, 0.3F, false)).setIconCoord(10, 0).setItemName("apple");
		bow = (new ItemBow(5)).setIconCoord(5, 1).setItemName("bow");
		arrow = (new Item(6)).setIconCoord(5, 2).setItemName("arrow");
		coal = (new ItemCoal(7)).setIconCoord(7, 0).setItemName("coal");
		diamond = (new Item(8)).setIconCoord(7, 3).setItemName("emerald");
		ingotIron = (new Item(9)).setIconCoord(7, 1).setItemName("ingotIron");
		ingotGold = (new Item(10)).setIconCoord(7, 2).setItemName("ingotGold");
		swordSteel = (new ItemSword(11, EnumToolMaterial.IRON)).setIconCoord(2, 4).setItemName("swordIron");
		swordWood = (new ItemSword(12, EnumToolMaterial.WOOD)).setIconCoord(0, 4).setItemName("swordWood");
		shovelWood = (new ItemSpade(13, EnumToolMaterial.WOOD)).setIconCoord(0, 5).setItemName("shovelWood");
		pickaxeWood = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).setIconCoord(0, 6).setItemName("pickaxeWood");
		axeWood = (new ItemAxe(15, EnumToolMaterial.WOOD)).setIconCoord(0, 7).setItemName("hatchetWood");
		swordStone = (new ItemSword(16, EnumToolMaterial.STONE)).setIconCoord(1, 4).setItemName("swordStone");
		shovelStone = (new ItemSpade(17, EnumToolMaterial.STONE)).setIconCoord(1, 5).setItemName("shovelStone");
		pickaxeStone = (new ItemPickaxe(18, EnumToolMaterial.STONE)).setIconCoord(1, 6).setItemName("pickaxeStone");
		axeStone = (new ItemAxe(19, EnumToolMaterial.STONE)).setIconCoord(1, 7).setItemName("hatchetStone");
		swordDiamond = (new ItemSword(20, EnumToolMaterial.EMERALD)).setIconCoord(3, 4).setItemName("swordDiamond");
		shovelDiamond = (new ItemSpade(21, EnumToolMaterial.EMERALD)).setIconCoord(3, 5).setItemName("shovelDiamond");
		pickaxeDiamond = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).setIconCoord(3, 6).setItemName("pickaxeDiamond");
		axeDiamond = (new ItemAxe(23, EnumToolMaterial.EMERALD)).setIconCoord(3, 7).setItemName("hatchetDiamond");
		stick = (new Item(24)).setIconCoord(5, 3).setFull3D().setItemName("stick");
		bowlEmpty = (new Item(25)).setIconCoord(7, 4).setItemName("bowl");
		bowlSoup = (new ItemSoup(26, 8)).setIconCoord(8, 4).setItemName("mushroomStew");
		swordGold = (new ItemSword(27, EnumToolMaterial.GOLD)).setIconCoord(4, 4).setItemName("swordGold");
		shovelGold = (new ItemSpade(28, EnumToolMaterial.GOLD)).setIconCoord(4, 5).setItemName("shovelGold");
		pickaxeGold = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).setIconCoord(4, 6).setItemName("pickaxeGold");
		axeGold = (new ItemAxe(30, EnumToolMaterial.GOLD)).setIconCoord(4, 7).setItemName("hatchetGold");
		silk = (new Item(31)).setIconCoord(8, 0).setItemName("string");
		feather = (new Item(32)).setIconCoord(8, 1).setItemName("feather");
		gunpowder = (new Item(33)).setIconCoord(8, 2).setItemName("sulphur").setPotionEffect(PotionHelper.gunpowderEffect);
		hoeWood = (new ItemHoe(34, EnumToolMaterial.WOOD)).setIconCoord(0, 8).setItemName("hoeWood");
		hoeStone = (new ItemHoe(35, EnumToolMaterial.STONE)).setIconCoord(1, 8).setItemName("hoeStone");
		hoeSteel = (new ItemHoe(36, EnumToolMaterial.IRON)).setIconCoord(2, 8).setItemName("hoeIron");
		hoeDiamond = (new ItemHoe(37, EnumToolMaterial.EMERALD)).setIconCoord(3, 8).setItemName("hoeDiamond");
		hoeGold = (new ItemHoe(38, EnumToolMaterial.GOLD)).setIconCoord(4, 8).setItemName("hoeGold");
		seeds = (new ItemSeeds(39, Block.crops.blockID, Block.tilledField.blockID)).setIconCoord(9, 0).setItemName("seeds");
		wheat = (new Item(40)).setIconCoord(9, 1).setItemName("wheat");
		bread = (new ItemFood(41, 5, 0.6F, false)).setIconCoord(9, 2).setItemName("bread");
		helmetLeather = (new ItemArmor(42, EnumArmorMaterial.CLOTH, 0, 0)).setIconCoord(0, 0).setItemName("helmetCloth");
		plateLeather = (new ItemArmor(43, EnumArmorMaterial.CLOTH, 0, 1)).setIconCoord(0, 1).setItemName("chestplateCloth");
		legsLeather = (new ItemArmor(44, EnumArmorMaterial.CLOTH, 0, 2)).setIconCoord(0, 2).setItemName("leggingsCloth");
		bootsLeather = (new ItemArmor(45, EnumArmorMaterial.CLOTH, 0, 3)).setIconCoord(0, 3).setItemName("bootsCloth");
		helmetChain = (new ItemArmor(46, EnumArmorMaterial.CHAIN, 1, 0)).setIconCoord(1, 0).setItemName("helmetChain");
		plateChain = (new ItemArmor(47, EnumArmorMaterial.CHAIN, 1, 1)).setIconCoord(1, 1).setItemName("chestplateChain");
		legsChain = (new ItemArmor(48, EnumArmorMaterial.CHAIN, 1, 2)).setIconCoord(1, 2).setItemName("leggingsChain");
		bootsChain = (new ItemArmor(49, EnumArmorMaterial.CHAIN, 1, 3)).setIconCoord(1, 3).setItemName("bootsChain");
		helmetSteel = (new ItemArmor(50, EnumArmorMaterial.IRON, 2, 0)).setIconCoord(2, 0).setItemName("helmetIron");
		plateSteel = (new ItemArmor(51, EnumArmorMaterial.IRON, 2, 1)).setIconCoord(2, 1).setItemName("chestplateIron");
		legsSteel = (new ItemArmor(52, EnumArmorMaterial.IRON, 2, 2)).setIconCoord(2, 2).setItemName("leggingsIron");
		bootsSteel = (new ItemArmor(53, EnumArmorMaterial.IRON, 2, 3)).setIconCoord(2, 3).setItemName("bootsIron");
		helmetDiamond = (new ItemArmor(54, EnumArmorMaterial.DIAMOND, 3, 0)).setIconCoord(3, 0).setItemName("helmetDiamond");
		plateDiamond = (new ItemArmor(55, EnumArmorMaterial.DIAMOND, 3, 1)).setIconCoord(3, 1).setItemName("chestplateDiamond");
		legsDiamond = (new ItemArmor(56, EnumArmorMaterial.DIAMOND, 3, 2)).setIconCoord(3, 2).setItemName("leggingsDiamond");
		bootsDiamond = (new ItemArmor(57, EnumArmorMaterial.DIAMOND, 3, 3)).setIconCoord(3, 3).setItemName("bootsDiamond");
		helmetGold = (new ItemArmor(58, EnumArmorMaterial.GOLD, 4, 0)).setIconCoord(4, 0).setItemName("helmetGold");
		plateGold = (new ItemArmor(59, EnumArmorMaterial.GOLD, 4, 1)).setIconCoord(4, 1).setItemName("chestplateGold");
		legsGold = (new ItemArmor(60, EnumArmorMaterial.GOLD, 4, 2)).setIconCoord(4, 2).setItemName("leggingsGold");
		bootsGold = (new ItemArmor(61, EnumArmorMaterial.GOLD, 4, 3)).setIconCoord(4, 3).setItemName("bootsGold");
		flint = (new Item(62)).setIconCoord(6, 0).setItemName("flint");
		porkRaw = (new ItemFood(63, 3, 0.3F, true)).setIconCoord(7, 5).setItemName("porkchopRaw");
		porkCooked = (new ItemFood(64, 8, 0.8F, true)).setIconCoord(8, 5).setItemName("porkchopCooked");
		painting = (new ItemPainting(65)).setIconCoord(10, 1).setItemName("painting");
		appleGold = (new ItemAppleGold(66, 4, 1.2F, false)).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setIconCoord(11, 0).setItemName("appleGold");
		sign = (new ItemSign(67)).setIconCoord(10, 2).setItemName("sign");
		doorWood = (new ItemDoor(68, Material.wood)).setIconCoord(11, 2).setItemName("doorWood");
		bucketEmpty = (new ItemBucket(69, 0)).setIconCoord(10, 4).setItemName("bucket");
		bucketWater = (new ItemBucket(70, Block.waterMoving.blockID)).setIconCoord(11, 4).setItemName("bucketWater").setContainerItem(bucketEmpty);
		bucketLava = (new ItemBucket(71, Block.lavaMoving.blockID)).setIconCoord(12, 4).setItemName("bucketLava").setContainerItem(bucketEmpty);
		minecartEmpty = (new ItemMinecart(72, 0)).setIconCoord(7, 8).setItemName("minecart");
		saddle = (new ItemSaddle(73)).setIconCoord(8, 6).setItemName("saddle");
		doorSteel = (new ItemDoor(74, Material.iron)).setIconCoord(12, 2).setItemName("doorIron");
		redstone = (new ItemRedstone(75)).setIconCoord(8, 3).setItemName("redstone").setPotionEffect(PotionHelper.redstoneEffect);
		snowball = (new ItemSnowball(76)).setIconCoord(14, 0).setItemName("snowball");
		boat = (new ItemBoat(77)).setIconCoord(8, 8).setItemName("boat");
		leather = (new Item(78)).setIconCoord(7, 6).setItemName("leather");
		bucketMilk = (new ItemBucketMilk(79)).setIconCoord(13, 4).setItemName("milk").setContainerItem(bucketEmpty);
		brick = (new Item(80)).setIconCoord(6, 1).setItemName("brick");
		clay = (new Item(81)).setIconCoord(9, 3).setItemName("clay");
		reed = (new ItemReed(82, Block.reed)).setIconCoord(11, 1).setItemName("reeds");
		paper = (new Item(83)).setIconCoord(10, 3).setItemName("paper");
		book = (new Item(84)).setIconCoord(11, 3).setItemName("book");
		slimeBall = (new Item(85)).setIconCoord(14, 1).setItemName("slimeball");
		minecartCrate = (new ItemMinecart(86, 1)).setIconCoord(7, 9).setItemName("minecartChest");
		minecartPowered = (new ItemMinecart(87, 2)).setIconCoord(7, 10).setItemName("minecartFurnace");
		egg = (new ItemEgg(88)).setIconCoord(12, 0).setItemName("egg");
		compass = (new Item(89)).setIconCoord(6, 3).setItemName("compass");
		fishingRod = (new ItemFishingRod(90)).setIconCoord(5, 4).setItemName("fishingRod");
		pocketSundial = (new Item(91)).setIconCoord(6, 4).setItemName("clock");
		lightStoneDust = (new Item(92)).setIconCoord(9, 4).setItemName("yellowDust").setPotionEffect(PotionHelper.glowstoneEffect);
		fishRaw = (new ItemFood(93, 2, 0.3F, false)).setIconCoord(9, 5).setItemName("fishRaw");
		fishCooked = (new ItemFood(94, 5, 0.6F, false)).setIconCoord(10, 5).setItemName("fishCooked");
		dyePowder = (new ItemDye(95)).setIconCoord(14, 4).setItemName("dyePowder");
		bone = (new Item(96)).setIconCoord(12, 1).setItemName("bone").setFull3D();
		sugar = (new Item(97)).setIconCoord(13, 0).setItemName("sugar").setPotionEffect(PotionHelper.sugarEffect);
		cake = (new ItemReed(98, Block.cake)).setMaxStackSize(1).setIconCoord(13, 1).setItemName("cake");
		bed = (new ItemBed(99)).setMaxStackSize(1).setIconCoord(13, 2).setItemName("bed");
		redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle)).setIconCoord(6, 5).setItemName("diode");
		cookie = (new ItemFood(101, 1, 0.1F, false)).setIconCoord(12, 5).setItemName("cookie");
		map = (ItemMap) (new ItemMap(102)).setIconCoord(12, 3).setItemName("map");
		shears = (ItemShears) (new ItemShears(103)).setIconCoord(13, 5).setItemName("shears");
		melon = (new ItemFood(104, 2, 0.3F, false)).setIconCoord(13, 6).setItemName("melon");
		pumpkinSeeds = (new ItemSeeds(105, Block.pumpkinStem.blockID, Block.tilledField.blockID)).setIconCoord(13, 3).setItemName("seeds_pumpkin");
		melonSeeds = (new ItemSeeds(106, Block.melonStem.blockID, Block.tilledField.blockID)).setIconCoord(14, 3).setItemName("seeds_melon");
		beefRaw = (new ItemFood(107, 3, 0.3F, true)).setIconCoord(9, 6).setItemName("beefRaw");
		beefCooked = (new ItemFood(108, 8, 0.8F, true)).setIconCoord(10, 6).setItemName("beefCooked");
		chickenRaw = (new ItemFood(109, 2, 0.3F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setIconCoord(9, 7).setItemName("chickenRaw");
		chickenCooked = (new ItemFood(110, 6, 0.6F, true)).setIconCoord(10, 7).setItemName("chickenCooked");
		rottenFlesh = (new ItemFood(111, 4, 0.1F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(11, 5).setItemName("rottenFlesh");
		enderPearl = (new ItemEnderPearl(112)).setIconCoord(11, 6).setItemName("enderPearl");
		blazeRod = (new Item(113)).setIconCoord(12, 6).setItemName("blazeRod");
		ghastTear = (new Item(114)).setIconCoord(11, 7).setItemName("ghastTear").setPotionEffect(PotionHelper.ghastTearEffect);
		goldNugget = (new Item(115)).setIconCoord(12, 7).setItemName("goldNugget");
		netherStalkSeeds = (new ItemSeeds(116, Block.netherStalk.blockID, Block.slowSand.blockID)).setIconCoord(13, 7).setItemName("netherStalkSeeds").setPotionEffect("+4");
		potion = (ItemPotion) (new ItemPotion(117)).setIconCoord(13, 8).setItemName("potion");
		glassBottle = (new ItemGlassBottle(118)).setIconCoord(12, 8).setItemName("glassBottle");
		spiderEye = (new ItemFood(119, 2, 0.8F, false)).setPotionEffect(Potion.poison.id, 5, 0, 1.0F).setIconCoord(11, 8).setItemName("spiderEye").setPotionEffect(PotionHelper.spiderEyeEffect);
		fermentedSpiderEye = (new Item(120)).setIconCoord(10, 8).setItemName("fermentedSpiderEye").setPotionEffect(PotionHelper.fermentedSpiderEyeEffect);
		blazePowder = (new Item(121)).setIconCoord(13, 9).setItemName("blazePowder").setPotionEffect(PotionHelper.blazePowderEffect);
		magmaCream = (new Item(122)).setIconCoord(13, 10).setItemName("magmaCream").setPotionEffect(PotionHelper.magmaCreamEffect);
		brewingStand = (new ItemReed(123, Block.brewingStand)).setIconCoord(12, 10).setItemName("brewingStand");
		cauldron = (new ItemReed(124, Block.cauldron)).setIconCoord(12, 9).setItemName("cauldron");
		eyeOfEnder = (new ItemEnderEye(125)).setIconCoord(11, 9).setItemName("eyeOfEnder");
		speckledMelon = (new Item(126)).setIconCoord(9, 8).setItemName("speckledMelon").setPotionEffect(PotionHelper.speckledMelonEffect);
		monsterPlacer = (new ItemMonsterPlacer(127)).setIconCoord(9, 9).setItemName("monsterPlacer");
		expBottle = (new ItemExpBottle(128)).setIconCoord(11, 10).setItemName("expBottle");
		fireballCharge = (new ItemFireball(129)).setIconCoord(14, 2).setItemName("fireball");
		record13 = (new ItemRecord(2000, "13")).setIconCoord(0, 15).setItemName("record");
		recordCat = (new ItemRecord(2001, "cat")).setIconCoord(1, 15).setItemName("record");
		recordBlocks = (new ItemRecord(2002, "blocks")).setIconCoord(2, 15).setItemName("record");
		recordChirp = (new ItemRecord(2003, "chirp")).setIconCoord(3, 15).setItemName("record");
		recordFar = (new ItemRecord(2004, "far")).setIconCoord(4, 15).setItemName("record");
		recordMall = (new ItemRecord(2005, "mall")).setIconCoord(5, 15).setItemName("record");
		recordMellohi = (new ItemRecord(2006, "mellohi")).setIconCoord(6, 15).setItemName("record");
		recordStal = (new ItemRecord(2007, "stal")).setIconCoord(7, 15).setItemName("record");
		recordStrad = (new ItemRecord(2008, "strad")).setIconCoord(8, 15).setItemName("record");
		recordWard = (new ItemRecord(2009, "ward")).setIconCoord(9, 15).setItemName("record");
		record11 = (new ItemRecord(2010, "11")).setIconCoord(10, 15).setItemName("record");
		dummy = false;
	}

	public Item(int par0) {
		if (dummy)
			return;
		itemShim = new ItemShim();
		itemShim.setCreativeTab(Core.tabCompat);
	}

	private Item setContainerItem(Item bucketEmpty2) {
		return this;
	}

	private Item setFull3D() {
		return this;
	}

	public Item setIconCoord(int x, int y) {
		if (dummy)
			return this;

		String texturePath = this.getTextureFile();

		Core.textureHelper.LoadImage(texturePath);
		String name = Core.textureHelper.GetTextureSplitName(texturePath, x, y);

		itemShim.setTextureName("compat:" + name);
		return this;
	}

	public String getTextureFile() {
		return "";
	}

	public Item a(boolean par0) {
		return this;
	}

	public Item g(int par0) {
		return this;
	}

	public Item c(int par0, int par1) {
		return setIconCoord(par0, par1);
	}

	public Item setItemName(String name) {
		if (dummy)
			return this;
		unlocalisedName = name;
		itemShim.setItemName(name);
		return this;
	}

	public Item setMaxStackSize(int i) {
		return this;
	}

	public Item a(String par0) {
		return this;
	}

	public Item f(int par0) {
		return this;
	}

	public Item setNoRepair() {
		return this;
	}

	public Item setPotionEffect(int id, int i, int j, float f) {
		return this;
	}

	public Item setPotionEffect(String par0) {
		return this;
	}

	public ItemShim getShim() {
		return itemShim;
	}

}
