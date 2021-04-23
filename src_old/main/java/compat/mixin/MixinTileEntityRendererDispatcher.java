package compat.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import compat.sandbox.net.minecraft.tileentity.CompatI_TileEntity;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;

@Mixin(TileEntityRendererDispatcher.class)
public class MixinTileEntityRendererDispatcher {

	@Redirect(require = 1, method = "getRenderer(Lnet/minecraft/tileentity/TileEntity;)Lnet/minecraft/client/renderer/tileentity/TileEntitySpecialRenderer;", at = @At(value = "INVOKE", target = "java.lang.Object.getClass()Ljava/lang/Class;"))
	Class<?> Hook_getRenderer_getClass(Object obj) {
		if (obj instanceof CompatI_TileEntity) {
			obj = ((CompatI_TileEntity) obj).getFake();
		}
		return obj.getClass();
	}

	@Redirect(require = 1, method = "getRenderer(Ljava/lang/Class;)Lnet/minecraft/client/renderer/tileentity/TileEntitySpecialRenderer;", at = @At(value = "INVOKE", target = "java.lang.Class.getSuperclass()Ljava/lang/Class;"))
	Class<?> Hook_getRenderer_getSuperclass(Class<?> clazz) {
		if (clazz == Compat_TileEntity.class) {
			return TileEntity.class;
		}
		return clazz.getSuperclass();
	}
}
