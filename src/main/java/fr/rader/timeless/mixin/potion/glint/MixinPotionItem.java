package fr.rader.timeless.mixin.potion.glint;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PotionItem.class)
public abstract class MixinPotionItem extends Item {

    public MixinPotionItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        if (!TimelessConfig.get().enablePotionGlint) {
            return super.isFoil(stack);
        }

        PotionContents potionContents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        return potionContents.hasEffects() || super.isFoil(stack);
    }
}
