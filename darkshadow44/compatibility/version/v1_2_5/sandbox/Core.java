package darkshadow44.compatibility.version.v1_2_5.sandbox;

import darkshadow44.compatibility.common.CreativeTabCompat;
import darkshadow44.compatibility.common.TextureHelper;
import darkshadow44.compatibility.core.asm.MemoryClassLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.launchwrapper.Launch;

public class Core {
	public static TextureHelper textureHelper = new TextureHelper();
	public static MemoryClassLoader classLoader = new MemoryClassLoader(Launch.classLoader);
	public static final CreativeTabs tabCompat = new CreativeTabCompat("myMod");
}
