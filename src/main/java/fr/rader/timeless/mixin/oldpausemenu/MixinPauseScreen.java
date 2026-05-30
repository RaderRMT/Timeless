package fr.rader.timeless.mixin.oldpausemenu;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.SharedConstants;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LayoutSettings;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonLinks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PauseScreen.class)
public abstract class MixinPauseScreen extends Screen {

    @Shadow
    @Final
    private static Component REPORT_BUGS;

    @Shadow
    @Final
    private static Component SEND_FEEDBACK;

    protected MixinPauseScreen(final Component title) {
        super(title);
    }

    @Redirect(
            method = "createPauseMenu",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;ILnet/minecraft/client/gui/layouts/LayoutSettings;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 1
            )
    )
    public <T extends LayoutElement> T timeless$addChild$addChild(final GridLayout.RowHelper instance, final T widget, final int columnWidth, final LayoutSettings layoutSettings) {
        if (!TimelessConfig.get().restoreOldPauseScreen) {
            return instance.addChild(widget, columnWidth, layoutSettings);
        }

        final Button feedbackButton = Button.builder(
                        SEND_FEEDBACK,
                        ConfirmLinkScreen.confirmLink(this, SharedConstants.getCurrentVersion().stable() ? CommonLinks.RELEASE_FEEDBACK : CommonLinks.SNAPSHOT_FEEDBACK)
                )
                .width(98)
                .build();

        final Button reportBugsButton = Button.builder(
                        REPORT_BUGS,
                        ConfirmLinkScreen.confirmLink(this, CommonLinks.SNAPSHOT_BUGS_FEEDBACK)
                )
                .width(98)
                .build();

        reportBugsButton.active = !SharedConstants.getCurrentVersion().dataVersion().isSideSeries();

        instance.addChild(feedbackButton);
        instance.addChild(reportBugsButton);
        return null;
    }
}
