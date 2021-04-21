package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.Compat_Minecraft;
import compat.sandbox.net.minecraft.client.renderer.texture.Wrapper_IIcon;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

public class Compat_RenderBlocks {

	private double renderMinZ = 0;
	private double renderMaxZ = 1;
	private double renderMinY = 0;
	private double renderMaxY = 1;
	private double renderMinX = 0;
	private double renderMaxX = 1;
	private Compat_IIcon overrideTexture = null;

	public Compat_IIcon Compat_func_147787_a(Compat_Block block, int side, int meta) { // getBlockIconFromSideAndMetadata
		return block.Compat_func_149691_a(side, meta);
	}

	public Compat_IIcon getIconSafe(Compat_IIcon icon) {
		if (icon != null)
			return icon;

		TextureAtlasSprite sprite = ((TextureMap) Minecraft.getInstance().getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE)).getAtlasSprite("missingno");

		return new Wrapper_IIcon(sprite);
	}

	public boolean Compat_func_147744_b() {
		return overrideTexture != null;
	}

	public void Compat_func_147757_a(Compat_IIcon icon) {
		overrideTexture = icon;
	}

	public void Compat_set_field_147840_d(Compat_IIcon icon) {
		overrideTexture = icon;
	}

	public Compat_IIcon Compat_get_field_147840_d() {
		return overrideTexture;
	}

	public void Compat_func_147764_f(Compat_Block block, double x, double y, double z, Compat_IIcon icon) {
		// TODO renderFaceXPos
	}

	public void Compat_func_147798_e(Compat_Block block, double p1, double p2, double p3, Compat_IIcon icon) {
		// TODO renderFaceXNeg
	}

	public void Compat_func_147806_b(Compat_Block block, double x, double y, double z, Compat_IIcon icon) {
		// TODO renderFaceYPos
	}

	public void Compat_func_147768_a(Compat_Block block, double x, double y, double z, Compat_IIcon icon) {
		// TODO renderFaceYNeg
	}

	public void Compat_func_147734_d(Compat_Block block, double x, double y, double z, Compat_IIcon icon) {
		// renderFaceZPos
	}

	public void Compat_func_147761_c(Compat_Block block, double x, double y, double z, Compat_IIcon icon) {
		// TODO renderFaceZNeg
	}

	public void Compat_func_147775_a(Compat_Block block) {
		// TODO setRenderBoundsFromBlock
	}

	public void Compat_func_147782_a(double p1, double p2, double p3, double p4, double p5, double p6) {
		// TODO setRenderBounds
	}

	public boolean Compat_func_147784_q(Compat_Block block, int p1, int p2, int p3) {
		// TODO setRenderBounds
		return false;
	}

	public void Compat_func_147795_a(Compat_Block block, int p1, double p2, double p3, double p4) {
		// TODO renderBlockCropsImpl
	}

	public boolean Compat_func_147805_b(Compat_Block block, int p1, int p2, int p3) {
		// TODO renderBlockByRenderType
		return false;
	}

	public boolean Compat_func_147746_l(Compat_Block block, int x, int y, int z) {
		// TODO renderCrossedSquares
		return false;
	}

	public void Compat_func_147765_a(Compat_IIcon icon, double x, double y, double z, float p4) {
		// TODO drawCrossedSquares
	}

	public void Compat_func_147769_a(Compat_Block block, int p1, int p2, int p3) {
		// TODO renderBlockAllFaces
	}

	public Compat_IBlockAccess Compat_get_field_147845_a() {
		// TODO blockAccess
		return null;
	}

	public double Compat_get_field_147851_l() {
		return renderMinZ;
	}

	public double Compat_get_field_147853_m() {
		return renderMaxZ;
	}

	public double Compat_get_field_147855_j() {
		return renderMinY;
	}

	public double Compat_get_field_147857_k() {
		return renderMaxY;
	}

	public double Compat_get_field_147859_h() {
		return renderMinX;
	}

	public double Compat_get_field_147861_i() {
		return renderMaxX;
	}

	public Compat_Minecraft Compat_get_field_147877_p() {
		// TODO
		return new Compat_Minecraft(Minecraft.getInstance());
	}

	public void Compat_set_field_147838_g(boolean value) {
		// TODO renderFromInside
	}

	public void Compat_set_field_147842_e(boolean value) {
		// TODO flipTexture
	}

	public void Compat_set_field_147851_l(double value) {
		renderMinZ = value;
	}

	public void Compat_set_field_147853_m(double value) {
		renderMaxZ = value;
	}

	public void Compat_set_field_147855_j(double value) {
		renderMinY = value;
	}

	public void Compat_set_field_147857_k(double value) {
		renderMaxY = value;
	}

	public void Compat_set_field_147859_h(double value) {
		renderMinX = value;
	}

	public void Compat_set_field_147861_i(double value) {
		renderMaxX = value;
	}
}
