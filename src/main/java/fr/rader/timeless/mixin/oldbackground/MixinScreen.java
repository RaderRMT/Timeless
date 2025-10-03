//#if MC>=12006
package fr.rader.timeless.mixin.oldbackground;

import com.terraformersmc.modmenu.gui.ModMenuOptionsScreen;
import com.terraformersmc.modmenu.gui.ModsScreen;
import fr.rader.timeless.config.TimelessConfig;
import me.shedaniel.clothconfig2.gui.AbstractConfigScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.MessageScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.StatsScreen;
import net.minecraft.client.gui.screen.option.*;
import net.minecraft.client.gui.screen.pack.PackScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//#if MC>=12106
import net.minecraft.client.gl.RenderPipelines;
//#endif

//#if MC<=12108
//$$ import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
//#endif

//#if MC<=12105
//$$ import net.minecraft.client.render.RenderLayer;
//#endif

import java.util.Arrays;

@Mixin(Screen.class)
public abstract class MixinScreen {

    @Unique
    //#if MC>=12100
    private static final Identifier OPTIONS_BACKGROUND_TEXTURE = Identifier.of("timeless", "textures/gui/options_background.png");
    //#else
    //$$ private static final Identifier OPTIONS_BACKGROUND_TEXTURE = new Identifier("timeless", "textures/gui/options_background.png");
    //#endif

    @Unique
    private static final Class<?>[] DIRT_BACKGROUND_CLASSES = {
            GameOptionsScreen.class,
            SoundOptionsScreen.class,
            ChatOptionsScreen.class,
            AccessibilityOptionsScreen.class,
            VideoOptionsScreen.class,
            LanguageOptionsScreen.class,
            PackScreen.class,
            TelemetryInfoScreen.class,
            StatsScreen.class,
            MessageScreen.class,
            //#if MC<=12108
            //$$ DownloadingTerrainScreen.class,
            //#endif
    };

    @Shadow public int width;
    @Shadow public int height;

    @Shadow @Nullable
    protected MinecraftClient client;

    @Shadow public abstract void renderInGameBackground(DrawContext par1);

    @Unique
    private boolean shouldRenderDirtBackground;

    @Inject(
            method = "renderBackground",
            at = @At("HEAD"),
            cancellable = true
    )
    private void timeless$renderBackground(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldScreenBackground) {
            return;
        }

        if (this.client.world == null) {
            timeless$renderDirtBackground(context);
        } else {
            if (this.shouldRenderDirtBackground) {
                timeless$renderDirtBackground(context);
            } else {
                renderInGameBackground(context);
            }
        }

        ci.cancel();
    }

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void timeless$init(Text title, CallbackInfo ci) {
        Class<?> superClass = ((Screen) (Object) this).getClass();

        if (superClass == ControlsOptionsScreen.class) {
            this.shouldRenderDirtBackground = false;
        } else {
            this.shouldRenderDirtBackground = Arrays.stream(DIRT_BACKGROUND_CLASSES).anyMatch(clazz -> clazz.isAssignableFrom(superClass));
        }
    }

    @Unique
    private void timeless$renderDirtBackground(DrawContext context) {
        //#if MC>=12106
        context.drawTexture(RenderPipelines.GUI_TEXTURED, OPTIONS_BACKGROUND_TEXTURE, 0, 0, 0.0f, 0.0f, this.width, this.height, 32, 32, ColorHelper.getArgb(255, 64, 64, 64));
        //#elseif MC>=12102
        //$$ context.drawTexture(RenderLayer::getGuiTextured, OPTIONS_BACKGROUND_TEXTURE, 0, 0, 0.0f, 0.0f, this.width, this.height, 32, 32, ColorHelper.getArgb(255, 64, 64, 64));
        //#else
        //$$ context.setShaderColor(0.25F, 0.25F, 0.25F, 1.0F);
        //$$ context.drawTexture(OPTIONS_BACKGROUND_TEXTURE, 0, 0, 0, 0.0F, 0.0F, this.width, this.height, 32, 32);
        //$$ context.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //#endif
    }
}
//#endif
