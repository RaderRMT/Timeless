//#if MC>=12106
package fr.rader.timeless.mixin.noenvfog;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.render.fog.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FogRenderer.class)
public abstract class MixinFogRenderer {

    @ModifyVariable(
            method = "applyFog(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    public float timeless$disableEnvironmentalFog(float environmentalStart) {
        if (!TimelessConfig.get().disableEnvironmentalFog) {
            return environmentalStart;
        }

        return Float.MAX_VALUE;
    }
}
//#endif
