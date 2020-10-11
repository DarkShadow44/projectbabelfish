package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.init;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_BlockFire;
import net.minecraft.init.Blocks;

public class Compat_Blocks {
	public static Compat_BlockFire Compat_get_field_150480_ab()
	{
		return new Compat_BlockFire(Blocks.FIRE);
	}
}
