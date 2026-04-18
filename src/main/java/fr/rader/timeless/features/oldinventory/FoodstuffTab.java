package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class FoodstuffTab extends Tab {

    public FoodstuffTab() {
        super(CreativeModeTabs.FOOD_AND_DRINKS, CreativeModeTab.Row.BOTTOM, 1, Component.translatable("timeless.itemGroup.foodstuff"), () -> new ItemStack(Items.APPLE));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.APPLE);
        entries.accept(Items.MUSHROOM_STEW);
        entries.accept(Items.BREAD);
        entries.accept(Items.PORKCHOP);
        entries.accept(Items.COOKED_PORKCHOP);
        entries.accept(Items.GOLDEN_APPLE);
        entries.accept(Items.ENCHANTED_GOLDEN_APPLE);
        entries.accept(Items.COD);
        entries.accept(Items.SALMON);
        entries.accept(Items.TROPICAL_FISH);
        entries.accept(Items.PUFFERFISH);
        entries.accept(Items.COOKED_COD);
        entries.accept(Items.COOKED_SALMON);
        entries.accept(Items.CAKE);
        entries.accept(Items.COOKIE);
        entries.accept(Items.MELON_SLICE);
        entries.accept(Items.DRIED_KELP);
        entries.accept(Items.BEEF);
        entries.accept(Items.COOKED_BEEF);
        entries.accept(Items.CHICKEN);
        entries.accept(Items.COOKED_CHICKEN);
        entries.accept(Items.ROTTEN_FLESH);
        entries.accept(Items.SPIDER_EYE);
        entries.accept(Items.CARROT);
        entries.accept(Items.POTATO);
        entries.accept(Items.BAKED_POTATO);
        entries.accept(Items.POISONOUS_POTATO);
        entries.accept(Items.PUMPKIN_PIE);
        entries.accept(Items.RABBIT);
        entries.accept(Items.COOKED_RABBIT);
        entries.accept(Items.RABBIT_STEW);
        CreativeModeTabs.generateSuspiciousStews(entries, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        entries.accept(Items.MUTTON);
        entries.accept(Items.COOKED_MUTTON);
        entries.accept(Items.BEETROOT);
        entries.accept(Items.BEETROOT_SOUP);
        entries.accept(Items.SWEET_BERRIES);
        entries.accept(Items.GLOW_BERRIES);
        entries.accept(Items.HONEY_BOTTLE);
    }
}
