package fr.rader.timeless.mixin.potion.glint;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;

//#if MC>=12005
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
//#else
//$$ import net.minecraft.potion.PotionUtil;
//#endif

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

        //#if MC>=12005
        PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
        return potionContentsComponent.hasEffects() || super.hasGlint(stack);
        //#else
        //$$ return !PotionUtil.getPotionEffects(stack).isEmpty() || super.hasGlint(stack);
        //#endif
    }
}
