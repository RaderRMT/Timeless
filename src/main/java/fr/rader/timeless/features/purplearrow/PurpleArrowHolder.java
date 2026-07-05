package fr.rader.timeless.features.purplearrow;

import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PurpleArrowHolder {

    private static PurpleArrowHolder instance;

    private final ConcurrentHashMap<ArrowRenderState, AbstractArrow> purpleArrows;

    private PurpleArrowHolder() {
        this.purpleArrows = new ConcurrentHashMap<>();
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
        List<ArrowRenderState> deadArrows = new ArrayList<>();
        this.purpleArrows.forEach((renderState, entity) -> {
            if (!entity.isAlive()) {
                deadArrows.add(renderState);
            }
        });

        for (int i = deadArrows.size() - 1; i >= 0; --i)
        {
            this.purpleArrows.remove(deadArrows.get(i));
        }
    }

    public static PurpleArrowHolder getInstance() {
        if (instance == null) {
            instance = new PurpleArrowHolder();
        }

        return instance;
    }
}
