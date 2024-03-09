package fr.rader.timeless;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class Timeless implements ClientModInitializer {

    private static TimelessConfig config;

    @Override
    public void onInitializeClient() {
    }

    public static TimelessConfig getConfig() {
        if (Timeless.config == null) {
            AutoConfig.register(TimelessConfig.class, GsonConfigSerializer::new);

            Timeless.config = AutoConfig.getConfigHolder(TimelessConfig.class).getConfig();
        }

        return Timeless.config;
    }
}
