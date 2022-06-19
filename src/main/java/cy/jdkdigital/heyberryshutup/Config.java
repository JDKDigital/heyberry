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

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Common");

            disableVillagerDamage = builder
                    .comment("Villagers should not take damage when walking in berry bushes.")
                    .define("disableVillagerDamage", false);

            disableDamageWhenArmored = builder
                    .comment("Wearing boots and leggings prevent players from taking damage in berry bushes")
                    .define("disableDamageWhenArmored", false);

            builder.pop();
        }
    }
}
