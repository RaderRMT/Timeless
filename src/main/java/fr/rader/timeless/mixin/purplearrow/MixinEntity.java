package fr.rader.timeless.mixin.purplearrow;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.purplearrow.PurpleArrowHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinEntity {

    @Inject(
            method = "onRemoval",
            at = @At("HEAD")
    )
    public void timeless$onRemoval(Entity.RemovalReason reason, CallbackInfo ci) {
        if (!TimelessConfig.get().skeletonShootPurpleArrow) {
            return;
        }

        Entity entity = (Entity) (Object) this;
        if (!(entity instanceof Arrow)) {
            return;
        }

        PurpleArrowHolder.getInstance().clean();
    }
}
