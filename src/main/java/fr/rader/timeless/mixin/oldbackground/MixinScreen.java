package fr.rader.timeless.mixin.oldbackground;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.WorldOptionsScreen;
import net.minecraft.client.gui.screens.options.*;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import net.minecraft.client.gui.screens.options.controls.KeyBindsScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(Screen.class)
public abstract class MixinScreen {

    @Unique
    private static final Identifier timeless$OPTIONS_BACKGROUND_TEXTURE = Identifier.fromNamespaceAndPath("timeless", "textures/gui/options_background.png");

    @Unique
    private static final Class<?>[] timeless$DIRT_BACKGROUND_CLASSES = {
            ControlsScreen.class,
            KeyBindsScreen.class,
            AccessibilityOptionsScreen.class,
            ChatOptionsScreen.class,
            FontOptionsScreen.class,
            InWorldGameRulesScreen.class,
            LanguageSelectScreen.class,
            MouseSettingsScreen.class,
            OnlineOptionsScreen.class,
            OptionsScreen.class,
            SkinCustomizationScreen.class,
            SoundOptionsScreen.class,
            VideoSettingsScreen.class,
            WorldOptionsScreen.class,
    };

    @Shadow public int width;
    @Shadow public int height;

    @Shadow @Final @Nullable
    protected Minecraft minecraft;

    @Shadow
    protected abstract void extractMenuBackground(GuiGraphicsExtractor graphics);

    @Unique
    private boolean timeless$shouldRenderDirtBackground;

    @Inject(
            method = "extractBackground",
            at = @At("HEAD"),
            cancellable = true
    )
    private void timeless$extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldScreenBackground) {
            return;
        }

        if (this.minecraft.level == null) {
            timeless$renderDirtBackground(graphics);
        } else {
            if (this.timeless$shouldRenderDirtBackground) {
                timeless$renderDirtBackground(graphics);
            } else {
                extractMenuBackground(graphics);
            }
        }

        ci.cancel();
    }

    @Inject(
            method = "<init>(Lnet/minecraft/network/chat/Component;)V",
            at = @At("TAIL")
    )
    private void timeless$init(Component title, CallbackInfo ci) {
        Class<?> superClass = ((Screen) (Object) this).getClass();

        if (superClass == ControlsScreen.class) {
            this.timeless$shouldRenderDirtBackground = false;
        } else {
            this.timeless$shouldRenderDirtBackground = Arrays.stream(timeless$DIRT_BACKGROUND_CLASSES).anyMatch(clazz -> clazz.isAssignableFrom(superClass));
        }
    }

    @Unique
    private void timeless$renderDirtBackground(GuiGraphicsExtractor graphics) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, timeless$OPTIONS_BACKGROUND_TEXTURE, 0, 0, 0.0f, 0.0f, this.width, this.height, 32, 32, ARGB.color(255, 64, 64, 64));
    }
}
