package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.block;

import net.minecraft.block.material.Material;

public class BlockShim extends net.minecraft.block.Block {	
	
	Block blockSandbox;
	
	protected BlockShim(Material material) {
		super(material);
	}

	public void ProcessUpdates()
	{
		blockSandbox.ProcessUpdates();
	}
}
