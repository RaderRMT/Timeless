package fr.rader.timeless.features.oldinventory;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.text.Text;
import net.minecraft.village.raid.Raid;

import static net.minecraft.item.ItemGroups.COLORED_BLOCKS;

public class DecorationBlocksTab extends Tab {

    public DecorationBlocksTab() {
        super(COLORED_BLOCKS, ItemGroup.Row.TOP, 1, Text.translatable("timeless.itemGroup.decorationBlocks"), new ItemStack(Blocks.PEONY));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.OAK_SAPLING);
        entries.add(Items.SPRUCE_SAPLING);
        entries.add(Items.BIRCH_SAPLING);
        entries.add(Items.JUNGLE_SAPLING);
        entries.add(Items.ACACIA_SAPLING);
        entries.add(Items.DARK_OAK_SAPLING);
        entries.add(Items.CHERRY_SAPLING);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_SAPLING);
        //#endif
        entries.add(Items.MANGROVE_PROPAGULE);
        entries.add(Items.OAK_LEAVES);
        entries.add(Items.SPRUCE_LEAVES);
        entries.add(Items.BIRCH_LEAVES);
        entries.add(Items.JUNGLE_LEAVES);
        entries.add(Items.ACACIA_LEAVES);
        entries.add(Items.DARK_OAK_LEAVES);
        entries.add(Items.AZALEA_LEAVES);
        entries.add(Items.FLOWERING_AZALEA_LEAVES);
        entries.add(Items.CHERRY_LEAVES);
        entries.add(Items.MANGROVE_LEAVES);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_LEAVES);
        //#endif
        entries.add(Items.COBWEB);
        //#if MC>=12004
        entries.add(Items.SHORT_GRASS);
        //#else
        //$$ entries.add(Items.GRASS);
        //#endif
        entries.add(Items.FERN);
        //#if MC>=12105
        entries.add(Items.BUSH);
        entries.add(Items.FIREFLY_BUSH);
        entries.add(Items.LEAF_LITTER);
        //#endif
        entries.add(Items.AZALEA);
        entries.add(Items.FLOWERING_AZALEA);
        entries.add(Items.DEAD_BUSH);
        entries.add(Items.SEAGRASS);
        entries.add(Items.SEA_PICKLE);
        entries.add(Items.DANDELION);
        entries.add(Items.POPPY);
        entries.add(Items.BLUE_ORCHID);
        entries.add(Items.ALLIUM);
        entries.add(Items.AZURE_BLUET);
        entries.add(Items.RED_TULIP);
        entries.add(Items.ORANGE_TULIP);
        entries.add(Items.WHITE_TULIP);
        entries.add(Items.PINK_TULIP);
        entries.add(Items.OXEYE_DAISY);
        entries.add(Items.CORNFLOWER);
        entries.add(Items.LILY_OF_THE_VALLEY);
        //#if MC>=12104
        entries.add(Items.CLOSED_EYEBLOSSOM);
        entries.add(Items.OPEN_EYEBLOSSOM);
        //#endif
        entries.add(Items.WITHER_ROSE);
        entries.add(Items.TORCHFLOWER);
        entries.add(Items.SPORE_BLOSSOM);
        //#if MC>=12105
        entries.add(Items.CACTUS_FLOWER);
        //#endif
        entries.add(Items.BROWN_MUSHROOM);
        entries.add(Items.RED_MUSHROOM);
        entries.add(Items.CRIMSON_FUNGUS);
        entries.add(Items.WARPED_FUNGUS);
        entries.add(Items.PINK_PETALS);
        //#if MC>=12105
        entries.add(Items.WILDFLOWERS);
        //#endif
        entries.add(Items.CRIMSON_ROOTS);
        entries.add(Items.WARPED_ROOTS);
        entries.add(Items.NETHER_SPROUTS);
        entries.add(Items.WEEPING_VINES);
        entries.add(Items.TWISTING_VINES);
        entries.add(Items.SUGAR_CANE);
        entries.add(Items.KELP);
        entries.add(Items.MOSS_CARPET);
        entries.add(Items.MOSS_BLOCK);
        //#if MC>=12104
        entries.add(Items.PALE_MOSS_CARPET);
        entries.add(Items.PALE_MOSS_BLOCK);
        //#endif
        entries.add(Items.HANGING_ROOTS);
        //#if MC>=12104
        entries.add(Items.PALE_HANGING_MOSS);
        //#endif
        entries.add(Items.BIG_DRIPLEAF);
        entries.add(Items.SMALL_DRIPLEAF);
        //#if MC>=12105
        entries.add(Items.TALL_DRY_GRASS);
        entries.add(Items.SHORT_DRY_GRASS);
        //#endif
        entries.add(Items.BAMBOO);
        entries.add(Items.TORCH);
        entries.add(Items.END_ROD);
        entries.add(Items.CHORUS_PLANT);
        entries.add(Items.CHORUS_FLOWER);
        entries.add(Items.CHEST);
        entries.add(Items.CRAFTING_TABLE);
        entries.add(Items.FARMLAND);
        entries.add(Items.FURNACE);
        entries.add(Items.LADDER);
        entries.add(Items.SNOW);
        entries.add(Items.CACTUS);
        entries.add(Items.JUKEBOX);
        entries.add(Items.OAK_FENCE);
        entries.add(Items.SPRUCE_FENCE);
        entries.add(Items.BIRCH_FENCE);
        entries.add(Items.JUNGLE_FENCE);
        entries.add(Items.ACACIA_FENCE);
        entries.add(Items.DARK_OAK_FENCE);
        entries.add(Items.BAMBOO_FENCE);
        entries.add(Items.CHERRY_FENCE);
        entries.add(Items.MANGROVE_FENCE);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_FENCE);
        //#endif
        entries.add(Items.CRIMSON_FENCE);
        entries.add(Items.WARPED_FENCE);
        entries.add(Items.SOUL_TORCH);
        entries.add(Items.INFESTED_STONE);
        entries.add(Items.INFESTED_COBBLESTONE);
        entries.add(Items.INFESTED_STONE_BRICKS);
        entries.add(Items.INFESTED_MOSSY_STONE_BRICKS);
        entries.add(Items.INFESTED_CRACKED_STONE_BRICKS);
        entries.add(Items.INFESTED_CHISELED_STONE_BRICKS);
        entries.add(Items.INFESTED_DEEPSLATE);
        entries.add(Items.BROWN_MUSHROOM_BLOCK);
        entries.add(Items.RED_MUSHROOM_BLOCK);
        entries.add(Items.MUSHROOM_STEM);
        entries.add(Items.IRON_BARS);
        entries.add(Items.CHAIN);
        entries.add(Items.GLASS_PANE);
        entries.add(Items.VINE);
        entries.add(Items.GLOW_LICHEN);
        entries.add(Items.LILY_PAD);
        entries.add(Items.NETHER_BRICK_FENCE);
        entries.add(Items.ENCHANTING_TABLE);
        entries.add(Items.END_PORTAL_FRAME);
        entries.add(Items.ENDER_CHEST);
        entries.add(Items.COBBLESTONE_WALL);
        entries.add(Items.MOSSY_COBBLESTONE_WALL);
        entries.add(Items.BRICK_WALL);
        entries.add(Items.PRISMARINE_WALL);
        entries.add(Items.RED_SANDSTONE_WALL);
        entries.add(Items.MOSSY_STONE_BRICK_WALL);
        entries.add(Items.GRANITE_WALL);
        entries.add(Items.STONE_BRICK_WALL);
        entries.add(Items.NETHER_BRICK_WALL);
        entries.add(Items.ANDESITE_WALL);
        entries.add(Items.RED_NETHER_BRICK_WALL);
        entries.add(Items.SANDSTONE_WALL);
        entries.add(Items.END_STONE_BRICK_WALL);
        entries.add(Items.DIORITE_WALL);
        entries.add(Items.BLACKSTONE_WALL);
        entries.add(Items.POLISHED_BLACKSTONE_WALL);
        entries.add(Items.POLISHED_BLACKSTONE_BRICK_WALL);
        entries.add(Items.COBBLED_DEEPSLATE_WALL);
        entries.add(Items.POLISHED_DEEPSLATE_WALL);
        entries.add(Items.DEEPSLATE_BRICK_WALL);
        entries.add(Items.DEEPSLATE_TILE_WALL);
        entries.add(Items.MUD_BRICK_WALL);
        //#if MC>=12100
        entries.add(Items.TUFF_WALL);
        entries.add(Items.POLISHED_TUFF_WALL);
        entries.add(Items.TUFF_BRICK_WALL);
        //#endif
        //#if MC>=12104
        entries.add(Items.RESIN_BRICK_WALL);
        //#endif
        entries.add(Items.ANVIL);
        entries.add(Items.CHIPPED_ANVIL);
        entries.add(Items.DAMAGED_ANVIL);
        entries.add(Items.WHITE_CARPET);
        entries.add(Items.ORANGE_CARPET);
        entries.add(Items.MAGENTA_CARPET);
        entries.add(Items.LIGHT_BLUE_CARPET);
        entries.add(Items.YELLOW_CARPET);
        entries.add(Items.LIME_CARPET);
        entries.add(Items.PINK_CARPET);
        entries.add(Items.GRAY_CARPET);
        entries.add(Items.LIGHT_GRAY_CARPET);
        entries.add(Items.CYAN_CARPET);
        entries.add(Items.PURPLE_CARPET);
        entries.add(Items.BLUE_CARPET);
        entries.add(Items.BROWN_CARPET);
        entries.add(Items.GREEN_CARPET);
        entries.add(Items.RED_CARPET);
        entries.add(Items.BLACK_CARPET);
        entries.add(Items.DIRT_PATH);
        entries.add(Items.SUNFLOWER);
        entries.add(Items.LILAC);
        entries.add(Items.ROSE_BUSH);
        entries.add(Items.PEONY);
        entries.add(Items.TALL_GRASS);
        entries.add(Items.LARGE_FERN);
        entries.add(Items.PITCHER_PLANT);
        entries.add(Items.WHITE_STAINED_GLASS_PANE);
        entries.add(Items.ORANGE_STAINED_GLASS_PANE);
        entries.add(Items.MAGENTA_STAINED_GLASS_PANE);
        entries.add(Items.LIGHT_BLUE_STAINED_GLASS_PANE);
        entries.add(Items.YELLOW_STAINED_GLASS_PANE);
        entries.add(Items.LIME_STAINED_GLASS_PANE);
        entries.add(Items.PINK_STAINED_GLASS_PANE);
        entries.add(Items.GRAY_STAINED_GLASS_PANE);
        entries.add(Items.LIGHT_GRAY_STAINED_GLASS_PANE);
        entries.add(Items.CYAN_STAINED_GLASS_PANE);
        entries.add(Items.PURPLE_STAINED_GLASS_PANE);
        entries.add(Items.BLUE_STAINED_GLASS_PANE);
        entries.add(Items.BROWN_STAINED_GLASS_PANE);
        entries.add(Items.GREEN_STAINED_GLASS_PANE);
        entries.add(Items.RED_STAINED_GLASS_PANE);
        entries.add(Items.BLACK_STAINED_GLASS_PANE);
        entries.add(Items.SHULKER_BOX);
        entries.add(Items.WHITE_SHULKER_BOX);
        entries.add(Items.ORANGE_SHULKER_BOX);
        entries.add(Items.MAGENTA_SHULKER_BOX);
        entries.add(Items.LIGHT_BLUE_SHULKER_BOX);
        entries.add(Items.YELLOW_SHULKER_BOX);
        entries.add(Items.LIME_SHULKER_BOX);
        entries.add(Items.PINK_SHULKER_BOX);
        entries.add(Items.GRAY_SHULKER_BOX);
        entries.add(Items.LIGHT_GRAY_SHULKER_BOX);
        entries.add(Items.CYAN_SHULKER_BOX);
        entries.add(Items.PURPLE_SHULKER_BOX);
        entries.add(Items.BLUE_SHULKER_BOX);
        entries.add(Items.BROWN_SHULKER_BOX);
        entries.add(Items.GREEN_SHULKER_BOX);
        entries.add(Items.RED_SHULKER_BOX);
        entries.add(Items.BLACK_SHULKER_BOX);
        entries.add(Items.WHITE_GLAZED_TERRACOTTA);
        entries.add(Items.ORANGE_GLAZED_TERRACOTTA);
        entries.add(Items.MAGENTA_GLAZED_TERRACOTTA);
        entries.add(Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
        entries.add(Items.YELLOW_GLAZED_TERRACOTTA);
        entries.add(Items.LIME_GLAZED_TERRACOTTA);
        entries.add(Items.PINK_GLAZED_TERRACOTTA);
        entries.add(Items.GRAY_GLAZED_TERRACOTTA);
        entries.add(Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
        entries.add(Items.CYAN_GLAZED_TERRACOTTA);
        entries.add(Items.PURPLE_GLAZED_TERRACOTTA);
        entries.add(Items.BLUE_GLAZED_TERRACOTTA);
        entries.add(Items.BROWN_GLAZED_TERRACOTTA);
        entries.add(Items.GREEN_GLAZED_TERRACOTTA);
        entries.add(Items.RED_GLAZED_TERRACOTTA);
        entries.add(Items.BLACK_GLAZED_TERRACOTTA);
        entries.add(Items.TUBE_CORAL);
        entries.add(Items.BRAIN_CORAL);
        entries.add(Items.BUBBLE_CORAL);
        entries.add(Items.FIRE_CORAL);
        entries.add(Items.HORN_CORAL);
        entries.add(Items.DEAD_BRAIN_CORAL);
        entries.add(Items.DEAD_BUBBLE_CORAL);
        entries.add(Items.DEAD_FIRE_CORAL);
        entries.add(Items.DEAD_HORN_CORAL);
        entries.add(Items.DEAD_TUBE_CORAL);
        entries.add(Items.TUBE_CORAL_FAN);
        entries.add(Items.BRAIN_CORAL_FAN);
        entries.add(Items.BUBBLE_CORAL_FAN);
        entries.add(Items.FIRE_CORAL_FAN);
        entries.add(Items.HORN_CORAL_FAN);
        entries.add(Items.DEAD_TUBE_CORAL_FAN);
        entries.add(Items.DEAD_BRAIN_CORAL_FAN);
        entries.add(Items.DEAD_BUBBLE_CORAL_FAN);
        entries.add(Items.DEAD_FIRE_CORAL_FAN);
        entries.add(Items.DEAD_HORN_CORAL_FAN);
        entries.add(Items.SCAFFOLDING);
        entries.add(Items.PAINTING);
        addPaintingVariants(displayContext, entries);
        entries.add(Items.OAK_SIGN);
        entries.add(Items.OAK_HANGING_SIGN);
        entries.add(Items.SPRUCE_SIGN);
        entries.add(Items.SPRUCE_HANGING_SIGN);
        entries.add(Items.BIRCH_SIGN);
        entries.add(Items.BIRCH_HANGING_SIGN);
        entries.add(Items.JUNGLE_SIGN);
        entries.add(Items.JUNGLE_HANGING_SIGN);
        entries.add(Items.ACACIA_SIGN);
        entries.add(Items.ACACIA_HANGING_SIGN);
        entries.add(Items.DARK_OAK_SIGN);
        entries.add(Items.DARK_OAK_HANGING_SIGN);
        entries.add(Items.BAMBOO_SIGN);
        entries.add(Items.BAMBOO_HANGING_SIGN);
        entries.add(Items.CHERRY_SIGN);
        entries.add(Items.CHERRY_HANGING_SIGN);
        entries.add(Items.MANGROVE_SIGN);
        entries.add(Items.MANGROVE_HANGING_SIGN);
        //#if MC>=12104
        entries.add(Items.PALE_OAK_SIGN);
        entries.add(Items.PALE_OAK_HANGING_SIGN);
        //#endif
        entries.add(Items.CRIMSON_SIGN);
        entries.add(Items.CRIMSON_HANGING_SIGN);
        entries.add(Items.WARPED_SIGN);
        entries.add(Items.WARPED_HANGING_SIGN);
        entries.add(Items.WHITE_BED);
        entries.add(Items.ORANGE_BED);
        entries.add(Items.MAGENTA_BED);
        entries.add(Items.LIGHT_BLUE_BED);
        entries.add(Items.YELLOW_BED);
        entries.add(Items.LIME_BED);
        entries.add(Items.PINK_BED);
        entries.add(Items.GRAY_BED);
        entries.add(Items.LIGHT_GRAY_BED);
        entries.add(Items.CYAN_BED);
        entries.add(Items.PURPLE_BED);
        entries.add(Items.BLUE_BED);
        entries.add(Items.BROWN_BED);
        entries.add(Items.GREEN_BED);
        entries.add(Items.RED_BED);
        entries.add(Items.BLACK_BED);
        entries.add(Items.ITEM_FRAME);
        entries.add(Items.GLOW_ITEM_FRAME);
        entries.add(Items.FLOWER_POT);
        entries.add(Items.SKELETON_SKULL);
        entries.add(Items.WITHER_SKELETON_SKULL);
        entries.add(Items.PLAYER_HEAD);
        entries.add(Items.ZOMBIE_HEAD);
        entries.add(Items.CREEPER_HEAD);
        entries.add(Items.PIGLIN_HEAD);
        entries.add(Items.DRAGON_HEAD);
        entries.add(Items.ARMOR_STAND);
        entries.add(Items.WHITE_BANNER);
        entries.add(Items.ORANGE_BANNER);
        entries.add(Items.MAGENTA_BANNER);
        entries.add(Items.LIGHT_BLUE_BANNER);
        entries.add(Items.YELLOW_BANNER);
        entries.add(Items.LIME_BANNER);
        entries.add(Items.PINK_BANNER);
        entries.add(Items.GRAY_BANNER);
        entries.add(Items.LIGHT_GRAY_BANNER);
        entries.add(Items.CYAN_BANNER);
        entries.add(Items.PURPLE_BANNER);
        entries.add(Items.BLUE_BANNER);
        entries.add(Items.BROWN_BANNER);
        entries.add(Items.GREEN_BANNER);
        entries.add(Items.RED_BANNER);
        entries.add(Items.BLACK_BANNER);
        addOminousBanner(displayContext, entries);
        entries.add(Items.END_CRYSTAL);
        entries.add(Items.LOOM);
        entries.add(Items.COMPOSTER);
        entries.add(Items.BARREL);
        entries.add(Items.SMOKER);
        entries.add(Items.BLAST_FURNACE);
        entries.add(Items.CARTOGRAPHY_TABLE);
        entries.add(Items.FLETCHING_TABLE);
        entries.add(Items.GRINDSTONE);
        entries.add(Items.SMITHING_TABLE);
        entries.add(Items.STONECUTTER);
        entries.add(Items.BELL);
        entries.add(Items.LANTERN);
        entries.add(Items.SOUL_LANTERN);
        entries.add(Items.CAMPFIRE);
        entries.add(Items.SOUL_CAMPFIRE);
        entries.add(Items.SHROOMLIGHT);
        entries.add(Items.BEE_NEST);
        entries.add(Items.BEEHIVE);
        entries.add(Items.HONEYCOMB_BLOCK);
        entries.add(Items.LODESTONE);
        entries.add(Items.RESPAWN_ANCHOR);
        entries.add(Items.CANDLE);
        entries.add(Items.WHITE_CANDLE);
        entries.add(Items.ORANGE_CANDLE);
        entries.add(Items.MAGENTA_CANDLE);
        entries.add(Items.LIGHT_BLUE_CANDLE);
        entries.add(Items.YELLOW_CANDLE);
        entries.add(Items.LIME_CANDLE);
        entries.add(Items.PINK_CANDLE);
        entries.add(Items.GRAY_CANDLE);
        entries.add(Items.LIGHT_GRAY_CANDLE);
        entries.add(Items.CYAN_CANDLE);
        entries.add(Items.PURPLE_CANDLE);
        entries.add(Items.BLUE_CANDLE);
        entries.add(Items.BROWN_CANDLE);
        entries.add(Items.GREEN_CANDLE);
        entries.add(Items.RED_CANDLE);
        entries.add(Items.BLACK_CANDLE);
        entries.add(Items.SMALL_AMETHYST_BUD);
        entries.add(Items.MEDIUM_AMETHYST_BUD);
        entries.add(Items.LARGE_AMETHYST_BUD);
        entries.add(Items.AMETHYST_CLUSTER);
        entries.add(Items.POINTED_DRIPSTONE);
        entries.add(Items.DECORATED_POT);
        entries.add(Items.DRAGON_EGG);
        entries.add(Items.MANGROVE_ROOTS);
        entries.add(Items.SCULK);
        entries.add(Items.SCULK_VEIN);
        entries.add(Items.SCULK_CATALYST);
        entries.add(Items.OCHRE_FROGLIGHT);
        entries.add(Items.PEARLESCENT_FROGLIGHT);
        entries.add(Items.VERDANT_FROGLIGHT);
        //#if MC>=12100
        entries.add(Items.VAULT);
        //#endif
    }

    private void addPaintingVariants(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        getOptional(displayContext, RegistryKeys.PAINTING_VARIANT)
                .ifPresent(
                        wrapper -> ItemGroups.addPaintings(
                                entries,
                                //#if MC>=12100
                                displayContext.lookup(),
                                //#endif
                                wrapper,
                                registryEntry -> registryEntry.isIn(PaintingVariantTags.PLACEABLE),
                                ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS
                        )
                );
    }

    private void addOminousBanner(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        //#if MC>=12102
        entries.add(Raid.createOminousBanner(displayContext.lookup().getOrThrow(RegistryKeys.BANNER_PATTERN)));
        //#elseif MC>=12005
        //$$ entries.add(Raid.getOminousBanner(displayContext.lookup().getWrapperOrThrow(RegistryKeys.BANNER_PATTERN)));
        //#else
        //$$ entries.add(Raid.getOminousBanner());
        //#endif
    }
}
