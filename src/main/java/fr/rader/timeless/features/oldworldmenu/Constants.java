package fr.rader.timeless.features.oldworldmenu;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ARGB;

public class Constants {

    public static final int GRAY_COLOR = ARGB.color(0xFF, 0xA0, 0xA0, 0xA0);
    public static final int WHITE_COLOR = ARGB.color(0xFF, 0xFF, 0xFF, 0xFF);
    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 20;

    public static int getTextColor() {
        if (TimelessConfig.get().useOldScreenBackground) {
            return GRAY_COLOR;
        }

        return WHITE_COLOR;
    }

    public static final Component WORLD_NAME_LABEL = Component.translatable("selectWorld.enterName");
    public static final Component WORLD_DIRECTORY_NAME_LABEL = Component.translatable("timeless.selectWorld.resultFolder");
    public static final Component GAME_MODE_LABEL = Component.translatable("selectWorld.gameMode");
    public static final Component ALLOW_CHEATS_TEXT = Component.translatable("selectWorld.allowCommands");
    public static final Component ALLOW_CHEATS_INFO_LABEL = Component.translatable("selectWorld.allowCommands.info");
    public static final Component SEED_LABEL = Component.translatable("selectWorld.enterSeed");
    public static final Component SEED_INFO_LABEL = Component.translatable("selectWorld.seedInfo");

    public static final Component DIFFICULTY_TEXT = Component.translatable("options.difficulty");
    public static final Component DATA_PACKS_TEXT = Component.translatable("selectWorld.dataPacks");
    public static final Component GAME_RULES_TEXT = Component.translatable("selectWorld.gameRules");
    public static final Component MORE_WORLD_OPTIONS_TEXT = Component.translatable("timeless.selectWorld.moreWorldOptions");
    public static final Component DONE_TEXT = Component.translatable("gui.done");
    public static final Component CREATE_NEW_WORLD_TEXT = Component.translatable("selectWorld.create");
    public static final Component CANCEL_TEXT = Component.translatable("gui.cancel");

    public static final Component GENERATE_STRUCTURES_TEXT = Component.translatable("selectWorld.mapFeatures");
    public static final Component GENERATE_STRUCTURES_INFO_TEXT = Component.translatable("selectWorld.mapFeatures.info");
    public static final Component WORLD_TYPE_TEXT = Component.translatable("selectWorld.mapType");
    public static final Component BONUS_CHEST_TEXT = Component.translatable("selectWorld.bonusItems");
    public static final Component CUSTOMIZE_TEXT = Component.translatable("selectWorld.customizeType");

    public static final Component AMPLIFIED_INFO_TEXT = Component.translatable("generator.minecraft.amplified.info").withColor(getTextColor());
}
