package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import static net.minecraft.item.ItemGroups.OPERATOR;

public class OperatorTab extends Tab {

    public OperatorTab() {
        super(OPERATOR, ItemGroup.Row.TOP, -1, Text.literal("itemGroup.op"), new ItemStack(Items.COMMAND_BLOCK));
    }

    @Override
    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
    }
}
