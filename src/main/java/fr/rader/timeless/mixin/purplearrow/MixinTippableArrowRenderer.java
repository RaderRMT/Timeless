package fr.rader.timeless.mixin.purplearrow;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.purplearrow.PurpleArrowHolder;
import net.minecraft.client.renderer.entity.TippableArrowRenderer;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.client.renderer.entity.state.TippableArrowRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TippableArrowRenderer.class)
public abstract class MixinTippableArrowRenderer {

    @Unique
    private static final Identifier timeless$PURPLE_ARROW_TEXTURE = Identifier.fromNamespaceAndPath("timeless", "textures/entity/projectiles/purple_arrow.png");

    @Unique
    private final PurpleArrowHolder timeless$arrowHolder = PurpleArrowHolder.getInstance();

    @Inject(
            method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/ArrowRenderState;)Lnet/minecraft/resources/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getTextureLocation(ArrowRenderState arrowRenderState, CallbackInfoReturnable<Identifier> cir) {
        if (!TimelessConfig.get().skeletonShootPurpleArrow) {
            return;
        }

        AbstractArrow arrowEntity = this.timeless$arrowHolder.get(arrowRenderState);
        if (arrowEntity == null) {
            return;
        }

        if (arrowEntity.getOwner() instanceof Skeleton) {
            cir.setReturnValue(timeless$PURPLE_ARROW_TEXTURE);
        }
    }

    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/projectile/arrow/Arrow;Lnet/minecraft/client/renderer/entity/state/TippableArrowRenderState;F)V",
            at = @At("HEAD")
    )
    public void timeless$extractRenderState(Arrow entity, TippableArrowRenderState state, float f, CallbackInfo ci) {
        this.timeless$arrowHolder.addIfNotPresent(state, entity);
    }
}
