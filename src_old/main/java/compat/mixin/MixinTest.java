package compat.mixin;

import org.spongepowered.asm.mixin.Mixin;

import compat.sandbox.net.minecraftforge.fml.common.gameevent.Compat_TickEvent_ServerTickEvent;
import net.minecraft.block.Block;

//@Mixin(targets = "compat/sandbox/com/amadornes/rscircuits/CommonProxy")
@Mixin(Block.class)
public class MixinTest {

	// @Inject(method = "serverTick", at = @At("RETURN"), require = 1)
	// @Overwrite
	public void serverTicsk(Compat_TickEvent_ServerTickEvent event) {
		throw new RuntimeException("ex");
	}
}
