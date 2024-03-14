package fr.rader.timeless.mixin.hitdirection;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(
            method = "animateDamage",
            at = @At("HEAD"),
            argsOnly = true
    )
    public float timeless$disableHitDirection(float yaw) {
        if (TimelessConfig.get().disableHitDirection) {
            return 0;
        }

        return yaw;
    }
}
