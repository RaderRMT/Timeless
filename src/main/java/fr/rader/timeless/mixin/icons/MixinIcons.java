package fr.rader.timeless.mixin.icons;

import fr.rader.timeless.Timeless;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

@Mixin(Icons.class)
public abstract class MixinIcons {

    private static final String ICON_PATH = "/assets/timeless/icons/";

    @Inject(
            method = "getIcons",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getIcons(ResourcePack resourcePack, CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir) {
        if (!Timeless.getConfig().useOldIcons) {
            return;
        }

        List<InputSupplier<InputStream>> icons = List.of(
                getIcon("icon_16x16.png"),
                getIcon("icon_32x32.png")
        );

        cir.setReturnValue(icons);
    }

    @Inject(
            method = "getMacIcon",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getMacIcon(ResourcePack resourcePack, CallbackInfoReturnable<InputSupplier<InputStream>> cir) {
        if (!Timeless.getConfig().useOldIcons) {
            return;
        }

        cir.setReturnValue(getIcon("minecraft.icns"));
    }

    private InputSupplier<InputStream> getIcon(String path) {
        try {
            String iconPath = ICON_PATH + path;

            URL iconURL = Timeless.class.getResource(iconPath);
            if (iconURL == null) {
                throw new FileNotFoundException(iconPath);
            }

            return InputSupplier.create(Path.of(iconURL.toURI()));
        } catch (URISyntaxException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
