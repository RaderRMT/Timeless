package fr.rader.timeless.utils;

import net.minecraft.client.model.ModelTransform;

public class ModelTransformEx {

    public static ModelTransform pivot(float x, float y, float z) {
        //#if MC>=12105
        return ModelTransform.origin(x, y, z);
        //#else
        //$$ return ModelTransform.pivot(x, y, z);
        //#endif
    }
}
