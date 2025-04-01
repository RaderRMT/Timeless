package fr.rader.timeless.features.oldinventory;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.INGREDIENTS;

//#if MC<12005
//$$ import net.minecraft.potion.PotionUtil;
//#else
import net.minecraft.component.DataComponentTypes;
//#endif

public class BrewingTab extends Tab {

    public BrewingTab() {
        super(INGREDIENTS, ItemGroup.Row.BOTTOM, 4, Text.translatable("timeless.itemGroup.brewing"), BrewingTab::getIcon);
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.GHAST_TEAR);
        getOptional(displayContext, RegistryKeys.POTION).ifPresent(wrapper -> {
            addDrinkablePotions(displayContext, entries, wrapper);
        });
        entries.add(Items.GLASS_BOTTLE);
        entries.add(Items.FERMENTED_SPIDER_EYE);
        entries.add(Items.BLAZE_POWDER);
        entries.add(Items.MAGMA_CREAM);
        entries.add(Items.BREWING_STAND);
        entries.add(Items.CAULDRON);
        entries.add(Items.GLISTERING_MELON_SLICE);
        entries.add(Items.GOLDEN_CARROT);
        entries.add(Items.RABBIT_FOOT);
        entries.add(Items.DRAGON_BREATH);
        //#if MC>=12100
        ItemGroups.addOminousBottles(entries, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        //#endif
        getOptional(displayContext, RegistryKeys.POTION).ifPresent(wrapper -> {
            addPotions(displayContext, entries, wrapper);
        });
        entries.add(Items.PHANTOM_MEMBRANE);
    }

    private void addDrinkablePotions(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryWrapper.Impl<Potion> wrapper) {
        //#if MC>=12102
        ItemGroups.addPotions(entries, wrapper, Items.POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        //#elseif MC>=12005
        //$$ ItemGroups.addPotions(entries, wrapper, Items.POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        //#else
        //$$ ItemGroups.addPotions(entries, wrapper, Items.POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        //#endif
    }

    private void addPotions(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryWrapper.Impl<Potion> wrapper) {
        //#if MC>=12005
        ItemGroups.addPotions(entries, wrapper, Items.SPLASH_POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        ItemGroups.addPotions(entries, wrapper, Items.LINGERING_POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS, displayContext.enabledFeatures());
        //#else
        //$$ ItemGroups.addPotions(entries, wrapper, Items.SPLASH_POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        //$$ ItemGroups.addPotions(entries, wrapper, Items.LINGERING_POTION, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        //#endif
    }

    private static ItemStack getIcon() {
        //#if MC>=12005
        ItemStack brewingIcon = new ItemStack(Items.POTION);
        brewingIcon.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER));
        return brewingIcon;
        //#else
        //$$ return PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        //#endif
    }
}
