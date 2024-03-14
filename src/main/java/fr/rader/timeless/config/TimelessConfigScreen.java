package fr.rader.timeless.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

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
                .setTitle(Text.translatable("text.modmenu.timeless.title"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory general = builder.getOrCreateCategory(Text.literal("1.19.4+"));

        general.addEntry(createBooleanEntry(entryBuilder, "useOldWorldMenu", true, config.useOldWorldMenu, value -> config.useOldWorldMenu = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "disableHitDirection", true, config.disableHitDirection, value -> config.disableHitDirection = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "doPistonClunk", true, config.doPistonClunk, value -> config.doPistonClunk = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "skeletonShootPurpleArrow", true, config.skeletonShootPurpleArrow, value -> config.skeletonShootPurpleArrow = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "useOldInventoryLayout", true, config.useOldInventoryLayout, value -> config.useOldInventoryLayout = value).requireRestart().build());
        general.addEntry(createBooleanEntry(entryBuilder, "enablePotionGlint", true, config.enablePotionGlint, value -> config.enablePotionGlint = value).build());
        general.addEntry(createBooleanEntry(entryBuilder, "useOldPotionColors", true, config.useOldPotionColors, value -> config.useOldPotionColors = value).build());

        //#if MC>=12001
        ConfigCategory mc12001 = builder.getOrCreateCategory(Text.literal("1.20.1+"));
        mc12001.addEntry(createBooleanEntry(entryBuilder, "useOldWindowIcons", true, config.useOldWindowIcons, value -> config.useOldWindowIcons = value).requireRestart().build());
        //#endif

        //#if MC>=12004
        ConfigCategory mc12004 = builder.getOrCreateCategory(Text.literal("1.20.4+"));
        mc12004.addEntry(createBooleanEntry(entryBuilder, "useOldBatModel", true, config.useOldBatModel, value -> {
            if (config.useOldBatModel != value) {
                MinecraftClient.getInstance().reloadResources();
            }

            config.useOldBatModel = value;
        }).build());
        //#endif

        builder.setSavingRunnable(config::write);

        return builder.build();
    }

    private BooleanToggleBuilder createBooleanEntry(ConfigEntryBuilder entryBuilder, String configName, boolean defaultValue, boolean currentValue, Consumer<Boolean> onSave) {
        return entryBuilder.startBooleanToggle(Text.translatable("timeless.config.name." + configName), currentValue)
                .setDefaultValue(defaultValue)
                .setTooltip(Text.translatable("timeless.config.description." + configName))
                .setSaveConsumer(onSave);
    }
}
