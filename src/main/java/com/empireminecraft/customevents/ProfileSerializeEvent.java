/*
 * Copyright (c) 2015. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ProfileSerializeEvent extends Event {
    private final PlayerProfile profile;

    public ProfileSerializeEvent(PlayerProfile profile) {
        super(!Bukkit.isPrimaryThread());
        this.profile = profile;
    }


    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public PlayerProfile getPlayerProfile() {
        return profile;
    }
}
