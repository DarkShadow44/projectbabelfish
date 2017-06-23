package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLogic;

public class Material extends net.minecraft.block.material.Material {

	public static final Material rock = (Material) (new Material(MapColor.stoneColor)).setRequiresTool();
	public static final Material wood = (Material) (new Material(MapColor.woodColor)).setBurning();
	public static final Material leaves = (Material) (new Material(MapColor.foliageColor)).setBurning();
	public static final Material plants = (Material) (new Material(MapColor.foliageColor)).setNoPushMobility();
	public static final Material ground = new Material(MapColor.dirtColor);
	public static final Material grass = new Material(MapColor.grassColor);
	public static final Material sand = new Material(MapColor.sandColor);

	public Material(MapColor p_i2116_1_) {
		super(p_i2116_1_);
	}

}
