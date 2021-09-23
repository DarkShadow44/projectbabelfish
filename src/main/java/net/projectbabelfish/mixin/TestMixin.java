package net.projectbabelfish.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;

/*@Mixin(TitleScreen.class)
public class TestMixin {

	@Inject(at = @At("HEAD"), method = "isPauseScreen()Z")
	private void init(CallbackInfo info) {
		System.out.println("This line is printed by an example mod mixin!");
	}
	
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init2(CallbackInfo info) {
		System.out.println("This line is printed by an example mod mixin!");
	}
}*/

@Mixin(ClientLevel.class)
public class TestMixin {
	@Inject(at = @At("HEAD"), method = "tickTime()V")
	private void test3(CallbackInfo ci) {
		System.out.println("This line is printed by an example mod mixin!");
	}
	@Inject(at = @At("HEAD"), method = "setGameTime(J)V")
	private void test2(int playerEntityId, BlockPos pos, int progress, CallbackInfo ci) {
		System.out.println("This line is printed by an example mod mixin!");
	}

	@Inject(at = @At("HEAD"), method = "destroyBlockProgress(ILnet/minecraft/core/BlockPos;I)V")
	private void shouldHandlePrecipitation(int playerEntityId, BlockPos pos, int progress, CallbackInfo ci) {
		System.out.println("This line is printed by an example mod mixin!");
	}
}
