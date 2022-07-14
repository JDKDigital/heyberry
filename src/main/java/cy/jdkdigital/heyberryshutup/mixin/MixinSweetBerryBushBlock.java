package cy.jdkdigital.heyberryshutup.mixin;

import cy.jdkdigital.heyberryshutup.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SweetBerryBushBlock.class)
public class MixinSweetBerryBushBlock {
    @Inject(
            at = {@At("HEAD")},
            method = {"entityInside(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)V"},
            cancellable = true
    )
    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity, CallbackInfo callbackInfo) {
        if (Config.COMMON.disableBerryDamage.get() || (Config.COMMON.disableVillagerDamage.get() && entity instanceof AbstractVillager) || (Config.COMMON.disableDamageWhenArmored.get() && entity instanceof LivingEntity && !((LivingEntity)entity).getItemBySlot(EquipmentSlot.LEGS).isEmpty() && !((LivingEntity)entity).getItemBySlot(EquipmentSlot.FEET).isEmpty())) {
            entity.makeStuckInBlock(blockState, new Vec3(0.8F, 0.75D, 0.8F));
            callbackInfo.cancel();
        }
    }
}
