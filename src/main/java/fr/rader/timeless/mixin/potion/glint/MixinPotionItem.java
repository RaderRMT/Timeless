package fr.rader.timeless.mixin.potion.glint;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PotionItem.class)
public abstract class MixinPotionItem extends Item {

    protected MixinPotionItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if (!TimelessConfig.get().enablePotionGlint) {
            return super.hasGlint(stack);
        }

        return !PotionUtil.getPotionEffects(stack).isEmpty() || super.hasGlint(stack);
    }
}
