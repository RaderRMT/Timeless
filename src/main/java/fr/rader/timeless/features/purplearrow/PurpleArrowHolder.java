package fr.rader.timeless.features.purplearrow;

import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.entity.projectile.ArrowEntity;

import java.util.HashMap;

public class PurpleArrowHolder {

    private static PurpleArrowHolder instance;

    private final HashMap<ArrowEntityRenderState, ArrowEntity> purpleArrows;

    private PurpleArrowHolder() {
        this.purpleArrows = new HashMap<>();
    }

    public void addIfNotPresent(ArrowEntityRenderState renderState, ArrowEntity entity) {
        this.purpleArrows.put(renderState, entity);
    }

    public ArrowEntity get(ArrowEntityRenderState renderState) {
        return this.purpleArrows.get(renderState);
    }

    public boolean contains(ArrowEntityRenderState renderState) {
        return this.purpleArrows.containsKey(renderState);
    }

    public void clean() {
        this.purpleArrows.entrySet().removeIf(arrow -> !arrow.getValue().isAlive());
    }

    public static PurpleArrowHolder getInstance() {
        if (instance == null) {
            instance = new PurpleArrowHolder();
        }

        return instance;
    }
}
