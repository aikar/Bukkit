package com.destroystokyo.paper.event.entity;

import com.google.common.collect.ImmutableList;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Event called when a player gets close to a skeleton horse and triggers the lightning trap
 */
public class SkeletonHorseTrapEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final List<HumanEntity> eligibleHumans;

    public SkeletonHorseTrapEvent(@NotNull SkeletonHorse horse) {
        this(horse, ImmutableList.of());
    }

    public SkeletonHorseTrapEvent(@NotNull SkeletonHorse horse, @NotNull List<HumanEntity> eligibleHumans) {
        super(horse);
        this.eligibleHumans = eligibleHumans;
    }

    @NotNull
    @Override
    public SkeletonHorse getEntity() {
        return (SkeletonHorse) super.getEntity();
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    public List<HumanEntity> getEligibleHumans() {
        return eligibleHumans;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}

