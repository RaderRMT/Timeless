package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.Set;

public class SearchTab extends Tab {

    public SearchTab() {
        super(CreativeModeTabs.SEARCH, CreativeModeTab.Row.TOP, 6, Component.translatable("itemGroup.search"), () -> new ItemStack(Items.COMPASS));
    }

    @Override
    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
        Set<ItemStack> set = ItemStackLinkedSet.createTypeAndComponentsSet();

        for (CreativeModeTab tab : getRegistry()) {
            if (tab.getType() == CreativeModeTab.Type.SEARCH) {
                continue;
            }

            set.addAll(tab.getSearchTabDisplayItems());
        }

        entries.acceptAll(set);
    }

    @Override
    protected void createItemGroup(CreativeModeTab.Builder builder) {
        super.createItemGroup(builder);

        builder.alignedRight()
                .type(CreativeModeTab.Type.SEARCH)
                .backgroundTexture(CreativeModeTabs.SEARCH_BACKGROUND);
    }
}
