package fr.rader.timeless.features.oldworldmenu;

import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;

public class Constants {

    public static final Text WORLD_NAME_LABEL = Text.translatable("selectWorld.enterName");
    public static final Text WORLD_DIRECTORY_NAME_LABEL = Text.translatable("selectWorld.resultFolder");
    public static final Text GAME_MODE_LABEL = Text.translatable("selectWorld.gameMode");
    public static final Text ALLOW_CHEATS_TEXT = Text.translatable("selectWorld.allowCommands");
    public static final Text ALLOW_CHEATS_INFO_LABEL = Text.translatable("selectWorld.allowCommands.info");
    public static final Text SEED_LABEL = Text.translatable("selectWorld.enterSeed");
    public static final Text SEED_INFO_LABEL = Text.translatable("selectWorld.seedInfo");

    public static final Text DIFFICULTY_TEXT = Text.translatable("options.difficulty");
    public static final Text DATA_PACKS_TEXT = Text.translatable("selectWorld.dataPacks");
    public static final Text GAME_RULES_TEXT = Text.translatable("selectWorld.gameRules");
    public static final Text MORE_WORLD_OPTIONS_TEXT = Text.translatable("selectWorld.moreWorldOptions");
    public static final Text DONE_TEXT = Text.translatable("gui.done");
    public static final Text CREATE_NEW_WORLD_TEXT = Text.translatable("selectWorld.create");
    public static final Text CANCEL_TEXT = Text.translatable("gui.cancel");

    public static final Text GENERATE_STRUCTURES_TEXT = Text.translatable("selectWorld.mapFeatures");
    public static final Text GENERATE_STRUCTURES_INFO_TEXT = Text.translatable("selectWorld.mapFeatures.info");
    public static final Text WORLD_TYPE_TEXT = Text.translatable("selectWorld.mapType");
    public static final Text BONUS_CHEST_TEXT = Text.translatable("selectWorld.bonusItems");
    public static final Text CUSTOMIZE_TEXT = Text.translatable("selectWorld.customizeType");
    public static final Text AMPLIFIED_INFO_TEXT = Text.translatable("generator.minecraft.amplified.info");

    public static final int GRAY_COLOR = ColorHelper.Argb.getArgb(0xFF, 0xA0, 0xA0, 0xA0);
    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 20;
}
