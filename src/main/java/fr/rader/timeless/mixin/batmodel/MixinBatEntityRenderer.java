package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.render.entity.BatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BatEntityModel;
import net.minecraft.client.render.entity.state.BatEntityRenderState;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BatEntityRenderer.class)
public abstract class MixinBatEntityRenderer extends MobEntityRenderer<BatEntity, BatEntityRenderState, BatEntityModel> {

    @Unique
    private static final Identifier OLD_BAT_TEXTURE = Identifier.of("timeless", "textures/entity/bat/bat.png");

    protected MixinBatEntityRenderer(EntityRendererFactory.Context context, BatEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/client/render/entity/state/BatEntityRenderState;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$onGetTexture(BatEntityRenderState batEntityRenderState, CallbackInfoReturnable<Identifier> cir) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        cir.setReturnValue(OLD_BAT_TEXTURE);
    }
}
