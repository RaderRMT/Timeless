package fr.rader.timeless.features.oldinventory;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

public class BrewingTab extends Tab {

    public BrewingTab() {
        super(CreativeModeTabs.INGREDIENTS, CreativeModeTab.Row.BOTTOM, 4, Component.translatable("timeless.itemGroup.brewing"), BrewingTab::getIcon);
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.GHAST_TEAR);
        getOptional(parameters, Registries.POTION).ifPresent(wrapper -> {
            addDrinkablePotions(parameters, entries, wrapper);
        });
        entries.accept(Items.GLASS_BOTTLE);
        entries.accept(Items.FERMENTED_SPIDER_EYE);
        entries.accept(Items.BLAZE_POWDER);
        entries.accept(Items.MAGMA_CREAM);
        entries.accept(Items.BREWING_STAND);
        entries.accept(Items.CAULDRON);
        entries.accept(Items.GLISTERING_MELON_SLICE);
        entries.accept(Items.GOLDEN_CARROT);
        entries.accept(Items.RABBIT_FOOT);
        entries.accept(Items.DRAGON_BREATH);
        CreativeModeTabs.generateOminousBottles(entries, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        getOptional(parameters, Registries.POTION).ifPresent(wrapper -> {
            addPotions(parameters, entries, wrapper);
        });
        entries.accept(Items.PHANTOM_MEMBRANE);
    }

    private void addDrinkablePotions(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries, HolderLookup.RegistryLookup<Potion> wrapper) {
        CreativeModeTabs.generatePotionEffectTypes(entries, wrapper, Items.POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, parameters.enabledFeatures());
    }

    private void addPotions(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries, HolderLookup.RegistryLookup<Potion> wrapper) {
        CreativeModeTabs.generatePotionEffectTypes(entries, wrapper, Items.SPLASH_POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, parameters.enabledFeatures());
        CreativeModeTabs.generatePotionEffectTypes(entries, wrapper, Items.LINGERING_POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, parameters.enabledFeatures());
    }

    private static ItemStack getIcon() {
        ItemStack brewingIcon = new ItemStack(Items.POTION);
        brewingIcon.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));
        return brewingIcon;
    }
}
