package fr.rader.timeless.features.oldinventory;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;

public class ToolsTab extends Tab {

    public ToolsTab() {
        super(CreativeModeTabs.TOOLS_AND_UTILITIES, CreativeModeTab.Row.BOTTOM, 2, Component.translatable("timeless.itemGroup.tools"), () -> new ItemStack(Items.IRON_AXE));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.FLINT_AND_STEEL);
        entries.accept(Items.WOODEN_SHOVEL);
        entries.accept(Items.WOODEN_PICKAXE);
        entries.accept(Items.WOODEN_AXE);
        entries.accept(Items.WOODEN_HOE);
        entries.accept(Items.STONE_SHOVEL);
        entries.accept(Items.STONE_PICKAXE);
        entries.accept(Items.STONE_AXE);
        entries.accept(Items.STONE_HOE);
        entries.accept(Items.COPPER_SHOVEL);
        entries.accept(Items.COPPER_PICKAXE);
        entries.accept(Items.COPPER_AXE);
        entries.accept(Items.COPPER_HOE);
        entries.accept(Items.IRON_SHOVEL);
        entries.accept(Items.IRON_PICKAXE);
        entries.accept(Items.IRON_AXE);
        entries.accept(Items.IRON_HOE);
        entries.accept(Items.GOLDEN_SHOVEL);
        entries.accept(Items.GOLDEN_PICKAXE);
        entries.accept(Items.GOLDEN_AXE);
        entries.accept(Items.GOLDEN_HOE);
        entries.accept(Items.DIAMOND_SHOVEL);
        entries.accept(Items.DIAMOND_PICKAXE);
        entries.accept(Items.DIAMOND_AXE);
        entries.accept(Items.DIAMOND_HOE);
        entries.accept(Items.NETHERITE_SHOVEL);
        entries.accept(Items.NETHERITE_PICKAXE);
        entries.accept(Items.NETHERITE_AXE);
        entries.accept(Items.NETHERITE_HOE);
        entries.accept(Items.COMPASS);
        entries.accept(Items.RECOVERY_COMPASS);
        entries.accept(Items.BUNDLE);
        entries.accept(Items.FISHING_ROD);
        entries.accept(Items.CLOCK);
        entries.accept(Items.SPYGLASS);
        entries.accept(Items.SHEARS);
        getOptional(parameters, Registries.ENCHANTMENT).ifPresent(wrapper -> {
            addAllEnchantedBooks(parameters, entries, wrapper);
        });
        entries.accept(Items.NAME_TAG);
        entries.accept(Items.LEAD);
        getOptional(parameters, Registries.INSTRUMENT).ifPresent(wrapper -> {
            CreativeModeTabs.generateInstrumentTypes(entries, wrapper, Items.GOAT_HORN, InstrumentTags.GOAT_HORNS, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        });
    }

    private void addAllEnchantedBooks(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries, HolderLookup.RegistryLookup<Enchantment> wrapper) {
        CreativeModeTabs.generateEnchantmentBookTypesOnlyMaxLevel(entries, wrapper, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        CreativeModeTabs.generateEnchantmentBookTypesAllLevels(entries, wrapper, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
    }
}
