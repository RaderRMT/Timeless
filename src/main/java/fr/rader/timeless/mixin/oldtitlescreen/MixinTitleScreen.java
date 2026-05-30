package fr.rader.timeless.mixin.oldtitlescreen;

import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.CreditsAndAttributionScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.friends.FriendsOverlayScreen;
import net.minecraft.client.gui.screens.options.AccessibilityOptionsScreen;
import net.minecraft.client.gui.screens.options.LanguageSelectScreen;
import net.minecraft.client.gui.screens.options.OnlineOptionsScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {

    @Shadow
    private @Nullable SplashRenderer splash;

    @Shadow
    @Final
    private static Component COPYRIGHT_TEXT;

    @Shadow
    protected abstract int createDemoMenuOptions(int topPos, int spacing);

    @Shadow
    protected abstract int createNormalMenuOptions(int topPos, int spacing);

    @Shadow
    protected abstract boolean realmsNotificationsEnabled();

    @Shadow
    private @Nullable RealmsNotificationsScreen realmsNotificationsScreen;

    @Shadow
    private @Nullable FriendsButton friends;

    protected MixinTitleScreen(final Component title) {
        super(title);
    }

    @Inject(
            method = "init",
            at = @At("HEAD"),
            cancellable = true
    )
    private void timeless$init(CallbackInfo ci) {
        if (!TimelessConfig.get().restoreOldTitleScreen) {
            return;
        }

        if (this.splash == null) {
            this.splash = this.minecraft.gui.splashManager().getSplash();
        }

        final int spacing = 24;
        int topPosition = this.height / 4 + 48;

        timeless$addFriendsButton(topPosition + spacing);

        if (this.minecraft.isDemo()) {
            topPosition = createDemoMenuOptions(topPosition, spacing);
        } else {
            topPosition = createNormalMenuOptions(topPosition, spacing);
        }

        topPosition += 36;
        timeless$addOptionsAndQuitButtons(topPosition);
        timeless$addAccessibilityButton(topPosition);
        timeless$addLanguageButton(topPosition);

        if (this.realmsNotificationsScreen == null) {
            this.realmsNotificationsScreen = new RealmsNotificationsScreen();
        }

        if (this.realmsNotificationsEnabled()) {
            this.realmsNotificationsScreen.init(this.width, this.height);
        }

        timeless$addCopyrightText();

        ci.cancel();
    }

    @Unique
    private void timeless$addFriendsButton(final int topPosition) {
        this.friends = this.addRenderableWidget(
                CommonButtons.friends(
                        20,
                        _ -> OnlineOptionsScreen.confirmFriendsListEnabled(this.minecraft, () -> this.minecraft.gui.setScreen(new FriendsOverlayScreen(this)),
                        this
                )
                )
        );

        this.friends.setPosition(this.width / 2 - 124, topPosition);
    }

    @Unique
    private void timeless$addLanguageButton(final int topPosition) {
        final SpriteIconButton language = this.addRenderableWidget(
                CommonButtons.language(
                        20,
                        _ -> this.minecraft.gui.setScreen(new LanguageSelectScreen(this, this.minecraft.options, this.minecraft.getLanguageManager())),
                        true
                )
        );

        language.setPosition(this.width / 2 - 124, topPosition);
    }

    @Unique
    private void timeless$addAccessibilityButton(final int topPosition) {
        final SpriteIconButton accessibility = this.addRenderableWidget(
                CommonButtons.accessibility(
                        20,
                        _ -> this.minecraft.gui.setScreen(new AccessibilityOptionsScreen(this, this.minecraft.options)),
                        true
                )
        );

        accessibility.setPosition(this.width / 2 + 104, topPosition);
    }

    @Unique
    private void timeless$addOptionsAndQuitButtons(final int topPosition) {
        this.addRenderableWidget(
                Button.builder(
                        Component.translatable("menu.options"),
                        _ -> this.minecraft.gui.setScreen(new OptionsScreen(this, this.minecraft.options, false))
                )
                .bounds(this.width / 2 - 100, topPosition, 98, 20)
                .build()
        );

        this.addRenderableWidget(
                Button.builder(
                        Component.translatable("menu.quit"),
                        _ -> this.minecraft.stop()
                )
                .bounds(this.width / 2 + 2, topPosition, 98, 20)
                .build()
        );
    }

    @Unique
    private void timeless$addCopyrightText() {
        final int copyrightWidth = this.font.width(COPYRIGHT_TEXT);
        final int copyrightXPosition = this.width - copyrightWidth - 2;

        this.addRenderableWidget(
                new PlainTextButton(
                        copyrightXPosition,
                        this.height - 10,
                        copyrightWidth,
                        10,
                        COPYRIGHT_TEXT,
                        _ -> this.minecraft.gui.setScreen(new CreditsAndAttributionScreen(this)),
                        this.font
                )
        );
    }
}
