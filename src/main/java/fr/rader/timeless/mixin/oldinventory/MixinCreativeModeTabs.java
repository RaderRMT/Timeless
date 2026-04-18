package fr.rader.timeless.mixin.oldinventory;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.oldinventory.*;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.InvocationTargetException;

@Mixin(CreativeModeTabs.class)
public abstract class MixinCreativeModeTabs {

    @Shadow @Final
    public static ResourceKey<CreativeModeTab> INVENTORY;

    @Unique
    private static final Class<?>[] timeless$TABS = {
            // we need this otherwise the game crashes
            OperatorTab.class,

            // top tabs
            BuildingBlocksTab.class,
            DecorationBlocksTab.class,
            RedstoneTab.class,
            TransportationTab.class,
            SavedHotbarsTab.class,
            SearchTab.class,

            // bottom tabs
            MiscellaneousTab.class,
            FoodstuffTab.class,
            ToolsTab.class,
            CombatTab.class,
            BrewingTab.class,
    };

    @Inject(
            method = "bootstrap",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void timeless$bootstrap(Registry<CreativeModeTab> registry, CallbackInfoReturnable<CreativeModeTab> cir) {
        if (!TimelessConfig.get().useOldInventoryLayout) {
            return;
        }

        for (Class<?> clazz : timeless$TABS) {
            try {
                Tab tab = (Tab) clazz.getDeclaredConstructor().newInstance();
                tab.register(registry);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        cir.setReturnValue(Registry.register(
                registry,
                INVENTORY,
                CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 6)
                        .title(Component.translatable("itemGroup.inventory"))
                        .icon(() -> new ItemStack(Blocks.CHEST))
                        .backgroundTexture(CreativeModeTabs.INVENTORY_BACKGROUND)
                        .hideTitle()
                        .alignedRight()
                        .type(CreativeModeTab.Type.INVENTORY)
                        .noScrollBar()
                        .build()
        ));
    }
}
