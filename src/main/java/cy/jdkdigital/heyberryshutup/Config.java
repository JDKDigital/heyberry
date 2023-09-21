package cy.jdkdigital.heyberryshutup;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;
    public static final Common COMMON = new Common(BUILDER);

    static {
        CONFIG = BUILDER.build();
    }

    public static class Common
    {
        public final ForgeConfigSpec.BooleanValue disableVillagerDamage;
        public final ForgeConfigSpec.BooleanValue disableDamageWhenArmored;
        public final ForgeConfigSpec.BooleanValue disableBerryDamage;
        public final ForgeConfigSpec.BooleanValue disableCactusDamage;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Common");

            disableVillagerDamage = builder
                    .comment("Villagers should not take damage when walking in berry bushes or on cactus.")
                    .define("disableVillagerDamage", true);

            disableDamageWhenArmored = builder
                    .comment("Wearing boots and leggings prevent players from taking damage in berry bushes and on cactus")
                    .define("disableDamageWhenArmored", true);

            disableBerryDamage = builder
                    .comment("Disable berry damage for all entities. If set to true, the other configs do not matter.")
                    .define("disableBerryDamage", false);

            disableCactusDamage = builder
                    .comment("Disable cactus damage for all entities. If set to true, the other configs do not matter.")
                    .define("disableCactusDamage", false);

            builder.pop();
        }
    }
}
