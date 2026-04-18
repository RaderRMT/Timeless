package fr.rader.timeless.features.oldworldmenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.TextAlignment;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.PresetEditor;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;

import java.util.ArrayList;
import java.util.List;

import static fr.rader.timeless.features.oldworldmenu.Constants.*;

public class MoreWorldOptionsComponent {

    private MultiLineLabel amplifiedWorldInfo;

    private EditBox seedField;

    private CycleButton<Boolean> generateStructuresButton;

    private CycleButton<WorldCreationUiState.WorldTypeEntry> worldTypeButton;
    private Button customizeWorldButton;

    private CycleButton<Boolean> bonusChestButton;

    private WorldCreationUiState uiState;
    private Font font;
    private int halfWidth;

    public MoreWorldOptionsComponent() {
        this.amplifiedWorldInfo = MultiLineLabel.EMPTY;
    }

    public List<AbstractWidget> init(CreateWorldScreen createWorldScreen, Font font) {
        this.uiState = createWorldScreen.getUiState();
        this.font = font;
        this.halfWidth = createWorldScreen.width / 2;

        List<AbstractWidget> elements = new ArrayList<>();

        this.seedField = new EditBox(font, this.halfWidth - 100, 60, 200, 20, SEED_LABEL);
        this.seedField.setValue(this.uiState.getSeed());
        this.seedField.setResponder(this.uiState::setSeed);

        int leftColumnX = this.halfWidth - 155;
        int rightColumnX = this.halfWidth + 5;

        this.generateStructuresButton = CycleButton.onOffBuilder(this.uiState.isGenerateStructures())
                .create(leftColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, GENERATE_STRUCTURES_TEXT, (button, shouldGenerateStructures) -> {
                    this.uiState.setGenerateStructures(shouldGenerateStructures);
                });

        this.worldTypeButton = CycleButton.builder(WorldCreationUiState.WorldTypeEntry::describePreset, this.uiState.getWorldType())
                .withValues(getWorldTypes())
                .create(rightColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, WORLD_TYPE_TEXT, (button, worldType) -> {
                    this.uiState.setWorldType(worldType);
                });

        this.worldTypeButton.setValue(this.uiState.getWorldType());

        this.amplifiedWorldInfo = MultiLineLabel.create(font, AMPLIFIED_INFO_TEXT, this.worldTypeButton.getWidth());

        this.customizeWorldButton = Button.builder(CUSTOMIZE_TEXT, (button) -> {
                    PresetEditor editor = this.uiState.getPresetEditor();
                    if (editor != null) {
                        Minecraft.getInstance().setScreen(
                                editor.createEditScreen(
                                        createWorldScreen,
                                        this.uiState.getSettings()
                                )
                        );
                    }
                })
                .bounds(rightColumnX, 120, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        this.bonusChestButton = CycleButton.onOffBuilder(this.uiState.isBonusChest())
                .create(leftColumnX, 151, BUTTON_WIDTH, BUTTON_HEIGHT, BONUS_CHEST_TEXT, (button, bonusChestEnabled) -> {
                    this.uiState.setBonusChest(bonusChestEnabled);
                });

        elements.add(this.seedField);
        elements.add(this.generateStructuresButton);
        elements.add(this.worldTypeButton);
        elements.add(this.customizeWorldButton);
        elements.add(this.bonusChestButton);

        return elements;
    }


    public boolean isDebug() {
        return this.uiState.isDebug();
    }

    public void setVisibility(boolean visible) {
        if (isDebug()) {
            this.generateStructuresButton.visible = false;
            this.bonusChestButton.visible = false;
            this.customizeWorldButton.visible = false;
        } else {
            this.generateStructuresButton.visible = visible;
            this.bonusChestButton.visible = visible;
            this.customizeWorldButton.visible = visible;
        }

        this.worldTypeButton.visible = visible;
        this.seedField.setVisible(visible);
    }

    public void render(GuiGraphicsExtractor graphics) {
        boolean isDebug = isDebug();

        if (!isDebug) {
            graphics.text(this.font, GENERATE_STRUCTURES_INFO_TEXT, this.halfWidth - 150, 122, Constants.getTextColor());
        }

        if (this.uiState.getWorldType().isAmplified()) {
            this.amplifiedWorldInfo.visitLines(TextAlignment.LEFT, this.worldTypeButton.getX() + 2, this.worldTypeButton.getY() + 22, 9, graphics.textRenderer());
        }

        this.generateStructuresButton.visible = !isDebug;
        this.bonusChestButton.visible = !isDebug;
        this.customizeWorldButton.visible = !isDebug && this.uiState.getPresetEditor() != null;
    }

    private CycleButton.ValueListSupplier<WorldCreationUiState.WorldTypeEntry> getWorldTypes() {
        return new CycleButton.ValueListSupplier<>() {

            @Override
            public List<WorldCreationUiState.WorldTypeEntry> getSelectedList() {
                if (CycleButton.DEFAULT_ALT_LIST_SELECTOR.getAsBoolean()) {
                    return uiState.getAltPresetList();
                }

                return getDefaultList();
            }

            @Override
            public List<WorldCreationUiState.WorldTypeEntry> getDefaultList() {
                return uiState.getNormalPresetList();
            }
        };
    }
}
