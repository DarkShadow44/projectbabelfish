package de.darkshadow44.compatibility.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.CompatI_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

@Mixin(TileEntityRendererDispatcher.class)
public class MixinTileEntityRendererDispatcher {

	@Redirect(require = 1, method = "getRenderer(Lnet/minecraft/tileentity/TileEntity;)Lnet/minecraft/client/renderer/tileentity/TileEntitySpecialRenderer;", at = @At(value = "INVOKE", target = "java.lang.Object.getClass()Ljava/lang/Class;"))
	Class<?> Hook_get(Object obj) {
		if (obj instanceof CompatI_TileEntity) {
			obj = ((CompatI_TileEntity) obj).getFake();
		}
		return obj.getClass();
	}
}