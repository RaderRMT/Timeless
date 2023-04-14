package fr.rader.timeless.mixin.oldhitanimation;

import fr.rader.timeless.Timeless;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {

    @Shadow
    protected float damageTiltYaw;

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void animateDamage(float yaw) {
        if (Timeless.getConfig().useOldHitAnimation) {
            yaw = 0;
        }

        super.animateDamage(yaw);
        this.damageTiltYaw = yaw;
    }
}
