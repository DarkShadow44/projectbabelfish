package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

public class Potion {

    public static final Potion[] potionTypes = new Potion[32];
    public static final Potion field_35676_b = null;
    public static final Potion moveSpeed = (new Potion(1, false, 8171462)).setPotionName("potion.moveSpeed").setIconIndex(0, 0);
    public static final Potion moveSlowdown = (new Potion(2, true, 5926017)).setPotionName("potion.moveSlowdown").setIconIndex(1, 0);
    public static final Potion digSpeed = (new Potion(3, false, 14270531)).setPotionName("potion.digSpeed").setIconIndex(2, 0).setEffectiveness(1.5D);
    public static final Potion digSlowdown = (new Potion(4, true, 4866583)).setPotionName("potion.digSlowDown").setIconIndex(3, 0);
    public static final Potion damageBoost = (new Potion(5, false, 9643043)).setPotionName("potion.damageBoost").setIconIndex(4, 0);
    public static final Potion heal = (new PotionHealth(6, false, 16262179)).setPotionName("potion.heal");
    public static final Potion harm = (new PotionHealth(7, true, 4393481)).setPotionName("potion.harm");
    public static final Potion jump = (new Potion(8, false, 7889559)).setPotionName("potion.jump").setIconIndex(2, 1);
    public static final Potion confusion = (new Potion(9, true, 5578058)).setPotionName("potion.confusion").setIconIndex(3, 1).setEffectiveness(0.25D);
    public static final Potion regeneration = (new Potion(10, false, 13458603)).setPotionName("potion.regeneration").setIconIndex(7, 0).setEffectiveness(0.25D);
    public static final Potion resistance = (new Potion(11, false, 10044730)).setPotionName("potion.resistance").setIconIndex(6, 1);
    public static final Potion fireResistance = (new Potion(12, false, 14981690)).setPotionName("potion.fireResistance").setIconIndex(7, 1);
    public static final Potion waterBreathing = (new Potion(13, false, 3035801)).setPotionName("potion.waterBreathing").setIconIndex(0, 2);
    public static final Potion invisibility = (new Potion(14, false, 8356754)).setPotionName("potion.invisibility").setIconIndex(0, 1).setPotionUnusable();
    public static final Potion blindness = (new Potion(15, true, 2039587)).setPotionName("potion.blindness").setIconIndex(5, 1).setEffectiveness(0.25D);
    public static final Potion nightVision = (new Potion(16, false, 2039713)).setPotionName("potion.nightVision").setIconIndex(4, 1).setPotionUnusable();
    public static final Potion hunger = (new Potion(17, true, 5797459)).setPotionName("potion.hunger").setIconIndex(1, 1);
    public static final Potion weakness = (new Potion(18, true, 4738376)).setPotionName("potion.weakness").setIconIndex(5, 0);
    public static final Potion poison = (new Potion(19, true, 5149489)).setPotionName("potion.poison").setIconIndex(6, 0).setEffectiveness(0.25D);

    public int id;
    private String name = "";
    private int statusIconIndex = -1;
    private boolean isBadEffect;
    private double effectiveness;
    private boolean usable;
    private int liquidColor;

    protected Potion(int par1, boolean par2, int par3)
    {
    }

	private Potion setEffectiveness(double d) {
		return this;
	}

	private Potion setPotionUnusable() {
		return this;
	}

	private Potion setIconIndex(int i, int j) {
		return this;
	}

	protected Potion setPotionName(String string) {
		return this;
	}

}
