//#if MC>=12006
package fr.rader.timeless.mixin.oldbackground;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DownloadingTerrainScreen.class)
public abstract class MixinDownloadingTerrainScreen extends Screen {

    protected MixinDownloadingTerrainScreen(Text title) {
        super(title);
    }

    @Inject(
            method = "renderBackground",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/DownloadingTerrainScreen;renderPanoramaBackground(Lnet/minecraft/client/gui/DrawContext;F)V",
                    shift = At.Shift.BEFORE
            ),
            cancellable = true
    )
    private void timeless$renderBackground(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldScreenBackground) {
            return;
        }

        super.renderBackground(context, mouseX, mouseY, delta);
        ci.cancel();
    }
}
//#endif
