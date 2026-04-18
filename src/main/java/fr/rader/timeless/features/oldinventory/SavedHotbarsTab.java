package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class SavedHotbarsTab extends Tab {

    public SavedHotbarsTab() {
        super(CreativeModeTabs.HOTBAR, CreativeModeTab.Row.TOP, 5, Component.translatable("itemGroup.hotbar"), () -> new ItemStack(Blocks.BOOKSHELF));
    }

    @Override
    protected void createItemGroup(CreativeModeTab.Builder builder) {
        builder.alignedRight().type(CreativeModeTab.Type.HOTBAR);
    }
}
