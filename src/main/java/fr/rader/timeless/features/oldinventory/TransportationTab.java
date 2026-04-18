package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TransportationTab extends Tab {

    public TransportationTab() {
        super(CreativeModeTabs.FUNCTIONAL_BLOCKS, CreativeModeTab.Row.TOP, 3, Component.translatable("timeless.itemGroup.transportation"), () -> new ItemStack(Items.POWERED_RAIL));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.POWERED_RAIL);
        entries.accept(Items.DETECTOR_RAIL);
        entries.accept(Items.RAIL);
        entries.accept(Items.ACTIVATOR_RAIL);
        entries.accept(Items.SADDLE);
        Items.HARNESS.forEach(entries::accept);
        entries.accept(Items.MINECART);
        entries.accept(Items.CHEST_MINECART);
        entries.accept(Items.FURNACE_MINECART);
        entries.accept(Items.TNT_MINECART);
        entries.accept(Items.HOPPER_MINECART);
        entries.accept(Items.CARROT_ON_A_STICK);
        entries.accept(Items.WARPED_FUNGUS_ON_A_STICK);
        entries.accept(Items.ELYTRA);
        entries.accept(Items.OAK_BOAT);
        entries.accept(Items.OAK_CHEST_BOAT);
        entries.accept(Items.SPRUCE_BOAT);
        entries.accept(Items.SPRUCE_CHEST_BOAT);
        entries.accept(Items.BIRCH_BOAT);
        entries.accept(Items.BIRCH_CHEST_BOAT);
        entries.accept(Items.JUNGLE_BOAT);
        entries.accept(Items.JUNGLE_CHEST_BOAT);
        entries.accept(Items.ACACIA_BOAT);
        entries.accept(Items.ACACIA_CHEST_BOAT);
        entries.accept(Items.DARK_OAK_BOAT);
        entries.accept(Items.DARK_OAK_CHEST_BOAT);
        entries.accept(Items.BAMBOO_RAFT);
        entries.accept(Items.BAMBOO_CHEST_RAFT);
        entries.accept(Items.CHERRY_BOAT);
        entries.accept(Items.CHERRY_CHEST_BOAT);
        entries.accept(Items.MANGROVE_BOAT);
        entries.accept(Items.MANGROVE_CHEST_BOAT);
    }
}
