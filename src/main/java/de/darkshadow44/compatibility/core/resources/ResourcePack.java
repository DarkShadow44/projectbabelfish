package de.darkshadow44.compatibility.core.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import de.darkshadow44.compatibility.core.CompatibilityMod;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class ResourcePack implements IResourcePack {

	@Override
	public InputStream getInputStream(ResourceLocation loc) throws IOException {
		String path = loc.getResourceDomain() + "/" + loc.getResourcePath();
		return CompatibilityMod.classLoader.getResourceAsStream(path);
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
	public Set<String> getResourceDomains() {
		Set<String> set = new HashSet<>();
		set.add("compatibility");
		return set;
	}

	@Override
	public BufferedImage getPackImage() throws IOException {
		return null;
	}

	@Override
	public String getPackName() {
		return "compatibility";
	}

	@Override
	public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer arg0, String arg1) throws IOException {
		return null;
	}

}
