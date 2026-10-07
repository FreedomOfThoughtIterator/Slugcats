package net.fot.fotslugcats.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum SlugcatVariant {
    WHITE(0),
    CYAN(1),
    LIME(2),
    DARK_BLUE(3),
    DARK_GREEN(4),
    DARK_YELLOW(5);

    private static final SlugcatVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(SlugcatVariant::getId)).toArray(SlugcatVariant[]::new);
    private final int id;

    SlugcatVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static SlugcatVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
