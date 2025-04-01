package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.FOOD_AND_DRINK;

public class FoodstuffTab extends Tab {

    public FoodstuffTab() {
        super(FOOD_AND_DRINK, ItemGroup.Row.BOTTOM, 1, Text.translatable("timeless.itemGroup.foodstuff"), new ItemStack(Items.APPLE));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.APPLE);
        entries.add(Items.MUSHROOM_STEW);
        entries.add(Items.BREAD);
        entries.add(Items.PORKCHOP);
        entries.add(Items.COOKED_PORKCHOP);
        entries.add(Items.GOLDEN_APPLE);
        entries.add(Items.ENCHANTED_GOLDEN_APPLE);
        entries.add(Items.COD);
        entries.add(Items.SALMON);
        entries.add(Items.TROPICAL_FISH);
        entries.add(Items.PUFFERFISH);
        entries.add(Items.COOKED_COD);
        entries.add(Items.COOKED_SALMON);
        entries.add(Items.CAKE);
        entries.add(Items.COOKIE);
        entries.add(Items.MELON_SLICE);
        entries.add(Items.DRIED_KELP);
        entries.add(Items.BEEF);
        entries.add(Items.COOKED_BEEF);
        entries.add(Items.CHICKEN);
        entries.add(Items.COOKED_CHICKEN);
        entries.add(Items.ROTTEN_FLESH);
        entries.add(Items.SPIDER_EYE);
        entries.add(Items.CARROT);
        entries.add(Items.POTATO);
        entries.add(Items.BAKED_POTATO);
        entries.add(Items.POISONOUS_POTATO);
        entries.add(Items.PUMPKIN_PIE);
        entries.add(Items.RABBIT);
        entries.add(Items.COOKED_RABBIT);
        entries.add(Items.RABBIT_STEW);
        ItemGroups.addSuspiciousStews(entries, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        entries.add(Items.MUTTON);
        entries.add(Items.COOKED_MUTTON);
        entries.add(Items.BEETROOT);
        entries.add(Items.BEETROOT_SOUP);
        entries.add(Items.SWEET_BERRIES);
        entries.add(Items.GLOW_BERRIES);
        entries.add(Items.HONEY_BOTTLE);
    }
}
