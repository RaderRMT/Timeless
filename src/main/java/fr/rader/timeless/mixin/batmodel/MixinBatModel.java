package fr.rader.timeless.mixin.batmodel;

import fr.rader.timeless.config.TimelessConfig;
import net.minecraft.client.animation.*;
import net.minecraft.client.model.ambient.BatModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.state.BatRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(BatModel.class)
public abstract class MixinBatModel extends EntityModel<BatRenderState> {

    @Final @Shadow private ModelPart head;
    @Final @Shadow private ModelPart body;
    @Final @Shadow private ModelPart rightWing;
    @Final @Shadow private ModelPart leftWing;
    @Final @Shadow private ModelPart rightWingTip;
    @Final @Shadow private ModelPart leftWingTip;

    protected MixinBatModel(ModelPart root) {
        super(root);
    }

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/model/EntityModel;<init>(Lnet/minecraft/client/model/geom/ModelPart;Ljava/util/function/Function;)V"
            )
    )
    private static Function<Identifier, RenderType> timeless$changeRenderType(Function<Identifier, RenderType> function) {
        if (!TimelessConfig.get().useOldBatModel) {
            return function;
        }

        return RenderTypes::entityCutout;
    }

    @Inject(
            method = "createBodyLayer",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void timeless$createBodyLayer(CallbackInfoReturnable<LayerDefinition> cir) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        MeshDefinition modelData = new MeshDefinition();

        PartDefinition root = modelData.getRoot();
        PartDefinition head = root.addOrReplaceChild(PartNames.HEAD, CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);
        head.addOrReplaceChild(PartNames.RIGHT_EAR, CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.ZERO);
        head.addOrReplaceChild(PartNames.LEFT_EAR, CubeListBuilder.create().texOffs(24, 0).mirror().addBox(1.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild(PartNames.BODY, CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F).texOffs(0, 34).addBox(-5.0F, 16.0F, 0.0F, 10.0F, 6.0F, 1.0F), PartPose.ZERO);
        body.addOrReplaceChild(PartNames.FEET, CubeListBuilder.create().texOffs(16, 16).addBox(-1.5f, 0.0f, 0.0f, 3.0f, 2.0f, 0.0f), PartPose.offset(0.0f, 5.0f, 0.0f));

        PartDefinition rightWing = body.addOrReplaceChild(PartNames.RIGHT_WING, CubeListBuilder.create().texOffs(42, 0).addBox(-12.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F), PartPose.ZERO);
        rightWing.addOrReplaceChild(PartNames.RIGHT_WING_TIP, CubeListBuilder.create().texOffs(24, 16).addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F), PartPose.offset(-12.0F, 1.0F, 1.5F));

        PartDefinition leftWing = body.addOrReplaceChild(PartNames.LEFT_WING, CubeListBuilder.create().texOffs(42, 0).mirror().addBox(2.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F), PartPose.ZERO);
        leftWing.addOrReplaceChild(PartNames.LEFT_WING_TIP, CubeListBuilder.create().texOffs(24, 16).mirror().addBox(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F), PartPose.offset(12.0F, 1.0F, 1.5F));

        cir.setReturnValue(LayerDefinition.create(modelData, 64, 64));
    }

    @Inject(
            method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/BatRenderState;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    public void timeless$setupAnim(BatRenderState state, CallbackInfo ci) {
        if (!TimelessConfig.get().useOldBatModel) {
            return;
        }

        final float pi = (float) Math.PI;
        final float pi180 = (float) Math.PI / 180.0f;

        if (state.isResting) {
            this.head.xRot = state.xRot * pi180;
            this.head.zRot = pi;
            this.head.yRot = pi;
            this.head.setPos(0.0f, -2.0f, 0.0f);
            this.rightWing.setPos(-3.0f, 0.0f, 3.0f);
            this.leftWing.setPos(3.0f, 0.0f, 3.0f);
            this.body.xRot = pi;
            this.rightWing.xRot = -0.15707964f;
            this.rightWing.yRot = -1.2566371f;
            this.rightWingTip.yRot = -1.7278761f;
            this.leftWing.xRot = this.rightWing.xRot;
            this.leftWing.yRot = -this.rightWing.yRot;
            this.leftWingTip.yRot = -this.rightWingTip.yRot;
        } else {
            this.head.xRot = state.xRot * pi180;
            this.head.zRot = 0.0f;
            this.head.yRot = 0.0f;
            this.head.setPos(0.0f, 0.0f, 0.0f);
            this.rightWing.setPos(0.0f, 0.0f, 0.0f);
            this.leftWing.setPos(0.0f, 0.0f, 0.0f);
            this.body.xRot = 0.7853982f + Mth.cos(state.ageInTicks * 0.1f) * 0.15f;
            this.body.yRot = 0.0f;
            this.rightWing.yRot = Mth.cos(state.ageInTicks * 74.48451f * pi180) * pi * 0.25f;
            this.leftWing.yRot = -this.rightWing.yRot;
            this.rightWingTip.yRot = this.rightWing.yRot * 0.5f;
            this.leftWingTip.yRot = -this.rightWing.yRot * 0.5f;
        }

        ci.cancel();
    }
}
