package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class RedstoneTab extends Tab {

    public RedstoneTab() {
        super(CreativeModeTabs.REDSTONE_BLOCKS, CreativeModeTab.Row.TOP, 2, Component.translatable("itemGroup.redstone"), () -> new ItemStack(Items.REDSTONE));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        entries.accept(Items.REDSTONE);
        entries.accept(Items.REDSTONE_TORCH);
        entries.accept(Items.REDSTONE_BLOCK);
        entries.accept(Items.REPEATER);
        entries.accept(Items.COMPARATOR);
        entries.accept(Items.PISTON);
        entries.accept(Items.STICKY_PISTON);
        entries.accept(Items.SLIME_BLOCK);
        entries.accept(Items.HONEY_BLOCK);
        entries.accept(Items.OBSERVER);
        entries.accept(Items.HOPPER);
        entries.accept(Items.DISPENSER);
        entries.accept(Items.DROPPER);
        entries.accept(Items.LECTERN);
        entries.accept(Items.CRAFTER);
        entries.accept(Items.TARGET);
        entries.accept(Items.LEVER);
        Items.LIGHTNING_ROD.forEach(entries::accept);
        entries.accept(Items.DAYLIGHT_DETECTOR);
        entries.accept(Items.SCULK_SHRIEKER);
        entries.accept(Items.SCULK_SENSOR);
        entries.accept(Items.CALIBRATED_SCULK_SENSOR);
        entries.accept(Items.TRIPWIRE_HOOK);
        entries.accept(Items.TRAPPED_CHEST);
        Items.COPPER_CHEST.forEach(entries::accept);
        entries.accept(Items.TNT);
        entries.accept(Items.REDSTONE_LAMP);
        Items.COPPER_BULB.forEach(entries::accept);
        entries.accept(Items.NOTE_BLOCK);
        entries.accept(Items.STONE_BUTTON);
        entries.accept(Items.POLISHED_BLACKSTONE_BUTTON);
        entries.accept(Items.OAK_BUTTON);
        entries.accept(Items.SPRUCE_BUTTON);
        entries.accept(Items.BIRCH_BUTTON);
        entries.accept(Items.JUNGLE_BUTTON);
        entries.accept(Items.ACACIA_BUTTON);
        entries.accept(Items.DARK_OAK_BUTTON);
        entries.accept(Items.BAMBOO_BUTTON);
        entries.accept(Items.CHERRY_BUTTON);
        entries.accept(Items.MANGROVE_BUTTON);
        entries.accept(Items.PALE_OAK_BUTTON);
        entries.accept(Items.CRIMSON_BUTTON);
        entries.accept(Items.WARPED_BUTTON);
        entries.accept(Items.STONE_PRESSURE_PLATE);
        entries.accept(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE);
        entries.accept(Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
        entries.accept(Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
        entries.accept(Items.OAK_PRESSURE_PLATE);
        entries.accept(Items.SPRUCE_PRESSURE_PLATE);
        entries.accept(Items.BIRCH_PRESSURE_PLATE);
        entries.accept(Items.JUNGLE_PRESSURE_PLATE);
        entries.accept(Items.ACACIA_PRESSURE_PLATE);
        entries.accept(Items.DARK_OAK_PRESSURE_PLATE);
        entries.accept(Items.BAMBOO_PRESSURE_PLATE);
        entries.accept(Items.CHERRY_PRESSURE_PLATE);
        entries.accept(Items.MANGROVE_PRESSURE_PLATE);
        entries.accept(Items.PALE_OAK_PRESSURE_PLATE);
        entries.accept(Items.CRIMSON_PRESSURE_PLATE);
        entries.accept(Items.WARPED_PRESSURE_PLATE);
        entries.accept(Items.IRON_DOOR);
        entries.accept(Items.OAK_DOOR);
        entries.accept(Items.SPRUCE_DOOR);
        entries.accept(Items.BIRCH_DOOR);
        entries.accept(Items.JUNGLE_DOOR);
        entries.accept(Items.ACACIA_DOOR);
        entries.accept(Items.DARK_OAK_DOOR);
        entries.accept(Items.BAMBOO_DOOR);
        entries.accept(Items.CHERRY_DOOR);
        entries.accept(Items.MANGROVE_DOOR);
        entries.accept(Items.PALE_OAK_DOOR);
        entries.accept(Items.CRIMSON_DOOR);
        entries.accept(Items.WARPED_DOOR);
        Items.COPPER_DOOR.forEach(entries::accept);
        entries.accept(Items.IRON_TRAPDOOR);
        entries.accept(Items.OAK_TRAPDOOR);
        entries.accept(Items.SPRUCE_TRAPDOOR);
        entries.accept(Items.BIRCH_TRAPDOOR);
        entries.accept(Items.JUNGLE_TRAPDOOR);
        entries.accept(Items.ACACIA_TRAPDOOR);
        entries.accept(Items.DARK_OAK_TRAPDOOR);
        entries.accept(Items.BAMBOO_TRAPDOOR);
        entries.accept(Items.CHERRY_TRAPDOOR);
        entries.accept(Items.MANGROVE_TRAPDOOR);
        entries.accept(Items.PALE_OAK_TRAPDOOR);
        entries.accept(Items.CRIMSON_TRAPDOOR);
        entries.accept(Items.WARPED_TRAPDOOR);
        Items.COPPER_TRAPDOOR.forEach(entries::accept);
        entries.accept(Items.OAK_FENCE_GATE);
        entries.accept(Items.SPRUCE_FENCE_GATE);
        entries.accept(Items.BIRCH_FENCE_GATE);
        entries.accept(Items.JUNGLE_FENCE_GATE);
        entries.accept(Items.ACACIA_FENCE_GATE);
        entries.accept(Items.DARK_OAK_FENCE_GATE);
        entries.accept(Items.BAMBOO_FENCE_GATE);
        entries.accept(Items.CHERRY_FENCE_GATE);
        entries.accept(Items.MANGROVE_FENCE_GATE);
        entries.accept(Items.PALE_OAK_FENCE_GATE);
        entries.accept(Items.CRIMSON_FENCE_GATE);
        entries.accept(Items.WARPED_FENCE_GATE);
    }
}
