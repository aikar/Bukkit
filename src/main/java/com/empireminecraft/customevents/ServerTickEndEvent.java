/*
 * Copyright (c) 2015. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerTickEndEvent extends Event {
    public ServerTickEndEvent() {
    }


    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
