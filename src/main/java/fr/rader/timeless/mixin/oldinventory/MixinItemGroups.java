package fr.rader.timeless.mixin.oldinventory;

import fr.rader.timeless.config.TimelessConfig;
import fr.rader.timeless.features.oldinventory.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.InvocationTargetException;

@Mixin(ItemGroups.class)
public abstract class MixinItemGroups {

    @Shadow @Final
    public static RegistryKey<ItemGroup> INVENTORY;

    @Unique
    private static final Class<?>[] timeless$tabs = {
            //#if MC>=12101
            // we need this otherwise the game crashes
            OperatorTab.class,
            //#endif

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
            method = "registerAndGetDefault",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void timeless$registerAndGetDefault(Registry<ItemGroup> registry, CallbackInfoReturnable<ItemGroup> cir) {
        if (!TimelessConfig.get().useOldInventoryLayout) {
            return;
        }

        for (Class<?> clazz : timeless$tabs) {
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
                ItemGroup.create(ItemGroup.Row.BOTTOM, 6)
                        .displayName(Text.translatable("itemGroup.inventory"))
                        .icon(() -> new ItemStack(Blocks.CHEST))
                        //#if MC>=12100
                        .texture(ItemGroup.getTabTextureId("inventory"))
                        //#else
                        //$$ .texture("inventory.png")
                        //#endif
                        .noRenderedName()
                        .special()
                        .type(ItemGroup.Type.INVENTORY)
                        .noScrollbar()
                        .build()
        ));
    }
}
