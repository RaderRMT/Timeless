//#if MC>=12004
package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.Timeless;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(BatEntityModel.class)
public abstract class MixinBatEntityModel extends SinglePartEntityModel<BatEntity> {

    @Final @Shadow private ModelPart head;
    @Final @Shadow private ModelPart body;
    @Final @Shadow private ModelPart rightWing;
    @Final @Shadow private ModelPart leftWing;
    @Final @Shadow private ModelPart rightWingTip;
    @Final @Shadow private ModelPart leftWingTip;

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/SinglePartEntityModel;<init>(Ljava/util/function/Function;)V"
            )
    )
    private static Function<Identifier, RenderLayer> test(Function<Identifier, RenderLayer> function) {
        if (!Timeless.getConfig().useOldBatModel) {
            return function;
        }

        return RenderLayer::getEntityCutoutNoCull;
    }

    @Inject(
            method = "getTexturedModelData",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void timeless$getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir) {
        if (!Timeless.getConfig().useOldBatModel) {
            return;
        }

        ModelData modelData = new ModelData();

        ModelPartData root = modelData.getRoot();
        ModelPartData head = root.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F), ModelTransform.NONE);
        head.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(24, 0).cuboid(-4.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F), ModelTransform.NONE);
        head.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(1.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F), ModelTransform.NONE);

        ModelPartData body = root.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F).uv(0, 34).cuboid(-5.0F, 16.0F, 0.0F, 10.0F, 6.0F, 1.0F), ModelTransform.NONE);
        body.addChild(EntityModelPartNames.FEET, ModelPartBuilder.create().uv(16, 16).cuboid(-1.5f, 0.0f, 0.0f, 3.0f, 2.0f, 0.0f), ModelTransform.pivot(0.0f, 5.0f, 0.0f));

        ModelPartData rightWing = body.addChild(EntityModelPartNames.RIGHT_WING, ModelPartBuilder.create().uv(42, 0).cuboid(-12.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F), ModelTransform.NONE);
        rightWing.addChild(EntityModelPartNames.RIGHT_WING_TIP, ModelPartBuilder.create().uv(24, 16).cuboid(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F), ModelTransform.pivot(-12.0F, 1.0F, 1.5F));

        ModelPartData leftWing = body.addChild(EntityModelPartNames.LEFT_WING, ModelPartBuilder.create().uv(42, 0).mirrored().cuboid(2.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F), ModelTransform.NONE);
        leftWing.addChild(EntityModelPartNames.LEFT_WING_TIP, ModelPartBuilder.create().uv(24, 16).mirrored().cuboid(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F), ModelTransform.pivot(12.0F, 1.0F, 1.5F));

        cir.setReturnValue(TexturedModelData.of(modelData, 64, 64));
    }

    @Inject(
            method = "setAngles(Lnet/minecraft/entity/passive/BatEntity;FFFFF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    public void setAngles(BatEntity batEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
        if (!Timeless.getConfig().useOldBatModel) {
            return;
        }

        if (batEntity.isRoosting()) {
            this.head.pitch = j * 0.017453292F;
            this.head.yaw = 3.1415927F - i * 0.017453292F;
            this.head.roll = 3.1415927F;
            this.head.setPivot(0.0F, -2.0F, 0.0F);
            this.rightWing.setPivot(-3.0F, 0.0F, 3.0F);
            this.leftWing.setPivot(3.0F, 0.0F, 3.0F);
            this.body.pitch = 3.1415927F;
            this.rightWing.pitch = -0.15707964F;
            this.rightWing.yaw = -1.2566371F;
            this.rightWingTip.yaw = -1.7278761F;
            this.leftWing.pitch = this.rightWing.pitch;
            this.leftWing.yaw = -this.rightWing.yaw;
            this.leftWingTip.yaw = -this.rightWingTip.yaw;
        } else {
            this.head.pitch = j * 0.017453292F;
            this.head.yaw = i * 0.017453292F;
            this.head.roll = 0.0F;
            this.head.setPivot(0.0F, 0.0F, 0.0F);
            this.rightWing.setPivot(0.0F, 0.0F, 0.0F);
            this.leftWing.setPivot(0.0F, 0.0F, 0.0F);
            this.body.pitch = 0.7853982F + MathHelper.cos(h * 0.1F) * 0.15F;
            this.body.yaw = 0.0F;
            this.rightWing.yaw = MathHelper.cos(h * 74.48451F * 0.017453292F) * 3.1415927F * 0.25F;
            this.leftWing.yaw = -this.rightWing.yaw;
            this.rightWingTip.yaw = this.rightWing.yaw * 0.5F;
            this.leftWingTip.yaw = -this.rightWing.yaw * 0.5F;
        }

        ci.cancel();
    }
}
//#endif