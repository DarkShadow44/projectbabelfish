package compat.sandbox.net.minecraft.client;

import com.google.common.util.concurrent.ListenableFuture;

import compat.sandbox.net.minecraft.client.entity.Compat_EntityPlayerSP;
import compat.sandbox.net.minecraft.client.gui.Compat_GuiIngame;
import compat.sandbox.net.minecraft.client.gui.Compat_GuiScreen;
import compat.sandbox.net.minecraft.client.multiplayer.Compat_WorldClient;
import compat.sandbox.net.minecraft.client.renderer.Compat_BlockRendererDispatcher;
import compat.sandbox.net.minecraft.client.renderer.Compat_RenderItem;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureManager;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureMap;
import compat.sandbox.net.minecraft.client.settings.Compat_GameSettings;
import compat.sandbox.net.minecraft.util.math.Compat_RayTraceResult;
import net.minecraft.client.Minecraft;

public class Compat_Minecraft {

	private final Minecraft original;

	public Compat_Minecraft(Minecraft original) {
		this.original = original;
	}

	public Minecraft getReal() {
		return original;
	}

	public static Compat_Minecraft Compat_func_71410_x() {
		return new Compat_Minecraft(Minecraft.getInstance());
	}

	public ListenableFuture<Object> Compat_func_152344_a(Runnable run) {
		return original.addScheduledTask(run);
	}

	public static boolean Compat_func_71379_u() {
		return Minecraft.isAmbientOcclusionEnabled();
	}

	public Compat_BlockRendererDispatcher Compat_func_175602_ab() {
		return new Compat_BlockRendererDispatcher(original.getBlockRendererDispatcher());
	}

	public Compat_WorldClient Compat_get_field_71441_e() {
		return original.world == null ? null : new Compat_WorldClient(original.world);
	}

	public Compat_EntityPlayerSP Compat_get_field_71439_g() {
		return original.player == null ? null : new Compat_EntityPlayerSP(original.player);
	}

	public Compat_RayTraceResult Compat_get_field_71476_x() {
		return Compat_RayTraceResult.getFake(original.objectMouseOver);
	}

	public Compat_TextureMap Compat_func_147117_R() {
		return new Compat_TextureMap(original.getTextureMap());
	}

	public Compat_RenderItem Compat_func_175599_af() {
		return new Compat_RenderItem(original.getItemRenderer());
	}

	public Compat_TextureManager Compat_func_110434_K() {
		return new Compat_TextureManager(original.getTextureManager());
	}

	public void Compat_func_147108_a(Compat_GuiScreen gui) {
		original.displayGuiScreen(gui.getReal());
	}

	public Compat_TextureManager Compat_get_field_71446_o() {
		return new Compat_TextureManager(original.textureManager);
	}

	public Compat_GuiIngame Compat_get_field_71456_v() {
		return new Compat_GuiIngame(original.ingameGUI);
	}

	public Compat_GuiScreen Compat_get_field_71462_r() {
		return new Compat_GuiScreen(original.currentScreen);
	}

	public Compat_GameSettings Compat_get_field_71474_y() {
		return new Compat_GameSettings(original.gameSettings);
	}

}
