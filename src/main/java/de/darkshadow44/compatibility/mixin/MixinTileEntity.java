package de.darkshadow44.compatibility.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.CompatI_TileEntity;
import net.minecraft.tileentity.TileEntity;

@Mixin(TileEntity.class)
public abstract class MixinTileEntity {
	@Redirect(require = 1, method = "writeInternal(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/nbt/NBTTagCompound;", at = @At(value = "INVOKE", target = "java.lang.Object.getClass()Ljava/lang/Class;"))
	Class<?> hook_writeInternal_getClass(Object obj) {
		if (obj instanceof CompatI_TileEntity) {
			obj = ((CompatI_TileEntity) obj).getFake();
		}
		return obj.getClass();
	}
}
