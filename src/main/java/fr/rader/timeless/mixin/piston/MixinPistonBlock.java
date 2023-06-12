package fr.rader.timeless.mixin.piston;

import fr.rader.timeless.Timeless;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//#if MC>=12000
import net.minecraft.world.RedstoneView;
//#endif

@Mixin(PistonBlock.class)
public abstract class MixinPistonBlock {

    @Shadow
    protected abstract boolean move(World world, BlockPos pos, Direction dir, boolean retract);

    @Shadow
    //#if MC>=12000
    protected abstract boolean shouldExtend(RedstoneView world, BlockPos pos, Direction pistonFace);
    //#else
    //$$ protected abstract boolean shouldExtend(World world, BlockPos pos, Direction pistonFace);
    //#endif

    private static final int PISTON_CLUNK_EVENT_ID = 100;

    private boolean wasPowered = false;

    @Inject(
            method = "tryMove",
            at = @At("TAIL")
    )
    public void tryMove(World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (!Timeless.getConfig().doPistonClunk) {
            return;
        }

        if (world.isReceivingRedstonePower(pos)) {
            if (this.wasPowered) {
                return;
            }
        } else {
            this.wasPowered = false;
        }

        Direction direction = state.get(PistonBlock.FACING);

        boolean shouldExtend = shouldExtend(world, pos, direction);
        boolean isRetracted = !state.get(PistonBlock.EXTENDED);
        boolean canPush = new PistonHandler(world, pos, direction, true).calculatePush();

        if (shouldExtend && isRetracted && !canPush) {
            world.addSyncedBlockEvent(pos, (PistonBlock) (Object) this, PISTON_CLUNK_EVENT_ID, direction.getId());
        }
    }

    @Inject(
            method = "onSyncedBlockEvent",
            at = @At("HEAD"),
            cancellable = true
    )
    public void playClunkSound(BlockState state, World world, BlockPos pos, int type, int data, CallbackInfoReturnable<Boolean> cir) {
        if (type != PISTON_CLUNK_EVENT_ID) {
            return;
        }

        Direction direction = state.get(PistonBlock.FACING);

        if (move(world, pos, direction, true)) {
            cir.setReturnValue(false);
            return;
        }

        if (!PistonBlock.isMovable(state, world, pos, direction.getOpposite(), false, direction)) {
            cir.setReturnValue(false);
            return;
        }

        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.5f, world.random.nextFloat() * 0.25f + 0.4f);
        world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 0.0, 0.0, 0.0);

        this.wasPowered = true;

        cir.setReturnValue(true);
    }
}
