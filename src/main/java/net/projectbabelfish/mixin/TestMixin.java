package net.projectbabelfish.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.multiplayer.ClientLevel;

@Mixin(ClientLevel.class)
public class TestMixin {
	@Inject(at = @At("HEAD"), method = "setGameTime(J)V")
	private void test2(long time, CallbackInfo ci) {
		// System.out.println("This line is printed by an example mod mixin!");
	}
}
