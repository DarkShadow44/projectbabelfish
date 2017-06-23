package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

public class ItemFood extends Item {
	public ItemFood(int par1, int par2, float par3, boolean par4) {
		super(par1);
	}

	public ItemFood(int par1, int par2, boolean par3) {
		this(par1, par2, 0.6F, par3);
	}

	public ItemFood setAlwaysEdible() {
		return this;
	}
}
