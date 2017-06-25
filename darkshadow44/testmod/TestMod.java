package darkshadow44.testmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestMod {
	public Item testItem1;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		testItem1 = new TestItem1().setUnlocalizedName("testItem1").setCreativeTab(CreativeTabs.tabMisc).setTextureName("compattest:testItem1");
		GameRegistry.registerItem(testItem1, "testItem1");
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}
}
