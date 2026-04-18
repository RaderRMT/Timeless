package fr.rader.timeless.features.oldinventory;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;

public class CombatTab extends Tab {

    public CombatTab() {
        super(CreativeModeTabs.COMBAT, CreativeModeTab.Row.BOTTOM, 3, Component.translatable("itemGroup.combat"), () -> new ItemStack(Items.GOLDEN_SWORD));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.TURTLE_HELMET);
        entries.accept(Items.BOW);
        entries.accept(Items.ARROW);
        entries.accept(Items.WOODEN_SWORD);
        entries.accept(Items.STONE_SWORD);
        entries.accept(Items.COPPER_SWORD);
        entries.accept(Items.IRON_SWORD);
        entries.accept(Items.GOLDEN_SWORD);
        entries.accept(Items.DIAMOND_SWORD);
        entries.accept(Items.NETHERITE_SWORD);
        entries.accept(Items.WOODEN_SPEAR);
        entries.accept(Items.STONE_SPEAR);
        entries.accept(Items.COPPER_SPEAR);
        entries.accept(Items.IRON_SPEAR);
        entries.accept(Items.GOLDEN_SPEAR);
        entries.accept(Items.DIAMOND_SPEAR);
        entries.accept(Items.NETHERITE_SPEAR);
        entries.accept(Items.LEATHER_HELMET);
        entries.accept(Items.LEATHER_CHESTPLATE);
        entries.accept(Items.LEATHER_LEGGINGS);
        entries.accept(Items.LEATHER_BOOTS);
        entries.accept(Items.COPPER_HELMET);
        entries.accept(Items.COPPER_CHESTPLATE);
        entries.accept(Items.COPPER_LEGGINGS);
        entries.accept(Items.COPPER_BOOTS);
        entries.accept(Items.CHAINMAIL_HELMET);
        entries.accept(Items.CHAINMAIL_CHESTPLATE);
        entries.accept(Items.CHAINMAIL_LEGGINGS);
        entries.accept(Items.CHAINMAIL_BOOTS);
        entries.accept(Items.IRON_HELMET);
        entries.accept(Items.IRON_CHESTPLATE);
        entries.accept(Items.IRON_LEGGINGS);
        entries.accept(Items.IRON_BOOTS);
        entries.accept(Items.GOLDEN_HELMET);
        entries.accept(Items.GOLDEN_CHESTPLATE);
        entries.accept(Items.GOLDEN_LEGGINGS);
        entries.accept(Items.GOLDEN_BOOTS);
        entries.accept(Items.DIAMOND_HELMET);
        entries.accept(Items.DIAMOND_CHESTPLATE);
        entries.accept(Items.DIAMOND_LEGGINGS);
        entries.accept(Items.DIAMOND_BOOTS);
        entries.accept(Items.NETHERITE_HELMET);
        entries.accept(Items.NETHERITE_CHESTPLATE);
        entries.accept(Items.NETHERITE_LEGGINGS);
        entries.accept(Items.NETHERITE_BOOTS);
        getOptional(parameters, Registries.ENCHANTMENT).ifPresent(wrapper -> {
            addAllEnchantedBooks(parameters, entries, wrapper);
        });
        entries.accept(Items.SPECTRAL_ARROW);
        getOptional(parameters, Registries.POTION).ifPresent(wrapper -> addPotions(parameters, entries, wrapper));
        entries.accept(Items.SHIELD);
        entries.accept(Items.TOTEM_OF_UNDYING);
        entries.accept(Items.TRIDENT);
        entries.accept(Items.MACE);
        entries.accept(Items.CROSSBOW);
        entries.accept(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        entries.accept(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.accept(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
    }

    private void addAllEnchantedBooks(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries, HolderLookup.RegistryLookup<Enchantment> wrapper) {
        CreativeModeTabs.generateEnchantmentBookTypesOnlyMaxLevel(entries, wrapper, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
        CreativeModeTabs.generateEnchantmentBookTypesAllLevels(entries, wrapper, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
    }

    private void addPotions(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries, HolderLookup.RegistryLookup<Potion> wrapper) {
        CreativeModeTabs.generatePotionEffectTypes(entries, wrapper, Items.TIPPED_ARROW, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, parameters.enabledFeatures());
    }
}
