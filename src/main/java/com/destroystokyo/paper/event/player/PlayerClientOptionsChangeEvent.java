package com.destroystokyo.paper.event.player;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.ClientOption.ChatVisibility;
import com.destroystokyo.paper.SkinParts;

import org.jetbrains.annotations.NotNull;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.MainHand;

/**
 * Called when the player changes his client settings
 */
public class PlayerClientOptionsChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();

    private final String locale;
    private final int viewDistance;
    private final ChatVisibility chatVisibility;
    private final boolean chatColors;
    private final SkinParts skinparts;
    private final MainHand mainHand;

    public PlayerClientOptionsChangeEvent(@NotNull Player player, @NotNull String locale, int viewDistance, @NotNull ChatVisibility chatVisibility, boolean chatColors, @NotNull SkinParts skinParts, @NotNull MainHand mainHand) {
        super(player);
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatVisibility = chatVisibility;
        this.chatColors = chatColors;
        this.skinparts = skinParts;
        this.mainHand = mainHand;
    }

    @NotNull
    public String getLocale() {
        return locale;
    }

    public boolean hasLocaleChanged() {
        return !locale.equals(player.getClientOption(ClientOption.LOCALE));
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public boolean hasViewDistanceChanged() {
        return viewDistance != player.getClientOption(ClientOption.VIEW_DISTANCE);
    }

    @NotNull
    public ChatVisibility getChatVisibility() {
        return chatVisibility;
    }

    public boolean hasChatVisibilityChanged() {
        return chatVisibility != player.getClientOption(ClientOption.CHAT_VISIBILITY);
    }

    public boolean hasChatColorsEnabled() {
        return chatColors;
    }

    public boolean hasChatColorsEnabledChanged() {
        return chatColors != player.getClientOption(ClientOption.CHAT_COLORS_ENABLED);
    }

    @NotNull
    public SkinParts getSkinParts() {
        return skinparts;
    }

    public boolean hasSkinPartsChanged() {
        return skinparts.getRaw() != player.getClientOption(ClientOption.SKIN_PARTS).getRaw();
    }

    @NotNull
    public MainHand getMainHand() {
        return mainHand;
    }

    public boolean hasMainHandChanged() {
        return mainHand != player.getClientOption(ClientOption.MAIN_HAND);
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
