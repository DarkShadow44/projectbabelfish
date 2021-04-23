package compat.mixin;

import org.spongepowered.asm.mixin.Mixin;
	
@Mixin(TileEntity.class)
public abstract class MixinTileEntity {
	/*@Redirect(require = 1, method = "writeInternal(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/nbt/NBTTagCompound;", at = @At(value = "INVOKE", target = "java.lang.Object.getClass()Ljava/lang/Class;"))
	Class<?> hook_writeInternal_getClass(Object obj) {
		if (obj instanceof CompatI_TileEntity) {
			obj = ((CompatI_TileEntity) obj).getFake();
		}
		return obj.getClass();
	}

	@Redirect(require = 1, method = "create(Lnet/minecraft/world/World;Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/tileentity/TileEntity;", at = @At(value = "INVOKE", target = "java.lang.Class.newInstance()Ljava/lang/Object;"))
	private static Object hook_create_newInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		Object ret = clazz.newInstance();

		if (ret instanceof Compat_TileEntity) {
			ret = ((Compat_TileEntity) ret).getReal();
		}
		return ret;
	}*/
}
