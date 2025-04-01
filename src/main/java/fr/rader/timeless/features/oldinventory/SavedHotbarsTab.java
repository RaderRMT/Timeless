package fr.rader.timeless.features.oldinventory;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.HOTBAR;

public class SavedHotbarsTab extends Tab {

    public SavedHotbarsTab() {
        super(HOTBAR, ItemGroup.Row.TOP, 5, Text.translatable("itemGroup.hotbar"), new ItemStack(Blocks.BOOKSHELF));
    }

    @Override
    protected void createItemGroup(ItemGroup.Builder builder) {
        builder.special().type(ItemGroup.Type.HOTBAR);
    }
}
