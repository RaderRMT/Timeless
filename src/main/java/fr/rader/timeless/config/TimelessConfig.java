package fr.rader.timeless.config;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TimelessConfig {

    private static final File CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("timeless.json").toFile();

    private static TimelessConfig instance;
    private static Gson gson;

    public boolean useOldWorldMenu = true;
    public boolean disableHitDirection = true;
    public boolean doPistonClunk = true;
    public boolean skeletonShootPurpleArrow = true;
    public boolean useOldInventoryLayout = true;
    public boolean enablePotionGlint = true;
    public boolean useOldPotionColors = true;
    //#if MC>=12001
    public boolean useOldWindowIcons = true;
    //#endif
    //#if MC>=12004
    public boolean useOldBatModel = true;
    //#endif

    public void write() {
        try (FileWriter writer = new FileWriter(TimelessConfig.CONFIG_PATH)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            throw new RuntimeException("Could not write Timeless config file", e);
        }
    }

    public static TimelessConfig get() {
        if (instance == null) {
            gson = new Gson();

            if (!TimelessConfig.CONFIG_PATH.exists()) {
                instance = new TimelessConfig();
                instance.write();
            } else {
                try (FileReader reader = new FileReader(TimelessConfig.CONFIG_PATH)) {
                    instance = gson.fromJson(reader, TimelessConfig.class);
                } catch (IOException e) {
                    throw new RuntimeException("Could not read Timeless config file", e);
                }
            }
        }

        return instance;
    }
}
