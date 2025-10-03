package fr.rader.timeless.features.oldinventory;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

//#if MC<=12004
//$$ import net.minecraft.enchantment.EnchantmentTarget;
//$$ import java.util.EnumSet;
//#elseif MC<=12006
//$$ import net.minecraft.registry.tag.ItemTags;
//$$ import net.minecraft.registry.tag.TagKey;
//$$ import java.util.Set;
//#endif

import static net.minecraft.item.ItemGroups.COMBAT;

public class CombatTab extends Tab {

    public CombatTab() {
        super(COMBAT, ItemGroup.Row.BOTTOM, 3, Text.translatable("itemGroup.combat"), new ItemStack(Items.GOLDEN_SWORD));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.TURTLE_HELMET);
        entries.add(Items.BOW);
        entries.add(Items.ARROW);
        entries.add(Items.WOODEN_SWORD);
        entries.add(Items.STONE_SWORD);
        //#if MC>=12109
        entries.add(Items.COPPER_SWORD);
        //#endif
        entries.add(Items.GOLDEN_SWORD);
        entries.add(Items.IRON_SWORD);
        entries.add(Items.DIAMOND_SWORD);
        entries.add(Items.NETHERITE_SWORD);
        entries.add(Items.LEATHER_HELMET);
        entries.add(Items.LEATHER_CHESTPLATE);
        entries.add(Items.LEATHER_LEGGINGS);
        entries.add(Items.LEATHER_BOOTS);
        entries.add(Items.CHAINMAIL_HELMET);
        entries.add(Items.CHAINMAIL_CHESTPLATE);
        entries.add(Items.CHAINMAIL_LEGGINGS);
        entries.add(Items.CHAINMAIL_BOOTS);
        //#if MC>=12109
        entries.add(Items.COPPER_HELMET);
        entries.add(Items.COPPER_CHESTPLATE);
        entries.add(Items.COPPER_LEGGINGS);
        entries.add(Items.COPPER_BOOTS);
        //#endif
        entries.add(Items.IRON_HELMET);
        entries.add(Items.IRON_CHESTPLATE);
        entries.add(Items.IRON_LEGGINGS);
        entries.add(Items.IRON_BOOTS);
        entries.add(Items.DIAMOND_HELMET);
        entries.add(Items.DIAMOND_CHESTPLATE);
        entries.add(Items.DIAMOND_LEGGINGS);
        entries.add(Items.DIAMOND_BOOTS);
        entries.add(Items.GOLDEN_HELMET);
        entries.add(Items.GOLDEN_CHESTPLATE);
        entries.add(Items.GOLDEN_LEGGINGS);
        entries.add(Items.GOLDEN_BOOTS);
        entries.add(Items.NETHERITE_HELMET);
        entries.add(Items.NETHERITE_CHESTPLATE);
        entries.add(Items.NETHERITE_LEGGINGS);
        entries.add(Items.NETHERITE_BOOTS);
        getOptional(displayContext, RegistryKeys.ENCHANTMENT).ifPresent(wrapper -> {
            addAllEnchantedBooks(displayContext, entries, wrapper);
        });
        entries.add(Items.SPECTRAL_ARROW);
        getOptional(displayContext, RegistryKeys.POTION).ifPresent(wrapper -> addPotions(displayContext, entries, wrapper));
        entries.add(Items.SHIELD);
        entries.add(Items.TOTEM_OF_UNDYING);
        entries.add(Items.TRIDENT);
        //#if MC>=12100
        entries.add(Items.MACE);
        //#endif
        entries.add(Items.CROSSBOW);
        //#if MC>=12100
        entries.add(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);
        //#endif
        entries.add(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
        //#if MC>=12100
        entries.add(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE);
        //#endif
        entries.add(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        entries.add(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.add(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
    }

    private void addAllEnchantedBooks(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryWrapper.Impl<Enchantment> wrapper) {
        //#if MC>=12100
        ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
        //#elseif MC>=12005
        //$$ Set<TagKey<Item>> set = Set.of(ItemTags.VANISHING_ENCHANTABLE, ItemTags.ARMOR_ENCHANTABLE, ItemTags.FOOT_ARMOR_ENCHANTABLE, ItemTags.HEAD_ARMOR_ENCHANTABLE, ItemTags.LEG_ARMOR_ENCHANTABLE, ItemTags.CHEST_ARMOR_ENCHANTABLE, ItemTags.BOW_ENCHANTABLE, ItemTags.WEAPON_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE, ItemTags.FIRE_ASPECT_ENCHANTABLE, ItemTags.SHARP_WEAPON_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE, ItemTags.EQUIPPABLE_ENCHANTABLE, ItemTags.DURABILITY_ENCHANTABLE, ItemTags.TRIDENT_ENCHANTABLE, ItemTags.CROSSBOW_ENCHANTABLE);
        //$$ ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.PARENT_TAB_ONLY, displayContext.enabledFeatures());
        //$$ ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.SEARCH_TAB_ONLY, displayContext.enabledFeatures());
        //#else
        //$$ EnumSet<EnchantmentTarget> set = EnumSet.of(EnchantmentTarget.VANISHABLE, EnchantmentTarget.ARMOR, EnchantmentTarget.ARMOR_FEET, EnchantmentTarget.ARMOR_HEAD, EnchantmentTarget.ARMOR_LEGS, EnchantmentTarget.ARMOR_CHEST, EnchantmentTarget.BOW, EnchantmentTarget.WEAPON, EnchantmentTarget.WEARABLE, EnchantmentTarget.BREAKABLE, EnchantmentTarget.TRIDENT, EnchantmentTarget.CROSSBOW);
        //$$ ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        //$$ ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
        //#endif
    }

    private void addPotions(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryWrapper.Impl<Potion> wrapper) {
        //#if MC>=12102
        ItemGroups.addPotions(entries, wrapper, Items.TIPPED_ARROW, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        //#elseif MC>=12005
        //$$ ItemGroups.addPotions(entries, wrapper, Items.TIPPED_ARROW, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        //#else
        //$$ ItemGroups.addPotions(entries, wrapper, Items.TIPPED_ARROW, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        //#endif
    }
}
