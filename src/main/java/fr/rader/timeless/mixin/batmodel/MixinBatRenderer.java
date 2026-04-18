package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.model.ambient.BatModel;
import net.minecraft.client.renderer.entity.BatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.BatRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ambient.Bat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BatRenderer.class)
public abstract class MixinBatRenderer extends MobRenderer<Bat, BatRenderState, BatModel> {

    @Unique
    private static final Identifier timeless$OLD_BAT_TEXTURE = Identifier.fromNamespaceAndPath("timeless", "textures/entity/bat/bat.png");

    public MixinBatRenderer(EntityRendererProvider.Context context, BatModel model, float shadow) {
        super(context, model, shadow);
    }

    @Inject(
            method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/BatRenderState;)Lnet/minecraft/resources/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getTextureLocation(BatRenderState state, CallbackInfoReturnable<Identifier> cir) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        cir.setReturnValue(timeless$OLD_BAT_TEXTURE);
    }
}
