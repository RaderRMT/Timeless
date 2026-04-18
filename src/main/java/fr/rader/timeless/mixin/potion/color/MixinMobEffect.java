package fr.rader.timeless.mixin.potion.color;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.world.effect.MobEffect;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(MobEffect.class)
public abstract class MixinMobEffect {

    @Shadow
    private @Nullable String descriptionId;

    @Unique
    private static final Map<String, Integer> timeless$POTION_COLORS = Map.ofEntries(
            Map.entry("effect.minecraft.speed", 0x7CAFC6),
            Map.entry("effect.minecraft.slowness", 0x5A6C81),
            Map.entry("effect.minecraft.haste", 0xD9C043),
            Map.entry("effect.minecraft.mining_fatigue", 0x4A4217),
            Map.entry("effect.minecraft.strength", 0x932423),
            Map.entry("effect.minecraft.instant_health", 0xF82423),
            Map.entry("effect.minecraft.instant_damage", 0x430A09),
            Map.entry("effect.minecraft.jump_boost", 0x22FF4C),
            Map.entry("effect.minecraft.nausea", 0x551D4A),
            Map.entry("effect.minecraft.regeneration", 0xCD5CAB),
            Map.entry("effect.minecraft.resistance", 0x99453A),
            Map.entry("effect.minecraft.fire_resistance", 0xE49A3A),
            Map.entry("effect.minecraft.water_breathing", 0x2E5299),
            Map.entry("effect.minecraft.invisibility", 0x7D8392),
            Map.entry("effect.minecraft.blindness", 0x1F1F23),
            Map.entry("effect.minecraft.night_vision", 0x1F1FA1),
            Map.entry("effect.minecraft.hunger", 0x587653),
            Map.entry("effect.minecraft.weakness", 0x484D48),
            Map.entry("effect.minecraft.poison", 0x4E9331),
            Map.entry("effect.minecraft.wither", 0x352A27),
            Map.entry("effect.minecraft.health_boost", 0xF87D23),
            Map.entry("effect.minecraft.absorption", 0x2552A5),
            Map.entry("effect.minecraft.saturation", 0xF82423),
            Map.entry("effect.minecraft.glowing", 0x94A061),
            Map.entry("effect.minecraft.levitation", 0xCEFFFF),
            Map.entry("effect.minecraft.luck", 0x339900),
            Map.entry("effect.minecraft.unluck", 0xC0A44D),
            Map.entry("effect.minecraft.slow_falling", 0xFFEFD1),
            Map.entry("effect.minecraft.conduit_power", 0x1DC2D1),
            Map.entry("effect.minecraft.dolphins_grace", 0x88A3BE),
            Map.entry("effect.minecraft.bad_omen", 0x0B6138),
            Map.entry("effect.minecraft.hero_of_the_village", 0x44FF44),
            Map.entry("effect.minecraft.darkness", 0x292721)
    );

    @Inject(
            method = "getColor",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$getColor(CallbackInfoReturnable<Integer> cir) {
        if (!TimelessConfig.get().useOldPotionColors) {
            return;
        }

        if (this.descriptionId != null && timeless$POTION_COLORS.containsKey(this.descriptionId))
        {
            cir.setReturnValue(timeless$POTION_COLORS.get(this.descriptionId));
        }
    }
}
