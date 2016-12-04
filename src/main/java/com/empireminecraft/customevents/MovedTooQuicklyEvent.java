package com.empireminecraft.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MovedTooQuicklyEvent extends Event implements Cancellable {


    private static final HandlerList handlers = new HandlerList();
    private final double speed;
    private final Player player;
    private boolean cancelled = false;

    public MovedTooQuicklyEvent(double speed,
                                Player player) {


        this.speed = speed;
        this.player = player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
