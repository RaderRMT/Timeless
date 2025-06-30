package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.NATURAL;

public class MiscellaneousTab extends Tab {

    public MiscellaneousTab() {
        super(NATURAL, ItemGroup.Row.BOTTOM, 0, Text.translatable("timeless.itemGroup.miscellaneous"), new ItemStack(Items.LAVA_BUCKET));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        entries.add(Items.BEACON);
        entries.add(Items.TURTLE_EGG);
        entries.add(Items.CONDUIT);
        //#if MC>=12100
        entries.add(Items.HEAVY_CORE);
        //#endif
        addScutes(displayContext, entries);
        entries.add(Items.COAL);
        entries.add(Items.CHARCOAL);
        entries.add(Items.DIAMOND);
        entries.add(Items.EMERALD);
        entries.add(Items.LAPIS_LAZULI);
        entries.add(Items.QUARTZ);
        entries.add(Items.AMETHYST_SHARD);
        entries.add(Items.RAW_IRON);
        entries.add(Items.IRON_INGOT);
        entries.add(Items.RAW_COPPER);
        entries.add(Items.COPPER_INGOT);
        entries.add(Items.RAW_GOLD);
        entries.add(Items.GOLD_INGOT);
        entries.add(Items.NETHERITE_INGOT);
        entries.add(Items.NETHERITE_SCRAP);
        entries.add(Items.STICK);
        entries.add(Items.BOWL);
        entries.add(Items.STRING);
        entries.add(Items.FEATHER);
        entries.add(Items.GUNPOWDER);
        entries.add(Items.WHEAT_SEEDS);
        entries.add(Items.WHEAT);
        entries.add(Items.FLINT);
        entries.add(Items.BUCKET);
        entries.add(Items.WATER_BUCKET);
        entries.add(Items.LAVA_BUCKET);
        entries.add(Items.POWDER_SNOW_BUCKET);
        entries.add(Items.SNOWBALL);
        entries.add(Items.LEATHER);
        entries.add(Items.MILK_BUCKET);
        entries.add(Items.PUFFERFISH_BUCKET);
        entries.add(Items.SALMON_BUCKET);
        entries.add(Items.COD_BUCKET);
        entries.add(Items.TROPICAL_FISH_BUCKET);
        entries.add(Items.AXOLOTL_BUCKET);
        entries.add(Items.TADPOLE_BUCKET);
        entries.add(Items.BRICK);
        entries.add(Items.CLAY_BALL);
        //#if MC>=12104
        entries.add(Items.RESIN_BRICK);
        entries.add(Items.RESIN_CLUMP);
        //#endif
        entries.add(Items.PAPER);
        entries.add(Items.BOOK);
        entries.add(Items.SLIME_BALL);
        entries.add(Items.EGG);
        //#if MC>=12106
        entries.add(Items.BLUE_EGG);
        entries.add(Items.BROWN_EGG);
        //#endif
        entries.add(Items.GLOWSTONE_DUST);
        entries.add(Items.INK_SAC);
        entries.add(Items.GLOW_INK_SAC);
        entries.add(Items.COCOA_BEANS);
        entries.add(Items.WHITE_DYE);
        entries.add(Items.ORANGE_DYE);
        entries.add(Items.MAGENTA_DYE);
        entries.add(Items.LIGHT_BLUE_DYE);
        entries.add(Items.YELLOW_DYE);
        entries.add(Items.LIME_DYE);
        entries.add(Items.PINK_DYE);
        entries.add(Items.GRAY_DYE);
        entries.add(Items.LIGHT_GRAY_DYE);
        entries.add(Items.CYAN_DYE);
        entries.add(Items.PURPLE_DYE);
        entries.add(Items.BLUE_DYE);
        entries.add(Items.BROWN_DYE);
        entries.add(Items.GREEN_DYE);
        entries.add(Items.RED_DYE);
        entries.add(Items.BLACK_DYE);
        entries.add(Items.BONE_MEAL);
        entries.add(Items.BONE);
        entries.add(Items.SUGAR);
        entries.add(Items.PUMPKIN_SEEDS);
        entries.add(Items.MELON_SEEDS);
        entries.add(Items.ENDER_PEARL);
        entries.add(Items.BLAZE_ROD);
        //#if MC>=12100
        entries.add(Items.BREEZE_ROD);
        //#endif
        entries.add(Items.GOLD_NUGGET);
        entries.add(Items.NETHER_WART);
        entries.add(Items.ENDER_EYE);
        entries.add(Items.ALLAY_SPAWN_EGG);
        //#if MC>=12005
        entries.add(Items.ARMADILLO_SPAWN_EGG);
        //#endif
        entries.add(Items.AXOLOTL_SPAWN_EGG);
        entries.add(Items.BAT_SPAWN_EGG);
        entries.add(Items.BEE_SPAWN_EGG);
        entries.add(Items.BLAZE_SPAWN_EGG);
        //#if MC>=12100
        entries.add(Items.BOGGED_SPAWN_EGG);
        entries.add(Items.BREEZE_SPAWN_EGG);
        //#endif
        entries.add(Items.CAMEL_SPAWN_EGG);
        entries.add(Items.CAT_SPAWN_EGG);
        entries.add(Items.CAVE_SPIDER_SPAWN_EGG);
        entries.add(Items.CHICKEN_SPAWN_EGG);
        entries.add(Items.COD_SPAWN_EGG);
        entries.add(Items.COW_SPAWN_EGG);
        //#if MC>=12104
        entries.add(Items.CREAKING_SPAWN_EGG);
        //#endif
        entries.add(Items.CREEPER_SPAWN_EGG);
        entries.add(Items.DOLPHIN_SPAWN_EGG);
        entries.add(Items.DONKEY_SPAWN_EGG);
        entries.add(Items.DROWNED_SPAWN_EGG);
        entries.add(Items.ELDER_GUARDIAN_SPAWN_EGG);
        entries.add(Items.ENDER_DRAGON_SPAWN_EGG);
        entries.add(Items.ENDERMAN_SPAWN_EGG);
        entries.add(Items.ENDERMITE_SPAWN_EGG);
        entries.add(Items.EVOKER_SPAWN_EGG);
        entries.add(Items.FOX_SPAWN_EGG);
        entries.add(Items.FROG_SPAWN_EGG);
        entries.add(Items.GHAST_SPAWN_EGG);
        entries.add(Items.GLOW_SQUID_SPAWN_EGG);
        entries.add(Items.GOAT_SPAWN_EGG);
        entries.add(Items.GUARDIAN_SPAWN_EGG);
        //#if MC>=12106
        entries.add(Items.HAPPY_GHAST_SPAWN_EGG);
        //#endif
        entries.add(Items.HOGLIN_SPAWN_EGG);
        entries.add(Items.HORSE_SPAWN_EGG);
        entries.add(Items.HUSK_SPAWN_EGG);
        entries.add(Items.IRON_GOLEM_SPAWN_EGG);
        entries.add(Items.LLAMA_SPAWN_EGG);
        entries.add(Items.MAGMA_CUBE_SPAWN_EGG);
        entries.add(Items.MOOSHROOM_SPAWN_EGG);
        entries.add(Items.MULE_SPAWN_EGG);
        entries.add(Items.OCELOT_SPAWN_EGG);
        entries.add(Items.PANDA_SPAWN_EGG);
        entries.add(Items.PARROT_SPAWN_EGG);
        entries.add(Items.PHANTOM_SPAWN_EGG);
        entries.add(Items.PIG_SPAWN_EGG);
        entries.add(Items.PIGLIN_SPAWN_EGG);
        entries.add(Items.PIGLIN_BRUTE_SPAWN_EGG);
        entries.add(Items.PILLAGER_SPAWN_EGG);
        entries.add(Items.POLAR_BEAR_SPAWN_EGG);
        entries.add(Items.PUFFERFISH_SPAWN_EGG);
        entries.add(Items.RABBIT_SPAWN_EGG);
        entries.add(Items.RAVAGER_SPAWN_EGG);
        entries.add(Items.SALMON_SPAWN_EGG);
        entries.add(Items.SHEEP_SPAWN_EGG);
        entries.add(Items.SHULKER_SPAWN_EGG);
        entries.add(Items.SILVERFISH_SPAWN_EGG);
        entries.add(Items.SKELETON_SPAWN_EGG);
        entries.add(Items.SKELETON_HORSE_SPAWN_EGG);
        entries.add(Items.SLIME_SPAWN_EGG);
        entries.add(Items.SNIFFER_SPAWN_EGG);
        entries.add(Items.SNOW_GOLEM_SPAWN_EGG);
        entries.add(Items.SPIDER_SPAWN_EGG);
        entries.add(Items.SQUID_SPAWN_EGG);
        entries.add(Items.STRAY_SPAWN_EGG);
        entries.add(Items.STRIDER_SPAWN_EGG);
        entries.add(Items.TADPOLE_SPAWN_EGG);
        entries.add(Items.TRADER_LLAMA_SPAWN_EGG);
        entries.add(Items.TROPICAL_FISH_SPAWN_EGG);
        entries.add(Items.TURTLE_SPAWN_EGG);
        entries.add(Items.VEX_SPAWN_EGG);
        entries.add(Items.VILLAGER_SPAWN_EGG);
        entries.add(Items.VINDICATOR_SPAWN_EGG);
        entries.add(Items.WANDERING_TRADER_SPAWN_EGG);
        entries.add(Items.WARDEN_SPAWN_EGG);
        entries.add(Items.WITCH_SPAWN_EGG);
        entries.add(Items.WITHER_SPAWN_EGG);
        entries.add(Items.WITHER_SKELETON_SPAWN_EGG);
        entries.add(Items.WOLF_SPAWN_EGG);
        entries.add(Items.ZOGLIN_SPAWN_EGG);
        entries.add(Items.ZOMBIE_SPAWN_EGG);
        entries.add(Items.ZOMBIE_HORSE_SPAWN_EGG);
        entries.add(Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        entries.add(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
        //#if MC>=12106
        entries.add(Items.DRIED_GHAST);
        //#endif
        entries.add(Items.EXPERIENCE_BOTTLE);
        entries.add(Items.FIRE_CHARGE);
        entries.add(Items.WRITABLE_BOOK);
        entries.add(Items.MAP);
        entries.add(Items.NETHER_STAR);
        addFireworkRockets(displayContext, entries);
        entries.add(Items.FIREWORK_STAR);
        entries.add(Items.NETHER_BRICK);
        entries.add(Items.PRISMARINE_SHARD);
        entries.add(Items.PRISMARINE_CRYSTALS);
        entries.add(Items.RABBIT_HIDE);
        entries.add(Items.IRON_HORSE_ARMOR);
        entries.add(Items.GOLDEN_HORSE_ARMOR);
        entries.add(Items.DIAMOND_HORSE_ARMOR);
        entries.add(Items.LEATHER_HORSE_ARMOR);
        //#if MC>=12005
        entries.add(Items.WOLF_ARMOR);
        //#endif
        entries.add(Items.CHORUS_FRUIT);
        entries.add(Items.POPPED_CHORUS_FRUIT);
        entries.add(Items.BEETROOT_SEEDS);
        entries.add(Items.SHULKER_SHELL);
        entries.add(Items.IRON_NUGGET);
        entries.add(Items.MUSIC_DISC_13);
        entries.add(Items.MUSIC_DISC_CAT);
        entries.add(Items.MUSIC_DISC_BLOCKS);
        entries.add(Items.MUSIC_DISC_CHIRP);
        entries.add(Items.MUSIC_DISC_FAR);
        entries.add(Items.MUSIC_DISC_MALL);
        entries.add(Items.MUSIC_DISC_MELLOHI);
        entries.add(Items.MUSIC_DISC_STAL);
        entries.add(Items.MUSIC_DISC_STRAD);
        entries.add(Items.MUSIC_DISC_WARD);
        entries.add(Items.MUSIC_DISC_11);
        entries.add(Items.MUSIC_DISC_WAIT);
        entries.add(Items.MUSIC_DISC_OTHERSIDE);
        entries.add(Items.MUSIC_DISC_PIGSTEP);
        entries.add(Items.MUSIC_DISC_5);
        entries.add(Items.MUSIC_DISC_RELIC);
        //#if MC>=12100
        entries.add(Items.MUSIC_DISC_PRECIPICE);
        entries.add(Items.MUSIC_DISC_CREATOR);
        entries.add(Items.MUSIC_DISC_CREATOR_MUSIC_BOX);
        //#endif
        //#if MC>=12106
        entries.add(Items.MUSIC_DISC_TEARS);
        //#endif
        //#if MC>=12107
        entries.add(Items.MUSIC_DISC_LAVA_CHICKEN);
        //#endif
        entries.add(Items.DISC_FRAGMENT_5);
        entries.add(Items.NAUTILUS_SHELL);
        entries.add(Items.HEART_OF_THE_SEA);
        entries.add(Items.FLOWER_BANNER_PATTERN);
        entries.add(Items.CREEPER_BANNER_PATTERN);
        entries.add(Items.SKULL_BANNER_PATTERN);
        entries.add(Items.MOJANG_BANNER_PATTERN);
        entries.add(Items.GLOBE_BANNER_PATTERN);
        entries.add(Items.PIGLIN_BANNER_PATTERN);
        //#if MC>=12100
        entries.add(Items.FLOW_BANNER_PATTERN);
        entries.add(Items.GUSTER_BANNER_PATTERN);
        //#endif
        //#if MC>=12102
        entries.add(Items.FIELD_MASONED_BANNER_PATTERN);
        entries.add(Items.BORDURE_INDENTED_BANNER_PATTERN);
        //#endif
        entries.add(Items.HONEYCOMB);
        entries.add(Items.SNIFFER_EGG);
        entries.add(Items.PITCHER_POD);
        entries.add(Items.TORCHFLOWER_SEEDS);
        entries.add(Items.FROGSPAWN);
        entries.add(Items.ECHO_SHARD);
        entries.add(Items.BRUSH);
        entries.add(Items.ANGLER_POTTERY_SHERD);
        entries.add(Items.ARCHER_POTTERY_SHERD);
        entries.add(Items.ARMS_UP_POTTERY_SHERD);
        entries.add(Items.BLADE_POTTERY_SHERD);
        entries.add(Items.BREWER_POTTERY_SHERD);
        entries.add(Items.BURN_POTTERY_SHERD);
        entries.add(Items.DANGER_POTTERY_SHERD);
        entries.add(Items.EXPLORER_POTTERY_SHERD);
        //#if MC>=12100
        entries.add(Items.FLOW_POTTERY_SHERD);
        //#endif
        entries.add(Items.FRIEND_POTTERY_SHERD);
        //#if MC>=12100
        entries.add(Items.GUSTER_POTTERY_SHERD);
        //#endif
        entries.add(Items.HEART_POTTERY_SHERD);
        entries.add(Items.HEARTBREAK_POTTERY_SHERD);
        entries.add(Items.HOWL_POTTERY_SHERD);
        entries.add(Items.MINER_POTTERY_SHERD);
        entries.add(Items.MOURNER_POTTERY_SHERD);
        entries.add(Items.PLENTY_POTTERY_SHERD);
        entries.add(Items.PRIZE_POTTERY_SHERD);
        //#if MC>=12100
        entries.add(Items.SCRAPE_POTTERY_SHERD);
        //#endif
        entries.add(Items.SHEAF_POTTERY_SHERD);
        entries.add(Items.SHELTER_POTTERY_SHERD);
        entries.add(Items.SKULL_POTTERY_SHERD);
        entries.add(Items.SNORT_POTTERY_SHERD);
        //#if MC>=12100
        entries.add(Items.TRIAL_KEY);
        entries.add(Items.OMINOUS_TRIAL_KEY);
        entries.add(Items.WIND_CHARGE);
        //#endif
    }

    private void addScutes(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        //#if MC>=12005
        entries.add(Items.TURTLE_SCUTE);
        entries.add(Items.ARMADILLO_SCUTE);
        //#else
        //$$ entries.add(Items.SCUTE);
        //#endif
    }

    private void addFireworkRockets(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        //#if MC<12005
        //$$ entries.add(Items.FIREWORK_ROCKET);
        //#endif
        ItemGroups.addFireworkRockets(entries, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
    }
}
