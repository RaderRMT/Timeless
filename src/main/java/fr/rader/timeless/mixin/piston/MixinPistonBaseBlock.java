package fr.rader.timeless.mixin.piston;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonBaseBlock.class)
public abstract class MixinPistonBaseBlock {

    @Shadow
    protected abstract boolean moveBlocks(final Level level, final BlockPos pistonPos, final Direction direction, final boolean extending);

    @Shadow
    protected abstract boolean getNeighborSignal(final SignalGetter level, final BlockPos pos, final Direction pushDirection);

    @Unique
    private static final int timeless$PISTON_CLUNK_EVENT_ID = 100;

    @Unique
    private boolean timeless$wasPowered = false;

    @Inject(
            method = "checkIfExtend",
            at = @At("TAIL")
    )
    public void timeless$checkIfExtend(final Level level, final BlockPos pos, final BlockState state, CallbackInfo ci) {
        if (!TimelessConfig.get().doPistonClunk) {
            return;
        }

        Direction direction = state.getValue(DirectionalBlock.FACING);

        if (timeless$hasSignal(level, pos, direction)) {
            if (this.timeless$wasPowered) {
                return;
            }
        } else {
            this.timeless$wasPowered = false;
        }

        boolean shouldExtend = getNeighborSignal(level, pos, direction);
        boolean isRetracted = !state.getValue(PistonBaseBlock.EXTENDED);
        boolean canPush = new PistonStructureResolver(level, pos, direction, true).resolve();

        if (shouldExtend && isRetracted && !canPush) {
            level.blockEvent(pos, (PistonBaseBlock) (Object) this, timeless$PISTON_CLUNK_EVENT_ID, direction.get3DDataValue());
        }
    }

    @Inject(
            method = "triggerEvent",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$triggerEvent(final BlockState state, final Level level, BlockPos pos, int type, int data, CallbackInfoReturnable<Boolean> cir) {
        if (type != timeless$PISTON_CLUNK_EVENT_ID) {
            return;
        }

        Direction direction = state.getValue(DirectionalBlock.FACING);

        if (moveBlocks(level, pos, direction, true)) {
            cir.setReturnValue(false);
            return;
        }

        if (!PistonBaseBlock.isPushable(state, level, pos, direction.getOpposite(), false, direction)) {
            cir.setReturnValue(false);
            return;
        }

        level.playSound(null, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.5f, level.getRandom().nextFloat() * 0.25f + 0.4f);
        level.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 0.0, 0.0, 0.0);

        this.timeless$wasPowered = true;

        cir.setReturnValue(true);
    }

    @Unique
    private boolean timeless$hasSignal(SignalGetter level, BlockPos pos, Direction pushDirection) {
        for (Direction direction : Direction.values()) {
            if (direction != pushDirection && level.hasSignal(pos.relative(direction), direction)) {
                return true;
            }
        }

        return false;
    }
}
