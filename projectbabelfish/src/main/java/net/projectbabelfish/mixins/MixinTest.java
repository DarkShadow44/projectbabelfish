package net.projectbabelfish.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class MixinTest {
	@Inject(at = @At("TAIL"), method = "<init>")
	private void test(CallbackInfo c) {
		//throw new RuntimeException("Hello from ProjectBabelfish!");
	}
}
