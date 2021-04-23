package compat.sandbox.org.lwjgl.opengl;

import org.lwjgl.opengl.GL11;

import compat.sandbox.net.minecraft.client.renderer.Compat_Tessellator;

public class Compat_GL11 {

	private static boolean inISBRH;

	public static void setInISBRH(boolean inISBRH) {
		Compat_GL11.inISBRH = inISBRH;
	}

	public static void Compat_glColor4f(float r, float g, float b, float a) {
		if (inISBRH) {
			throw new RuntimeException("Not implemented");
		} else {
			GL11.glColor4f(r, g, b, a);
		}
	}

	public static void Compat_glDepthMask(boolean flag) {
		if (inISBRH) {
			// Ignore?
		} else {
			GL11.glDepthMask(flag);
		}
	}

	public static void Compat_glDisable(int cap) {
		if (inISBRH) {
			// Ignore?
		} else {
			GL11.glDisable(cap);
		}
	}

	public static void Compat_glEnable(int cap) {
		if (inISBRH) {
			// Ignore?
		} else {
			GL11.glEnable(cap);
		}
	}

	public static boolean Compat_glIsEnabled(int cap) {
		if (inISBRH) {
			// Ignore?
			return false;
		} else {
			return GL11.glIsEnabled(cap);
		}
	}

	public static void Compat_glPopAttrib() {
		if (inISBRH) {
			throw new RuntimeException("Not implemented");
		} else {
			GL11.glPopAttrib();
		}
	}

	public static void Compat_glPushAttrib(int mask) {
		if (inISBRH) {
			throw new RuntimeException("Not implemented");
		} else {
			GL11.glPushAttrib(mask);
		}
	}

	public static void Compat_glRotatef(float angle, float x, float y, float z) {
		if (inISBRH) {
			// TODO
		} else {
			GL11.glRotatef(angle, x, y, z);
		}
	}

	public static void Compat_glScalef(float x, float y, float z) {
		if (inISBRH) {
			// TODO
		} else {
			GL11.glScalef(x, y, z);
		}
	}

	public static void Compat_glTranslatef(float x, float y, float z) {
		if (inISBRH) {
			Compat_Tessellator.glTranslate(x, y, z);
		} else {
			GL11.glTranslatef(x, y, z);
		}
	}
}
