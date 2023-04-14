package fr.rader.timeless;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Timeless implements ModInitializer {

    private static TimelessConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(TimelessConfig.class, GsonConfigSerializer::new);

        Timeless.config = AutoConfig.getConfigHolder(TimelessConfig.class).getConfig();
    }

    public static TimelessConfig getConfig() {
        return config;
    }
}
