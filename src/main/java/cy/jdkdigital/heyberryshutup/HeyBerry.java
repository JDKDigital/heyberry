package cy.jdkdigital.heyberryshutup;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HeyBerry.MODID)
public class HeyBerry
{
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MODID = "heyberryshutup";

    public HeyBerry()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);
    }

    public static boolean shouldStopDamage(boolean disabledInConfig, Entity entity) {
        return
                disabledInConfig ||
                        (Config.COMMON.disableVillagerDamage.get() && entity instanceof AbstractVillager) ||
                        (Config.COMMON.disableDamageWhenArmored.get() &&
                                entity instanceof LivingEntity &&
                                !((LivingEntity)entity).getItemBySlot(EquipmentSlot.LEGS).isEmpty() &&
                                !((LivingEntity)entity).getItemBySlot(EquipmentSlot.FEET).isEmpty());
    }
}
