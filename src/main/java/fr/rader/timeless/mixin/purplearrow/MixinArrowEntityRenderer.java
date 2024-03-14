package fr.rader.timeless.mixin.purplearrow;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.purplearrow.PurpleArrowHolder;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowEntityRenderer.class)
public abstract class MixinArrowEntityRenderer {

    @Unique
    private static final Identifier PURPLE_ARROW_TEXTURE = new Identifier("timeless", "textures/entity/projectiles/purple_arrow.png");

    @Unique
    private final PurpleArrowHolder arrowHolder = PurpleArrowHolder.getInstance();

    @Inject(
            method = "getTexture(Lnet/minecraft/entity/projectile/ArrowEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$onGetTexture(ArrowEntity arrowEntity, CallbackInfoReturnable<Identifier> cir) {
        boolean enabled = TimelessConfig.get().skeletonShootPurpleArrow;
        if (enabled && this.arrowHolder.contains(arrowEntity)) {
            cir.setReturnValue(PURPLE_ARROW_TEXTURE);
            return;
        }

        if (!(arrowEntity.getOwner() instanceof SkeletonEntity)) {
            return;
        }

        this.arrowHolder.add(arrowEntity);

        if (enabled) {
            cir.setReturnValue(PURPLE_ARROW_TEXTURE);
        }
    }
}
