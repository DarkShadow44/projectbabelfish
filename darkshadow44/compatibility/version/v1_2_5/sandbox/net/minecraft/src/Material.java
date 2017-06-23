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
	public static final Material snow = (Material) (new MaterialLogic(MapColor.snowColor)).setReplaceable();
	public static final Material clay = new Material(MapColor.clayColor);
	public static final Material craftedSnow = (new Material(MapColor.snowColor));
	public static final Material ice = (new Material(MapColor.iceColor));
	public static final Material circuits = (new Material(MapColor.airColor));
	public static final Material iron = (new Material(MapColor.ironColor));

	public Material(MapColor p_i2116_1_) {
		super(p_i2116_1_);
	}

}
