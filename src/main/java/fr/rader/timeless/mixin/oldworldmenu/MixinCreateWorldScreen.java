package fr.rader.timeless.mixin.oldworldmenu;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.oldworldmenu.MoreWorldOptionsComponent;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.EditGameRulesScreen;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.resource.DataConfiguration;
import net.minecraft.text.Text;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//#if MC<=11904
//$$ import net.minecraft.client.util.math.MatrixStack;
//#endif

import java.util.List;

import static fr.rader.timeless.features.oldworldmenu.Constants.*;

@Mixin(CreateWorldScreen.class)
public abstract class MixinCreateWorldScreen extends Screen {

    @Shadow
    abstract void openPackScreen(DataConfiguration dataConfiguration);
    @Shadow
    protected abstract void createLevel();

    @Shadow
    @Final
    WorldCreator worldCreator;

    @Unique private MoreWorldOptionsComponent moreWorldOptionsComponent;
    @Unique private boolean isWorldOptionsToggled;

    @Unique private TextFieldWidget worldName;
    @Unique private Text worldDirectoryName;

    @Unique private CyclingButtonWidget<WorldCreator.Mode> gameModeButton;
    @Unique private WorldCreator.Mode nonDebugGameMode;
    @Unique private Text gameModeHelp1;
    @Unique private Text gameModeHelp2;

    @Unique private CyclingButtonWidget<Difficulty> difficultyButton;
    @Unique private CyclingButtonWidget<Boolean> allowCheatsButton;

    @Unique private ButtonWidget dataPacksButton;
    @Unique private ButtonWidget gameRulesButton;
    @Unique private ButtonWidget moreWorldOptionsButton;

    @Unique private int halfWidth;

    protected MixinCreateWorldScreen(Text title) {
        super(title);

        this.isWorldOptionsToggled = false;
    }

    @Inject(
            method = "render",
            at = @At("HEAD"),
            cancellable = true
    )
    //#if MC>=12000
    public void timeless$render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        //#if MC>=12002
        renderBackground(context, mouseX, mouseY, delta);
        //#else
        //$$ renderBackground(context);
        //#endif

        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.halfWidth, 20, -1);

        int textPositionX = this.halfWidth - 100;
        if (this.isWorldOptionsToggled) {
            context.drawTextWithShadow(this.textRenderer, SEED_LABEL, textPositionX, 47, GRAY_COLOR);
            context.drawTextWithShadow(this.textRenderer, SEED_INFO_LABEL, textPositionX, 85, GRAY_COLOR);

            this.moreWorldOptionsComponent.render(context);
        } else {
            context.drawTextWithShadow(this.textRenderer, WORLD_NAME_LABEL, textPositionX, 47, GRAY_COLOR);
            context.drawTextWithShadow(this.textRenderer, this.worldDirectoryName, textPositionX, 85, GRAY_COLOR);

            textPositionX -= 50;
            context.drawTextWithShadow(this.textRenderer, this.gameModeHelp1, textPositionX, 122, GRAY_COLOR);
            context.drawTextWithShadow(this.textRenderer, this.gameModeHelp2, textPositionX, 134, GRAY_COLOR);

            if (!this.worldCreator.isDebug()) {
                context.drawTextWithShadow(this.textRenderer, ALLOW_CHEATS_INFO_LABEL, textPositionX, 172, GRAY_COLOR);
            }
        }

        super.render(context, mouseX, mouseY, delta);

        ci.cancel();
    }
    //#else
    //$$ public void timeless$render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
    //$$     if (!TimelessConfig.get().useOldWorldMenu) {
    //$$         return;
    //$$     }
    //$$
    //$$     renderBackground(matrices);
    //$$     drawCenteredTextWithShadow(matrices, this.textRenderer, this.title, this.halfWidth, 20, -1);
    //$$
    //$$     int textPositionX = this.halfWidth - 100;
    //$$     if (this.isWorldOptionsToggled) {
    //$$         drawTextWithShadow(matrices, this.textRenderer, SEED_LABEL, textPositionX, 47, GRAY_COLOR);
    //$$         drawTextWithShadow(matrices, this.textRenderer, SEED_INFO_LABEL, textPositionX, 85, GRAY_COLOR);
    //$$
    //$$         this.moreWorldOptionsComponent.render(matrices);
    //$$     } else {
    //$$         drawTextWithShadow(matrices, this.textRenderer, WORLD_NAME_LABEL, textPositionX, 47, GRAY_COLOR);
    //$$         drawTextWithShadow(matrices, this.textRenderer, this.worldDirectoryName, textPositionX, 85, GRAY_COLOR);
    //$$
    //$$         textPositionX -= 50;
    //$$         drawTextWithShadow(matrices, this.textRenderer, this.gameModeHelp1, textPositionX, 122, GRAY_COLOR);
    //$$         drawTextWithShadow(matrices, this.textRenderer, this.gameModeHelp2, textPositionX, 134, GRAY_COLOR);
    //$$
    //$$         if (!this.worldCreator.isDebug()) {
    //$$             drawTextWithShadow(matrices, this.textRenderer, ALLOW_CHEATS_INFO_LABEL, textPositionX, 172, GRAY_COLOR);
    //$$         }
    //$$     }
    //$$
    //$$     super.render(matrices, mouseX, mouseY, delta);
    //$$
    //$$     ci.cancel();
    //$$ }
    //#endif

    @Inject(
            method = "init",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$init(CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        this.moreWorldOptionsComponent = new MoreWorldOptionsComponent();
        this.halfWidth = this.width / 2;

        this.worldName = new TextFieldWidget(this.textRenderer, this.halfWidth - 100, 60, 200, 20, WORLD_NAME_LABEL);
        this.worldName.setText(this.worldCreator.getWorldName());
        this.worldName.setChangedListener(this::setWorldName);

        int leftColumnX = this.halfWidth - 155;
        int rightColumnX = this.halfWidth + 5;

        this.gameModeButton = CyclingButtonWidget.<WorldCreator.Mode>builder(value -> value.name)
                .values(List.of(
                        WorldCreator.Mode.SURVIVAL,
                        WorldCreator.Mode.HARDCORE,
                        WorldCreator.Mode.CREATIVE
                ))
                .initially(this.worldCreator.getGameMode())
                .build(leftColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, GAME_MODE_LABEL, (button, gameMode) -> {
                    setGameMode(gameMode);
                });
        this.worldCreator.addListener(creator -> {
            this.gameModeButton.setValue(this.worldCreator.getGameMode());
            this.gameModeButton.active = !this.worldCreator.isDebug();
        });

        this.difficultyButton = CyclingButtonWidget.builder(Difficulty::getTranslatableName)
                .values(Difficulty.values())
                .initially(this.worldCreator.getDifficulty())
                .build(rightColumnX, 100, BUTTON_WIDTH, BUTTON_HEIGHT, DIFFICULTY_TEXT, (button, difficulty) -> {
                    this.worldCreator.setDifficulty(difficulty);
                });
        this.worldCreator.addListener(creator -> {
            this.difficultyButton.setValue(this.worldCreator.getDifficulty());
            this.difficultyButton.active = !this.worldCreator.isHardcore();
        });

        this.allowCheatsButton = CyclingButtonWidget.onOffBuilder(this.worldCreator.areCheatsEnabled())
                .build(leftColumnX, 151, BUTTON_WIDTH, BUTTON_HEIGHT, ALLOW_CHEATS_TEXT, (button, allowCheats) -> {
                    this.worldCreator.setCheatsEnabled(allowCheats);
                });
        this.worldCreator.addListener(creator -> {
            this.allowCheatsButton.setValue(this.worldCreator.areCheatsEnabled());
            this.allowCheatsButton.active = !this.worldCreator.isDebug() && !this.worldCreator.isHardcore();
        });

        this.dataPacksButton = ButtonWidget.builder(DATA_PACKS_TEXT, button -> {
                    openPackScreen(this.worldCreator.getGeneratorOptionsHolder().dataConfiguration());
                })
                .dimensions(rightColumnX, 151, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        this.gameRulesButton = ButtonWidget.builder(GAME_RULES_TEXT, button -> {
                    this.client.setScreen(new EditGameRulesScreen(
                            this.worldCreator.getGameRules().copy(),
                            optional -> {
                                this.client.setScreen(this);
                                optional.ifPresent(this.worldCreator::setGameRules);
                            }
                    ));
                })
                .dimensions(leftColumnX, 185, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        this.moreWorldOptionsButton = ButtonWidget.builder(MORE_WORLD_OPTIONS_TEXT, button -> toggleWorldOptionsVisibility())
                .dimensions(rightColumnX, 185, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        ButtonWidget createNewWorldButton = ButtonWidget.builder(CREATE_NEW_WORLD_TEXT, button -> createLevel())
                .dimensions(leftColumnX, this.height - 28, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        ButtonWidget cancelButton = ButtonWidget.builder(CANCEL_TEXT, button -> close())
                .dimensions(rightColumnX, this.height - 28, BUTTON_WIDTH, BUTTON_HEIGHT)
                .build();

        List<ClickableWidget> moreWorldOptionsElements = this.moreWorldOptionsComponent.init(
                (CreateWorldScreen) (Object) this,
                this.textRenderer
        );

        addDrawableChild(this.worldName);
        addDrawableChild(this.gameModeButton);
        addDrawableChild(this.difficultyButton);
        addDrawableChild(this.allowCheatsButton);
        addDrawableChild(this.dataPacksButton);
        addDrawableChild(this.gameRulesButton);
        addDrawableChild(this.moreWorldOptionsButton);

        addDrawableChild(createNewWorldButton);
        addDrawableChild(cancelButton);

        moreWorldOptionsElements.forEach(this::addDrawableChild);

        updateWorldOptionsVisibility();
        setInitialFocus(this.worldName);

        this.worldCreator.update();
        updateGameModeHelp(this.worldCreator.getGameMode());
        updateWorldDirectoryName();

        ci.cancel();
    }

    //#if MC<=12001
    //$$ @Inject(
    //$$         method = "tick",
    //$$         at = @At("HEAD"),
    //$$         cancellable = true
    //$$ )
    //$$ public void timeless$tick(CallbackInfo ci) {
    //$$     if (!TimelessConfig.get().useOldWorldMenu) {
    //$$         return;
    //$$     }
    //$$
    //$$     this.worldName.tick();
    //$$     this.moreWorldOptionsComponent.tick();
    //$$
    //$$     ci.cancel();
    //$$ }
    //#endif

    @Inject(
            method = "keyPressed",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        cir.setReturnValue(super.keyPressed(keyCode, scanCode, modifiers));
        cir.cancel();
    }

    @Inject(
            method = "initTabNavigation",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$initTabNavigation(CallbackInfo ci) {
        if (!TimelessConfig.get().useOldWorldMenu) {
            return;
        }

        super.initTabNavigation();
        ci.cancel();
    }

    @Unique
    private void setWorldName(String newWorldName) {
        this.worldCreator.setWorldName(newWorldName);

        updateWorldDirectoryName();
    }

    @Unique
    private void updateWorldDirectoryName() {
        this.worldDirectoryName = Text.empty()
                .append(WORLD_DIRECTORY_NAME_LABEL)
                .append(" ")
                .append(this.worldCreator.getWorldDirectoryName());
    }

    @Unique
    private void setGameMode(WorldCreator.Mode gameMode) {
        this.worldCreator.setGameMode(gameMode);

        updateGameModeHelp(gameMode);
    }

    @Unique
    private void updateGameModeHelp(WorldCreator.Mode gameMode) {
        String gameModeName = gameMode.name().toLowerCase();
        if (gameModeName.equals("debug")) {
            gameModeName = "spectator";
        }

        this.gameModeHelp1 = Text.translatable("selectWorld.gameMode." + gameModeName + ".line1");
        this.gameModeHelp2 = Text.translatable("selectWorld.gameMode." + gameModeName + ".line2");
    }

    @Unique
    private void toggleWorldOptionsVisibility() {
        setWorldOptionsVisibility(!this.isWorldOptionsToggled);
    }

    @Unique
    private void updateWorldOptionsVisibility() {
        setWorldOptionsVisibility(this.isWorldOptionsToggled);
    }

    @Unique
    private void setWorldOptionsVisibility(boolean visible) {
        this.isWorldOptionsToggled = visible;
        this.gameModeButton.visible = !visible;
        this.difficultyButton.visible = !visible;

        if (this.moreWorldOptionsComponent.isDebug()) {
            this.dataPacksButton.visible = false;
            this.gameModeButton.active = false;

            if (this.nonDebugGameMode == null) {
                this.nonDebugGameMode = this.gameModeButton.getValue();
            }

            this.allowCheatsButton.visible = false;
            setGameMode(WorldCreator.Mode.DEBUG);
        } else {
            this.gameModeButton.active = true;
            if (this.nonDebugGameMode != null) {
                setGameMode(this.nonDebugGameMode);
            }

            this.allowCheatsButton.visible = !visible;
            this.dataPacksButton.visible = !visible;
        }

        this.moreWorldOptionsComponent.setVisibility(visible);
        this.worldName.setVisible(!visible);

        if (visible) {
            this.moreWorldOptionsButton.setMessage(DONE_TEXT);
        } else {
            this.moreWorldOptionsButton.setMessage(MORE_WORLD_OPTIONS_TEXT);
        }

        this.gameRulesButton.visible = !visible;
    }
}
