package com.empireminecraft.customevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerReloadEvent extends Event {
    public ServerReloadEvent() {
    }


    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
