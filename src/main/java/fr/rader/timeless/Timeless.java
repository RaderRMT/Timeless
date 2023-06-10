package fr.rader.timeless;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class Timeless implements ClientModInitializer {

    private static TimelessConfig config;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(TimelessConfig.class, GsonConfigSerializer::new);

        Timeless.config = AutoConfig.getConfigHolder(TimelessConfig.class).getConfig();
    }

    public static TimelessConfig getConfig() {
        return config;
    }
}
