//#if MC>=12004
package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.Timeless;
import net.minecraft.client.render.entity.BatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BatEntityRenderer.class)
public abstract class MixinBatEntityRenderer extends MobEntityRenderer<BatEntity, BatEntityModel> {

    @Unique
    private static final Identifier OLD_BAT_TEXTURE = new Identifier("timeless", "textures/entity/bat/bat.png");

    protected MixinBatEntityRenderer(EntityRendererFactory.Context context, BatEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/BatEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$onGetTexture(BatEntity batEntity, CallbackInfoReturnable<Identifier> cir) {
        if (!Timeless.getConfig().useOldBatModel) {
            return;
        }

        cir.setReturnValue(OLD_BAT_TEXTURE);
    }

    @Override
    public void scale(BatEntity entity, MatrixStack matrices, float amount) {
        if (!Timeless.getConfig().useOldBatModel) {
            super.scale(entity, matrices, amount);
            return;
        }

        matrices.scale(0.35f, 0.35f, 0.35f);
    }

    @Override
    public void setupTransforms(BatEntity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        if (Timeless.getConfig().useOldBatModel) {
            if (entity.isRoosting()) {
                matrices.translate(0f, -0.1f, 0f);
            } else {
                matrices.translate(0f, MathHelper.cos(animationProgress * 0.3f) * 0.1f, 0f);
            }
        }

        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
    }
}
//#endif