package fr.rader.timeless;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;

public class Timeless implements ClientModInitializer {

    private static TimelessConfig config;

    @Override
    public void onInitializeClient() {
    }

    public static TimelessConfig getConfig() {
        if (Timeless.config == null) {
            AutoConfig.register(TimelessConfig.class, GsonConfigSerializer::new);

            ConfigHolder<TimelessConfig> configHolder = AutoConfig.getConfigHolder(TimelessConfig.class);
            Timeless.config = configHolder.getConfig();

            configHolder.registerSaveListener(Timeless::onConfigSave);
        }

        return Timeless.config;
    }

    private static ActionResult onConfigSave(ConfigHolder<TimelessConfig> holder, TimelessConfig config) {
        if (config.useOldBatModel != config.previousUseOldBatModel) {
            MinecraftClient.getInstance().reloadResources();

            config.previousUseOldBatModel = config.useOldBatModel;
        }

        return ActionResult.SUCCESS;
    }
}
