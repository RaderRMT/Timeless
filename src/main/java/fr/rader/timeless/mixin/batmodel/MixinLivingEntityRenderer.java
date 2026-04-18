package fr.rader.timeless.mixin.batmodel;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.BatRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class MixinLivingEntityRenderer<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends EntityRenderer<T, S> implements RenderLayerParent<S, M> {

    protected MixinLivingEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Inject(
            method = "scale",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void timeless$scale(LivingEntityRenderState state, PoseStack poseStack, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        if (state instanceof BatRenderState) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
            ci.cancel();
        }
    }
}
