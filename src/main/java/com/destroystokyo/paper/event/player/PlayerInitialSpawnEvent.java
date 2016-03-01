package com.destroystokyo.paper.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

/**
 * @deprecated Use {@link PlayerSpawnLocationEvent}, Duplicate API
 */
public class PlayerInitialSpawnEvent extends PlayerSpawnLocationEvent {

    public PlayerInitialSpawnEvent(@NotNull Player who, @NotNull Location spawnLocation) {
        super(who, spawnLocation);
    }
}
