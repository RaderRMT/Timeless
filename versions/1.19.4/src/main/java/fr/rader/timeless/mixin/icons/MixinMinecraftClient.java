package fr.rader.timeless.mixin.icons;

import fr.rader.timeless.features.icons.IconSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.InputSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.IOException;
import java.io.InputStream;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient {

    @Shadow
    protected abstract InputSupplier<InputStream> getDefaultResourceSupplier(String... segments) throws IOException;

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/MinecraftClient;getDefaultResourceSupplier([Ljava/lang/String;)Lnet/minecraft/resource/InputSupplier;"
            )
    )
    public InputSupplier<InputStream> timeless$onGetDefaultResourceSupplier(MinecraftClient instance, String[] segments) throws IOException {
        if (!segments[0].equals("icons")) {
            return getDefaultResourceSupplier(segments);
        }

        return IconSupplier.getIcon(segments[1]);
    }
}
