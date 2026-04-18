package fr.rader.timeless.mixin.hitdirection;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public abstract class MixinPlayer extends Avatar {

    protected MixinPlayer(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @ModifyVariable(
            method = "animateHurt",
            at = @At("HEAD"),
            argsOnly = true
    )
    public float timeless$animateHurt(float yaw) {
        if (TimelessConfig.get().disableHitDirection) {
            return 0;
        }

        return yaw;
    }
}
