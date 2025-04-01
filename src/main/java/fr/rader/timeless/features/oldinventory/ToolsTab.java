package fr.rader.timeless.features.oldinventory;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;

//#if MC<=12004
//$$ import java.util.EnumSet;
//$$ import net.minecraft.enchantment.EnchantmentTarget;
//#elseif MC<=12006
//$$ import java.util.Set;
//$$ import net.minecraft.registry.tag.ItemTags;
//$$ import net.minecraft.registry.tag.TagKey;
//#endif

import static net.minecraft.item.ItemGroups.TOOLS;

public class ToolsTab extends Tab {

    public ToolsTab() {
        super(TOOLS, ItemGroup.Row.BOTTOM, 2, Text.translatable("timeless.itemGroup.tools"), new ItemStack(Items.IRON_AXE));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.FLINT_AND_STEEL);
        entries.add(Items.WOODEN_SHOVEL);
        entries.add(Items.WOODEN_PICKAXE);
        entries.add(Items.WOODEN_AXE);
        entries.add(Items.WOODEN_HOE);
        entries.add(Items.STONE_SHOVEL);
        entries.add(Items.STONE_PICKAXE);
        entries.add(Items.STONE_AXE);
        entries.add(Items.STONE_HOE);
        entries.add(Items.GOLDEN_SHOVEL);
        entries.add(Items.GOLDEN_PICKAXE);
        entries.add(Items.GOLDEN_AXE);
        entries.add(Items.GOLDEN_HOE);
        entries.add(Items.IRON_SHOVEL);
        entries.add(Items.IRON_PICKAXE);
        entries.add(Items.IRON_AXE);
        entries.add(Items.IRON_HOE);
        entries.add(Items.DIAMOND_SHOVEL);
        entries.add(Items.DIAMOND_PICKAXE);
        entries.add(Items.DIAMOND_AXE);
        entries.add(Items.DIAMOND_HOE);
        entries.add(Items.NETHERITE_SHOVEL);
        entries.add(Items.NETHERITE_PICKAXE);
        entries.add(Items.NETHERITE_AXE);
        entries.add(Items.NETHERITE_HOE);
        entries.add(Items.COMPASS);
        entries.add(Items.RECOVERY_COMPASS);
        addBundle(displayContext, entries);
        entries.add(Items.FISHING_ROD);
        entries.add(Items.CLOCK);
        entries.add(Items.SPYGLASS);
        entries.add(Items.SHEARS);
        getOptional(displayContext, RegistryKeys.ENCHANTMENT).ifPresent(wrapper -> {
            addAllEnchantedBooks(displayContext, entries, wrapper);
        });
        entries.add(Items.NAME_TAG);
        entries.add(Items.LEAD);
        entries.add(Items.GOAT_HORN);
        getOptional(displayContext, RegistryKeys.INSTRUMENT).ifPresent(wrapper -> {
            ItemGroups.addInstruments(entries, wrapper, Items.GOAT_HORN, InstrumentTags.GOAT_HORNS, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        });
    }

    private void addBundle(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        //#if MC>=12102
        entries.add(Items.BUNDLE);
        //#else
        //$$ if (displayContext.enabledFeatures().contains(FeatureFlags.BUNDLE)) {
        //$$     entries.add(Items.BUNDLE);
        //$$ }
        //#endif
    }

    private void addAllEnchantedBooks(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryWrapper.Impl<Enchantment> wrapper) {
        //#if MC>=12100
        ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
        //#elseif MC>=12005
        //$$ Set<TagKey<Item>> set = Set.of(ItemTags.VANISHING_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE, ItemTags.MINING_LOOT_ENCHANTABLE, ItemTags.FISHING_ENCHANTABLE, ItemTags.DURABILITY_ENCHANTABLE);
        //$$ ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.PARENT_TAB_ONLY, displayContext.enabledFeatures());
        //$$ ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.SEARCH_TAB_ONLY, displayContext.enabledFeatures());
        //#else
        //$$ EnumSet<EnchantmentTarget> set = EnumSet.of(EnchantmentTarget.VANISHABLE, EnchantmentTarget.DIGGER, EnchantmentTarget.FISHING_ROD, EnchantmentTarget.BREAKABLE);
        //$$ ItemGroups.addMaxLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
        //$$ ItemGroups.addAllLevelEnchantedBooks(entries, wrapper, set, ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
        //#endif
    }
}
