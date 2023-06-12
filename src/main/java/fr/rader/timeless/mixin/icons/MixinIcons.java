package fr.rader.timeless.mixin.icons;

import fr.rader.timeless.Timeless;
import fr.rader.timeless.features.icons.IconSupplier;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.InputStream;
import java.util.List;

@Mixin(Icons.class)
public abstract class MixinIcons {

    @Inject(
            method = "getIcons",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getIcons(ResourcePack resourcePack, CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir) {
        if (!Timeless.getConfig().useOldWindowIcons) {
            return;
        }

        List<InputSupplier<InputStream>> icons = List.of(
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
    public void getMacIcon(ResourcePack resourcePack, CallbackInfoReturnable<InputSupplier<InputStream>> cir) {
        if (!Timeless.getConfig().useOldWindowIcons) {
            return;
        }

        cir.setReturnValue(IconSupplier.getIcon("minecraft.icns"));
    }
}
