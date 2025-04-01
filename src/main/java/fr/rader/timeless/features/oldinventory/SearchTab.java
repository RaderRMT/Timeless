package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStackSet;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.Set;

import static net.minecraft.item.ItemGroups.SEARCH;

public class SearchTab extends Tab {

    public SearchTab() {
        super(SEARCH, ItemGroup.Row.TOP, 6, Text.translatable("itemGroup.search"), new ItemStack(Items.COMPASS));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        Set<ItemStack> set = ItemStackSet.create();

        for (ItemGroup itemGroup : getRegistry()) {
            if (itemGroup.getType() == ItemGroup.Type.SEARCH) {
                continue;
            }

            set.addAll(itemGroup.getSearchTabStacks());
        }

        entries.addAll(set);
    }

    @Override
    protected void createItemGroup(ItemGroup.Builder builder) {
        super.createItemGroup(builder);

        builder.special().type(ItemGroup.Type.SEARCH);
        setTexture(builder);
    }

    private void setTexture(ItemGroup.Builder builder) {
        //#if MC>=12100
        builder.texture(ItemGroup.getTabTextureId("item_search"));
        //#else
        //$$ builder.texture("item_search.png");
        //#endif
    }
}
