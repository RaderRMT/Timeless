package fr.rader.timeless.mixin.icons;

import com.mojang.blaze3d.platform.IconSet;
import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.icons.IconSupplier;
import net.minecraft.server.packs.PackMetadataResources;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.resources.IoSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.InputStream;
import java.util.List;

@Mixin(IconSet.class)
public abstract class MixinIconSet {

    @Inject(
            method = "getStandardIcons",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getStandardIcons(PackMetadataResources resources, CallbackInfoReturnable<List<IoSupplier<InputStream>>> cir) {
        if (!TimelessConfig.get().useOldWindowIcons) {
            return;
        }

        List<IoSupplier<InputStream>> icons = List.of(
                IconSupplier.getIcon("icon_16x16.png"),
                IconSupplier.getIcon("icon_32x32.png")
        );

        cir.setReturnValue(icons);
    }

    @Inject(
            method = "getMacIcon",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getMacIcon(PackMetadataResources resources, CallbackInfoReturnable<IoSupplier<InputStream>> cir) {
        if (!TimelessConfig.get().useOldWindowIcons) {
            return;
        }

        cir.setReturnValue(IconSupplier.getIcon("minecraft.icns"));
    }
}
