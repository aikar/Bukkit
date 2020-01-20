package com.destroystokyo.paper;

import org.jetbrains.annotations.NotNull;

import org.bukkit.inventory.MainHand;

public final class ClientOption<T> {

    public static final ClientOption<SkinParts> SKIN_PARTS = new ClientOption<>(SkinParts.class);
    public static final ClientOption<Boolean> CHAT_COLORS_ENABLED = new ClientOption<>(Boolean.class);
    public static final ClientOption<ChatVisibility> CHAT_VISIBILITY = new ClientOption<>(ChatVisibility.class);
    public static final ClientOption<String> LOCALE = new ClientOption<>(String.class);
    public static final ClientOption<MainHand> MAIN_HAND = new ClientOption<>(MainHand.class);
    public static final ClientOption<Integer> VIEW_DISTANCE = new ClientOption<>(Integer.class);

    private final Class<T> type;

    private ClientOption(@NotNull Class<T> type) {
        this.type = type;
    }

    @NotNull
    public Class<T> getType() {
        return type;
    }

    public enum ChatVisibility {
        FULL,
        SYSTEM,
        HIDDEN,
        UNKNOWN
    }
}
