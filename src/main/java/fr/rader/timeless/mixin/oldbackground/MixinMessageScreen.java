//#if MC>=12005
package fr.rader.timeless.mixin.oldbackground;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.MessageScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageScreen.class)
public abstract class MixinMessageScreen extends Screen {

    protected MixinMessageScreen(Text title) {
        super(title);
    }

    @Inject(
            method = "renderBackground",
            at = @At("HEAD"),
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
