package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.REDSTONE;

public class RedstoneTab extends Tab {

    public RedstoneTab() {
        super(REDSTONE, ItemGroup.Row.TOP, 2, Text.translatable("itemGroup.redstone"), new ItemStack(Items.REDSTONE));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.REDSTONE);
        entries.add(Items.REDSTONE_TORCH);
        entries.add(Items.REDSTONE_BLOCK);
        entries.add(Items.REPEATER);
        entries.add(Items.COMPARATOR);
        entries.add(Items.PISTON);
        entries.add(Items.STICKY_PISTON);
        entries.add(Items.SLIME_BLOCK);
        entries.add(Items.HONEY_BLOCK);
        entries.add(Items.OBSERVER);
        entries.add(Items.HOPPER);
        entries.add(Items.DISPENSER);
        entries.add(Items.DROPPER);
        entries.add(Items.LECTERN);
        //#if MC>=12100
        entries.add(Items.CRAFTER);
        //#endif
        entries.add(Items.TARGET);
        entries.add(Items.LEVER);
        entries.add(Items.LIGHTNING_ROD);
        //#if MC>=12109
        entries.add(Items.EXPOSED_LIGHTNING_ROD);
        entries.add(Items.WEATHERED_LIGHTNING_ROD);
        entries.add(Items.OXIDIZED_LIGHTNING_ROD);
        entries.add(Items.WAXED_LIGHTNING_ROD);
        entries.add(Items.WAXED_EXPOSED_LIGHTNING_ROD);
        entries.add(Items.WAXED_WEATHERED_LIGHTNING_ROD);
        entries.add(Items.WAXED_OXIDIZED_LIGHTNING_ROD);
        //#endif
        entries.add(Items.DAYLIGHT_DETECTOR);
        entries.add(Items.SCULK_SHRIEKER);
        entries.add(Items.SCULK_SENSOR);
        entries.add(Items.CALIBRATED_SCULK_SENSOR);
        entries.add(Items.TRIPWIRE_HOOK);
        entries.add(Items.TRAPPED_CHEST);
        //#if MC>=12190
        entries.add(Items.COPPER_CHEST);
        entries.add(Items.EXPOSED_COPPER_CHEST);
        entries.add(Items.WEATHERED_COPPER_CHEST);
        entries.add(Items.OXIDIZED_COPPER_CHEST);
        entries.add(Items.WAXED_COPPER_CHEST);
        entries.add(Items.WAXED_EXPOSED_COPPER_CHEST);
        entries.add(Items.WAXED_WEATHERED_COPPER_CHEST);
        entries.add(Items.WAXED_OXIDIZED_COPPER_CHEST);
        //#endif
        entries.add(Items.TNT);
        entries.add(Items.REDSTONE_LAMP);
        //#if MC>=12100
        entries.add(Items.COPPER_BULB);
        entries.add(Items.EXPOSED_COPPER_BULB);
        entries.add(Items.WEATHERED_COPPER_BULB);
        entries.add(Items.OXIDIZED_COPPER_BULB);
        entries.add(Items.WAXED_COPPER_BULB);
        entries.add(Items.WAXED_EXPOSED_COPPER_BULB);
        entries.add(Items.WAXED_WEATHERED_COPPER_BULB);
        entries.add(Items.WAXED_OXIDIZED_COPPER_BULB);
        //#endif
        entries.add(Items.NOTE_BLOCK);
        entries.add(Items.STONE_BUTTON);
        entries.add(Items.POLISHED_BLACKSTONE_BUTTON);
        entries.add(Items.OAK_BUTTON);
        entries.add(Items.SPRUCE_BUTTON);
        entries.add(Items.BIRCH_BUTTON);
        entries.add(Items.JUNGLE_BUTTON);
        entries.add(Items.ACACIA_BUTTON);
        entries.add(Items.DARK_OAK_BUTTON);
        entries.add(Items.BAMBOO_BUTTON);
        entries.add(Items.CHERRY_BUTTON);
        entries.add(Items.MANGROVE_BUTTON);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_BUTTON);
        //#endif
        entries.add(Items.CRIMSON_BUTTON);
        entries.add(Items.WARPED_BUTTON);
        entries.add(Items.STONE_PRESSURE_PLATE);
        entries.add(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE);
        entries.add(Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
        entries.add(Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
        entries.add(Items.OAK_PRESSURE_PLATE);
        entries.add(Items.SPRUCE_PRESSURE_PLATE);
        entries.add(Items.BIRCH_PRESSURE_PLATE);
        entries.add(Items.JUNGLE_PRESSURE_PLATE);
        entries.add(Items.ACACIA_PRESSURE_PLATE);
        entries.add(Items.DARK_OAK_PRESSURE_PLATE);
        entries.add(Items.BAMBOO_PRESSURE_PLATE);
        entries.add(Items.CHERRY_PRESSURE_PLATE);
        entries.add(Items.MANGROVE_PRESSURE_PLATE);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_PRESSURE_PLATE);
        //#endif
        entries.add(Items.CRIMSON_PRESSURE_PLATE);
        entries.add(Items.WARPED_PRESSURE_PLATE);
        entries.add(Items.IRON_DOOR);
        entries.add(Items.OAK_DOOR);
        entries.add(Items.SPRUCE_DOOR);
        entries.add(Items.BIRCH_DOOR);
        entries.add(Items.JUNGLE_DOOR);
        entries.add(Items.ACACIA_DOOR);
        entries.add(Items.DARK_OAK_DOOR);
        entries.add(Items.BAMBOO_DOOR);
        entries.add(Items.CHERRY_DOOR);
        entries.add(Items.MANGROVE_DOOR);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_DOOR);
        //#endif
        entries.add(Items.CRIMSON_DOOR);
        entries.add(Items.WARPED_DOOR);
        //#if MC>=12100
        entries.add(Items.COPPER_DOOR);
        entries.add(Items.EXPOSED_COPPER_DOOR);
        entries.add(Items.WEATHERED_COPPER_DOOR);
        entries.add(Items.OXIDIZED_COPPER_DOOR);
        entries.add(Items.WAXED_COPPER_DOOR);
        entries.add(Items.WAXED_EXPOSED_COPPER_DOOR);
        entries.add(Items.WAXED_WEATHERED_COPPER_DOOR);
        entries.add(Items.WAXED_OXIDIZED_COPPER_DOOR);
        //#endif
        entries.add(Items.IRON_TRAPDOOR);
        entries.add(Items.OAK_TRAPDOOR);
        entries.add(Items.SPRUCE_TRAPDOOR);
        entries.add(Items.BIRCH_TRAPDOOR);
        entries.add(Items.JUNGLE_TRAPDOOR);
        entries.add(Items.ACACIA_TRAPDOOR);
        entries.add(Items.DARK_OAK_TRAPDOOR);
        entries.add(Items.BAMBOO_TRAPDOOR);
        entries.add(Items.CHERRY_TRAPDOOR);
        entries.add(Items.MANGROVE_TRAPDOOR);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_TRAPDOOR);
        //#endif
        entries.add(Items.CRIMSON_TRAPDOOR);
        entries.add(Items.WARPED_TRAPDOOR);
        //#if MC>=12100
        entries.add(Items.COPPER_TRAPDOOR);
        entries.add(Items.EXPOSED_COPPER_TRAPDOOR);
        entries.add(Items.WEATHERED_COPPER_TRAPDOOR);
        entries.add(Items.OXIDIZED_COPPER_TRAPDOOR);
        entries.add(Items.WAXED_COPPER_TRAPDOOR);
        entries.add(Items.WAXED_EXPOSED_COPPER_TRAPDOOR);
        entries.add(Items.WAXED_WEATHERED_COPPER_TRAPDOOR);
        entries.add(Items.WAXED_OXIDIZED_COPPER_TRAPDOOR);
        //#endif
        entries.add(Items.OAK_FENCE_GATE);
        entries.add(Items.SPRUCE_FENCE_GATE);
        entries.add(Items.BIRCH_FENCE_GATE);
        entries.add(Items.JUNGLE_FENCE_GATE);
        entries.add(Items.ACACIA_FENCE_GATE);
        entries.add(Items.DARK_OAK_FENCE_GATE);
        entries.add(Items.BAMBOO_FENCE_GATE);
        entries.add(Items.CHERRY_FENCE_GATE);
        entries.add(Items.MANGROVE_FENCE_GATE);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_FENCE_GATE);
        //#endif
        entries.add(Items.CRIMSON_FENCE_GATE);
        entries.add(Items.WARPED_FENCE_GATE);
    }
}
