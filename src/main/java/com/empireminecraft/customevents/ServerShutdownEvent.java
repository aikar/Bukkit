package com.empireminecraft.customevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerShutdownEvent extends Event {
    private String reason;
    public ServerShutdownEvent(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
