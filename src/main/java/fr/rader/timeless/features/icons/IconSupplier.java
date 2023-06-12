package fr.rader.timeless.features.icons;

import fr.rader.timeless.Timeless;
import net.minecraft.resource.InputSupplier;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class IconSupplier {

    private static final String ICON_PATH = "/assets/timeless/icons/";

    public static InputSupplier<InputStream> getIcon(String path) {
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
