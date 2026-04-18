package fr.rader.timeless.features.purplearrow;

import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;

import java.util.HashMap;

public class PurpleArrowHolder {

    private static PurpleArrowHolder instance;

    private final HashMap<ArrowRenderState, AbstractArrow> purpleArrows;

    private PurpleArrowHolder() {
        this.purpleArrows = new HashMap<>();
    }

    public void addIfNotPresent(ArrowRenderState renderState, AbstractArrow entity) {
        this.purpleArrows.put(renderState, entity);
    }

    public AbstractArrow get(ArrowRenderState renderState) {
        return this.purpleArrows.get(renderState);
    }

    public boolean contains(ArrowRenderState renderState) {
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
