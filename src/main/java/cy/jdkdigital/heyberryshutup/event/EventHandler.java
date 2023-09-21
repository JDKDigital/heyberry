package cy.jdkdigital.heyberryshutup.event;

import cy.jdkdigital.heyberryshutup.Config;
import cy.jdkdigital.heyberryshutup.HeyBerry;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HeyBerry.MODID)
public class EventHandler
{
    @SubscribeEvent
    public static void onLivingHurt(LivingAttackEvent event) {
        if (event.getSource().equals(event.getEntity().level().damageSources().cactus())) {
            if (HeyBerry.shouldStopDamage(Config.COMMON.disableCactusDamage.get(), event.getEntity())) {
                event.setCanceled(true);
            }
        }
        if (event.getSource().equals(event.getEntity().level().damageSources().sweetBerryBush())) {
            if (HeyBerry.shouldStopDamage(Config.COMMON.disableBerryDamage.get(), event.getEntity())) {
                event.setCanceled(true);
            }
        }
    }
}
