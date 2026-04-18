package fr.rader.timeless.mixin.oldworldmenu;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.oldworldmenu.Constants;
import fr.rader.timeless.features.oldworldmenu.MoreWorldOptionsComponent;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationGameRulesScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.WorldDataConfiguration;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static fr.rader.timeless.features.oldworldmenu.Constants.*;

@Mixin(CreateWorldScreen.class)
public abstract class MixinCreateWorldScreen extends Screen {

    @Shadow
    protected abstract void openDataPackSelectionScreen(WorldDataConfiguration dataConfiguration);

    @Shadow
    protected abstract void onCreate();

    @Shadow @Final
    private WorldCreationUiState uiState;

    @Shadow
    public abstract void popScreen();

    @Unique private MoreWorldOptionsComponent timeless$moreWorldOptionsComponent;
    @Unique private boolean timeless$isWorldOptionsToggled;

    @Unique private EditBox timeless$worldName;
    @Unique private Component timeless$worldDirectoryName;

    @Unique private CycleButton<WorldCreationUiState.SelectedGameMode> timeless$gameModeButton;
    @Unique private WorldCreationUiState.SelectedGameMode timeless$nonDebugGameMode;
    @Unique private Component timeless$gameModeHelp1;
    @Unique private Component timeless$gameModeHelp2;

    @Unique private CycleButton<Difficulty> timeless$difficultyButton;
    @Unique private CycleButton<Boolean> timeless$allowCheatsButton;

    @Unique private Button timeless$dataPacksButton;
    @Unique private Button timeless$gameRulesButton;
    @Unique private Button timeless$moreWorldOptionsButton;

    @Unique private int timeless$halfWidth;

    protected MixinCreateWorldScreen(Component title) {
        super(title);

        this.timeless$isWorldOptionsToggled = false;
    }

    @Inject(
            // todo: not too sure about this:
            method = "extractMenuBackground",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$extractMenuBackground(GuiGraphicsExtractor graphics, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        ci.cancel();
    }

    @Inject(
            method = "extractRenderState",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.centeredText(this.font, this.title, this.timeless$halfWidth, 20, -1);

        int textPositionX = this.timeless$halfWidth - 100;
        if (this.timeless$isWorldOptionsToggled) {
            graphics.text(this.font, SEED_LABEL, textPositionX, 47, Constants.getTextColor());
            graphics.text(this.font, SEED_INFO_LABEL, textPositionX, 85, Constants.getTextColor());

            this.timeless$moreWorldOptionsComponent.render(graphics);
        } else {
            graphics.text(this.font, WORLD_NAME_LABEL, textPositionX, 47, Constants.getTextColor());
            graphics.text(this.font, this.timeless$worldDirectoryName, textPositionX, 85, Constants.getTextColor());

            textPositionX -= 50;
            graphics.text(this.font, this.timeless$gameModeHelp1, textPositionX, 122, Constants.getTextColor());
            graphics.text(this.font, this.timeless$gameModeHelp2, textPositionX, 134, Constants.getTextColor());

            if (!this.uiState.isDebug()) {
                graphics.text(this.font, ALLOW_CHEATS_INFO_LABEL, textPositionX, 172, Constants.getTextColor());
            }
        }

        ci.cancel();
    }

    @Inject(
            method = "init",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$init(CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        this.timeless$moreWorldOptionsComponent = new MoreWorldOptionsComponent();
        this.timeless$halfWidth = this.width / 2;

        this.timeless$worldName = new EditBox(this.font, this.timeless$halfWidth - 100, 60, 200, 20, WORLD_NAME_LABEL);
        this.timeless$worldName.setValue(this.uiState.getName());
        this.timeless$worldName.setResponder(this::timeless$setWorldName);

        int leftColumnX = this.timeless$halfWidth - 155;
        int rightColumnX = this.timeless$halfWidth + 5;

        this.timeless$gameModeButton = CycleButton.<WorldCreationUiState.SelectedGameMode>builder(value -> value.displayName, this.uiState.getGameMode())
                .withValues(List.of(
                        WorldCreationUiState.SelectedGameMode.SURVIVAL,
                        WorldCreationUiState.SelectedGameMode.HARDCORE,
                        WorldCreationUiState.SelectedGameMode.CREATIVE
                ))
                .create(leftColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, GAME_MODE_LABEL, (button, gameMode) -> {
                    timeless$setGameMode(gameMode);
                });

        this.timeless$gameModeButton.setValue(this.uiState.getGameMode());
        this.uiState.addListener(creator -> {
            this.timeless$gameModeButton.setValue(this.uiState.getGameMode());
            this.timeless$gameModeButton.active = !this.uiState.isDebug();
        });

        this.timeless$difficultyButton = CycleButton.builder(Difficulty::getDisplayName, this.uiState.getDifficulty())
                .withValues(Difficulty.values())
                .create(rightColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, DIFFICULTY_TEXT, (button, difficulty) -> {
                    this.uiState.setDifficulty(difficulty);
                });
        this.timeless$difficultyButton.setValue(this.uiState.getDifficulty());
        this.uiState.addListener(creator -> {
            this.timeless$difficultyButton.setValue(this.uiState.getDifficulty());
            this.timeless$difficultyButton.active = !this.uiState.isHardcore();
        });

        this.timeless$allowCheatsButton = CycleButton.onOffBuilder(this.uiState.isAllowCommands())
                .create(leftColumnX, 151, BUTTON_WIDTH, BUTTON_HEIGHT, ALLOW_CHEATS_TEXT, (button, allowCheats) -> {
                    this.uiState.setAllowCommands(allowCheats);
                });
        this.uiState.addListener(creator -> {
            this.timeless$allowCheatsButton.setValue(this.uiState.isAllowCommands());
            this.timeless$allowCheatsButton.active = !this.uiState.isDebug() && !this.uiState.isHardcore();
        });

        this.timeless$dataPacksButton = Button.builder(DATA_PACKS_TEXT, button -> {
                    openDataPackSelectionScreen(this.uiState.getSettings().dataConfiguration());
                })
                .bounds(rightColumnX, 151, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        this.timeless$gameRulesButton = Button.builder(GAME_RULES_TEXT, button -> {
                    this.minecraft.setScreenAndShow(new WorldCreationGameRulesScreen(
                            this.uiState.getGameRules().copy(this.uiState.getSettings().dataConfiguration().enabledFeatures()), optional -> {
                                    this.minecraft.setScreenAndShow(this);
                                    optional.ifPresent(this.uiState::setGameRules);
                            }
                    ));
                })
                .bounds(leftColumnX, 185, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        this.timeless$moreWorldOptionsButton = Button.builder(MORE_WORLD_OPTIONS_TEXT, button -> timeless$toggleWorldOptionsVisibility())
                .bounds(rightColumnX, 185, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        Button createNewWorldButton = Button.builder(CREATE_NEW_WORLD_TEXT, button -> onCreate())
                .bounds(leftColumnX, this.height - 28, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        Button cancelButton = Button.builder(CANCEL_TEXT, button -> popScreen())
                .bounds(rightColumnX, this.height - 28, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        List<AbstractWidget> moreWorldOptionsElements = this.timeless$moreWorldOptionsComponent.init(
                (CreateWorldScreen) (Object) this,
                this.font
        );

        addRenderableWidget(this.timeless$worldName);
        addRenderableWidget(this.timeless$gameModeButton);
        addRenderableWidget(this.timeless$difficultyButton);
        addRenderableWidget(this.timeless$allowCheatsButton);
        addRenderableWidget(this.timeless$dataPacksButton);
        addRenderableWidget(this.timeless$gameRulesButton);
        addRenderableWidget(this.timeless$moreWorldOptionsButton);

        addRenderableWidget(createNewWorldButton);
        addRenderableWidget(cancelButton);

        moreWorldOptionsElements.forEach(this::addRenderableWidget);

        timeless$updateWorldOptionsVisibility();
        setInitialFocus(this.timeless$worldName);

        this.uiState.onChanged();
        timeless$updateGameModeHelp(this.uiState.getGameMode());
        timeless$updateWorldDirectoryName();

        ci.cancel();
    }

    @Inject(
            method = "repositionElements",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$repositionElements(CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        super.repositionElements();
        ci.cancel();
    }

    @Inject(
            method = "keyPressed",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$keyPressed(KeyEvent input, CallbackInfoReturnable<Boolean> cir) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        cir.setReturnValue(super.keyPressed(input));
        cir.cancel();
    }

    @Unique
    private void timeless$setWorldName(String newWorldName) {
        this.uiState.setName(newWorldName);

        timeless$updateWorldDirectoryName();
    }

    @Unique
    private void timeless$updateWorldDirectoryName() {
        this.timeless$worldDirectoryName = Component.empty()
                .append(WORLD_DIRECTORY_NAME_LABEL)
                .append(" ")
                .append(this.uiState.getTargetFolder());
    }

    @Unique
    private void timeless$setGameMode(WorldCreationUiState.SelectedGameMode gameMode) {
        this.uiState.setGameMode(gameMode);

        timeless$updateGameModeHelp(gameMode);
    }

    @Unique
    private void timeless$updateGameModeHelp(WorldCreationUiState.SelectedGameMode gameMode) {
        String gameModeName = gameMode.name().toLowerCase();
        if (gameModeName.equals("debug")) {
            gameModeName = "spectator";
        }

        this.timeless$gameModeHelp1 = Component.translatable("timeless.selectWorld.gameMode." + gameModeName + ".line1");
        this.timeless$gameModeHelp2 = Component.translatable("timeless.selectWorld.gameMode." + gameModeName + ".line2");
    }

    @Unique
    private void timeless$toggleWorldOptionsVisibility() {
        timeless$setWorldOptionsVisibility(!this.timeless$isWorldOptionsToggled);
    }

    @Unique
    private void timeless$updateWorldOptionsVisibility() {
        timeless$setWorldOptionsVisibility(this.timeless$isWorldOptionsToggled);
    }

    @Unique
    private void timeless$setWorldOptionsVisibility(boolean visible) {
        this.timeless$isWorldOptionsToggled = visible;
        this.timeless$gameModeButton.visible = !visible;
        this.timeless$difficultyButton.visible = !visible;

        if (this.timeless$moreWorldOptionsComponent.isDebug()) {
            this.timeless$dataPacksButton.visible = false;
            this.timeless$gameModeButton.active = false;

            if (this.timeless$nonDebugGameMode == null) {
                this.timeless$nonDebugGameMode = this.timeless$gameModeButton.getValue();
            }

            this.timeless$allowCheatsButton.visible = false;
            timeless$setGameMode(WorldCreationUiState.SelectedGameMode.DEBUG);
        } else {
            this.timeless$gameModeButton.active = true;
            if (this.timeless$nonDebugGameMode != null) {
                timeless$setGameMode(this.timeless$nonDebugGameMode);
            }

            this.timeless$allowCheatsButton.visible = !visible;
            this.timeless$dataPacksButton.visible = !visible;
        }

        this.timeless$moreWorldOptionsComponent.setVisibility(visible);
        this.timeless$worldName.setVisible(!visible);

        if (visible) {
            this.timeless$moreWorldOptionsButton.setMessage(DONE_TEXT);
        } else {
            this.timeless$moreWorldOptionsButton.setMessage(MORE_WORLD_OPTIONS_TEXT);
        }

        this.timeless$gameRulesButton.visible = !visible;
    }
}
