package fr.rader.timeless.mixin.hitdirection;

import fr.rader.timeless.Timeless;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {

    @Shadow
    protected float damageTiltYaw;

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }


    @ModifyVariable(
            method = "animateDamage",
            at = @At("HEAD"),
            argsOnly = true
    )
    public float disableHitDirection(float yaw) {
        if (Timeless.getConfig().disableHitDirection) {
            return 0;
        }

        return yaw;
    }
}
