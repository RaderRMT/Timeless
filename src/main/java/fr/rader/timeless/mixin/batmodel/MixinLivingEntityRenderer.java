//#if MC>=12102
package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BatEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class MixinLivingEntityRenderer<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends EntityRenderer<T, S> implements FeatureRendererContext<S, M> {

    protected MixinLivingEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Inject(
            method = "scale",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void timeless$scale(LivingEntityRenderState state, MatrixStack matrices, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        if (state instanceof BatEntityRenderState) {
            matrices.scale(0.35f, 0.35f, 0.35f);
            ci.cancel();
        }
    }
}
//#endif
