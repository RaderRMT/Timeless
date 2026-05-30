package fr.rader.timeless.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class TimelessConfigScreen implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::create;
    }

    private Screen create(Screen parentScreen) {
        TimelessConfig config = TimelessConfig.get();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parentScreen)
                .setTitle(Component.translatable("text.modmenu.timeless.title"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));

        general.addEntry(createBooleanEntry(entryBuilder, "useOldWorldMenu", true, config.useOldWorldMenu, value -> config.useOldWorldMenu = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "disableHitDirection", true, config.disableHitDirection, value -> config.disableHitDirection = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "doPistonClunk", true, config.doPistonClunk, value -> config.doPistonClunk = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "skeletonShootPurpleArrow", true, config.skeletonShootPurpleArrow, value -> config.skeletonShootPurpleArrow = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "useOldInventoryLayout", true, config.useOldInventoryLayout, value -> config.useOldInventoryLayout = value).requireRestart().build());
        general.addEntry(createBooleanEntry(entryBuilder, "enablePotionGlint", true, config.enablePotionGlint, value -> config.enablePotionGlint = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "useOldPotionColors", true, config.useOldPotionColors, value -> config.useOldPotionColors = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "useOldWindowIcons", true, config.useOldWindowIcons, value -> config.useOldWindowIcons = value).requireRestart().build());

        general.addEntry(createBooleanEntry(entryBuilder, "useOldBatModel", true, config.useOldBatModel, value -> {
            if (config.useOldBatModel != value) {
                Minecraft.getInstance().reloadResourcePacks();
            }

            config.useOldBatModel = value;
        }).build());

        general.addEntry(createBooleanEntry(entryBuilder, "useOldScreenBackground", true, config.useOldScreenBackground, value -> config.useOldScreenBackground = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "disableEnvironmentalFog", true, config.disableEnvironmentalFog, value -> config.disableEnvironmentalFog = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "restoreOldTitleScreen", true, config.restoreOldTitleScreen, value -> config.restoreOldTitleScreen = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "restoreOldPauseScreen", true, config.restoreOldPauseScreen, value -> config.restoreOldPauseScreen = value).build());

        builder.setSavingRunnable(config::write);

        return builder.build();
    }

    private BooleanToggleBuilder createBooleanEntry(ConfigEntryBuilder entryBuilder, String configName, boolean defaultValue, boolean currentValue, Consumer<Boolean> onSave) {
        return entryBuilder.startBooleanToggle(Component.translatable("timeless.config.name." + configName), currentValue)
                .setDefaultValue(defaultValue)
                .setTooltip(Component.translatable("timeless.config.description." + configName))
                .setSaveConsumer(onSave);
    }
}
