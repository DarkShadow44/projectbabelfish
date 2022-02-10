package net.projectbabelfish.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.projectbabelfish.ProjectBabelfish;

public class ResourcePack implements PackResources {

	@Override
	public InputStream getResource(PackType pType, ResourceLocation pLocation) throws IOException {
		String path = pLocation.getNamespace() + "/" + pLocation.getPath();
		return ProjectBabelfish.classLoader.getResourceAsStream(path);
	}

	@Override
	public  boolean hasResource(PackType pType, ResourceLocation pLocation) {
		InputStream res = null;
		try {
			res = getResource(null, pLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res != null;
	}

	@Override
	public Set<String> getNamespaces(PackType pType) {
		Set<String> set = new HashSet<>();
		set.add(ProjectBabelfish.MODID);
		for (CompatibilityLayer layer : ProjectBabelfish.LAYERS) {
			for (ModInfo mod : layer.mods) {
				set.add(mod.id);
			}
		}
		return set;
	}

	@Override
	public String getName() {
		return "compatibility";
	}

	@Override
	public <T> T getMetadataSection(MetadataSectionSerializer<T> pDeserializer) throws IOException {
		return null;
	}

	@Override
	public InputStream getRootResource(String pFileName) throws IOException {
		return null;
	}

	@Override
	public Collection<ResourceLocation> getResources(PackType pType, String pNamespace, String pPath, int pMaxDepth,
			Predicate<String> pFilter) {
		return null;
	}

	@Override
	public void close() {
	}

}

