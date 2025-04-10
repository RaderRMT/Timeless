package fr.rader.timeless.mixin.purplearrow;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.purplearrow.PurpleArrowHolder;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowEntityRenderer.class)
public abstract class MixinArrowEntityRenderer {

    @Unique
    private static final Identifier PURPLE_ARROW_TEXTURE = Identifier.of("timeless", "textures/entity/projectiles/purple_arrow.png");

    @Unique
    private final PurpleArrowHolder arrowHolder = PurpleArrowHolder.getInstance();

    @Inject(
            method = "getTexture(Lnet/minecraft/client/render/entity/state/ArrowEntityRenderState;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$onGetTexture(ArrowEntityRenderState arrowEntityRenderState, CallbackInfoReturnable<Identifier> cir) {
        boolean enabled = TimelessConfig.get().skeletonShootPurpleArrow;
        if (!enabled) {
            return;
        }

        ArrowEntity arrowEntity = this.arrowHolder.get(arrowEntityRenderState);
        if (arrowEntity == null) {
            return;
        }

        if (arrowEntity.getOwner() instanceof SkeletonEntity) {
            cir.setReturnValue(PURPLE_ARROW_TEXTURE);
        }
    }

    @Inject(
            method = "updateRenderState(Lnet/minecraft/entity/projectile/ArrowEntity;Lnet/minecraft/client/render/entity/state/ArrowEntityRenderState;F)V",
            at = @At("HEAD")
    )
    public void timeless$updateRenderState(ArrowEntity arrowEntity, ArrowEntityRenderState arrowEntityRenderState, float f, CallbackInfo ci) {
        this.arrowHolder.addIfNotPresent(arrowEntityRenderState, arrowEntity);
    }
}
