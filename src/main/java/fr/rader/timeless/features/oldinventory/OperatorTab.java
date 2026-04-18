package fr.rader.timeless.features.oldinventory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class OperatorTab extends Tab {

    public OperatorTab() {
        super(CreativeModeTabs.OP_BLOCKS, CreativeModeTab.Row.TOP, -1, Component.literal("itemGroup.op"), () -> new ItemStack(Items.COMMAND_BLOCK));
    }
}
