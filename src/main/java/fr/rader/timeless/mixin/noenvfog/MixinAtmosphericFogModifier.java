//#if MC>=12106
package fr.rader.timeless.mixin.noenvfog;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.AtmosphericFogModifier;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AtmosphericFogModifier.class)
public abstract class MixinAtmosphericFogModifier {

    @Inject(
            method = "applyStartEndModifier",
            at = @At("TAIL")
    )
    public void timeless$disableEnvironmentalFog(FogData data, Entity cameraEntity, BlockPos cameraPos, ClientWorld world, float viewDistance, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (!TimelessConfig.get().disableEnvironmentalFog) {
            return;
        }

        data.environmentalStart = Float.MAX_VALUE;
        data.environmentalEnd = Float.MAX_VALUE;
    }
}
//#endif
