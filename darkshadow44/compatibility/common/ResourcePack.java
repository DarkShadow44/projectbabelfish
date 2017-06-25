package darkshadow44.compatibility.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import darkshadow44.compatibility.version.v1_2_5.sandbox.Core;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class ResourcePack implements IResourcePack {

	@Override
	public InputStream getInputStream(ResourceLocation loc) throws IOException {
		if (!loc.getResourceDomain().equals("compat"))
			return null;
		String path = loc.getResourcePath();
		return Core.classLoader.getResourceAsStream(path);
	}

	@Override
	public boolean resourceExists(ResourceLocation loc) {
		InputStream res = null;
		try {
			res = getInputStream(loc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res != null;
	}

	@Override
	public Set getResourceDomains() {
		Set set = new HashSet();
		set.add("compat");
		return set;
	}

	@Override
	public IMetadataSection getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
		return null;
	}

	@Override
	public BufferedImage getPackImage() throws IOException {
		return null;
	}

	@Override
	public String getPackName() {
		return "compat";
	}

}
