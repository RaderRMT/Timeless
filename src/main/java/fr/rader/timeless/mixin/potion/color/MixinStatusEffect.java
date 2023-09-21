package fr.rader.timeless.mixin.potion.color;

import fr.rader.timeless.Timeless;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StatusEffect.class)
public abstract class MixinStatusEffect {

    @Unique
    private static final int[] POTION_COLORS = {
            0x7CAFC6,   // Speed
            0x5A6C81,   // Slowness
            0xD9C043,   // Haste
            0x4A4217,   // Mining Fatigue
            0x932423,   // Strength
            0xF82423,   // Instant Health
            0x430A09,   // Instant Damage
            0x22FF4C,   // Jump Boost
            0x551D4A,   // Nausea
            0xCD5CAB,   // Regeneration
            0x99453A,   // Resistance
            0xE49A3A,   // Fire Resistance
            0x2E5299,   // Water Breathing
            0x7D8392,   // Invisibility
            0x1F1F23,   // Blindness
            0x1F1FA1,   // Night Vision
            0x587653,   // Hunger
            0x484D48,   // Weakness
            0x4E9331,   // Poison
            0x352A27,   // Wither
            0xF87D23,   // Health Boost
            0x2552A5,   // Absorption
            0xF82423,   // Saturation
            0x94A061,   // Glowing
            0xCEFFFF,   // Levitation
            0x339900,   // Luck
            0xC0A44D,   // Unluck
            0xFFEFD1,   // Slow Falling
            0x1DC2D1,   // Conduit Power
            0x88A3BE,   // Dolphins Grace
            0x0B6138,   // Bad Omen
            0x44FF44,   // Hero Of The Village
            0x292721    // Darkness
    };

    @Inject(
            method = "getColor",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getColor(CallbackInfoReturnable<Integer> cir) {
        if (!Timeless.getConfig().useOldPotionColors) {
            return;
        }

        // we have to subtract 1 because potion id starts at 1
        //#if MC>=12002
        int id = Registries.STATUS_EFFECT.getRawId(((StatusEffect) (Object) this));
        //#else
        //$$int id = StatusEffect.getRawId((StatusEffect) (Object) this) - 1;
        //#endif
        cir.setReturnValue(POTION_COLORS[id]);
    }
}
