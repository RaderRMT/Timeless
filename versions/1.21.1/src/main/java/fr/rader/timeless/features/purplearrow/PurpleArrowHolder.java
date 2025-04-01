package fr.rader.timeless.features.purplearrow;

import net.minecraft.entity.projectile.ArrowEntity;

import java.util.HashSet;

public class PurpleArrowHolder {

    private static PurpleArrowHolder instance;

    private final HashSet<ArrowEntity> purpleArrows;

    private PurpleArrowHolder() {
        this.purpleArrows = new HashSet<>();
    }

    public void add(ArrowEntity entity) {
        this.purpleArrows.add(entity);
    }

    public boolean contains(ArrowEntity entity) {
        return this.purpleArrows.contains(entity);
    }

    public void clean() {
        this.purpleArrows.removeIf(arrow -> !arrow.isAlive());
    }

    public static PurpleArrowHolder getInstance() {
        if (instance == null) {
            instance = new PurpleArrowHolder();
        }

        return instance;
    }
}
