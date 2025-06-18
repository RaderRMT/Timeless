package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.FUNCTIONAL;

public class TransportationTab extends Tab {

    public TransportationTab() {
        super(FUNCTIONAL, ItemGroup.Row.TOP, 3, Text.translatable("timeless.itemGroup.transportation"), new ItemStack(Items.POWERED_RAIL));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.POWERED_RAIL);
        entries.add(Items.DETECTOR_RAIL);
        entries.add(Items.RAIL);
        entries.add(Items.ACTIVATOR_RAIL);
        entries.add(Items.SADDLE);
        //#if MC>=12106
        entries.add(Items.WHITE_HARNESS);
        entries.add(Items.LIGHT_GRAY_HARNESS);
        entries.add(Items.GRAY_HARNESS);
        entries.add(Items.BLACK_HARNESS);
        entries.add(Items.BROWN_HARNESS);
        entries.add(Items.RED_HARNESS);
        entries.add(Items.ORANGE_HARNESS);
        entries.add(Items.YELLOW_HARNESS);
        entries.add(Items.LIME_HARNESS);
        entries.add(Items.GREEN_HARNESS);
        entries.add(Items.CYAN_HARNESS);
        entries.add(Items.LIGHT_BLUE_HARNESS);
        entries.add(Items.BLUE_HARNESS);
        entries.add(Items.PURPLE_HARNESS);
        entries.add(Items.MAGENTA_HARNESS);
        entries.add(Items.PINK_HARNESS);
        //#endif
        entries.add(Items.MINECART);
        entries.add(Items.CHEST_MINECART);
        entries.add(Items.FURNACE_MINECART);
        entries.add(Items.TNT_MINECART);
        entries.add(Items.HOPPER_MINECART);
        entries.add(Items.CARROT_ON_A_STICK);
        entries.add(Items.WARPED_FUNGUS_ON_A_STICK);
        entries.add(Items.ELYTRA);
        entries.add(Items.OAK_BOAT);
        entries.add(Items.OAK_CHEST_BOAT);
        entries.add(Items.SPRUCE_BOAT);
        entries.add(Items.SPRUCE_CHEST_BOAT);
        entries.add(Items.BIRCH_BOAT);
        entries.add(Items.BIRCH_CHEST_BOAT);
        entries.add(Items.JUNGLE_BOAT);
        entries.add(Items.JUNGLE_CHEST_BOAT);
        entries.add(Items.ACACIA_BOAT);
        entries.add(Items.ACACIA_CHEST_BOAT);
        entries.add(Items.DARK_OAK_BOAT);
        entries.add(Items.DARK_OAK_CHEST_BOAT);
        entries.add(Items.BAMBOO_RAFT);
        entries.add(Items.BAMBOO_CHEST_RAFT);
        entries.add(Items.CHERRY_BOAT);
        entries.add(Items.CHERRY_CHEST_BOAT);
        entries.add(Items.MANGROVE_BOAT);
        entries.add(Items.MANGROVE_CHEST_BOAT);
    }
}
