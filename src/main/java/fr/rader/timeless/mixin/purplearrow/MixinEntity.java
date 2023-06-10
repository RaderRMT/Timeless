package fr.rader.timeless.mixin.purplearrow;

import fr.rader.timeless.features.purplearrow.PurpleArrowHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinEntity {

    @Inject(
            method = "onRemoved",
            at = @At("HEAD")
    )
    public void onRemoved(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (!(entity instanceof ArrowEntity)) {
            return;
        }

        PurpleArrowHolder.getInstance().clean();
    }
}
