package com.empireminecraft.customevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public class ZombieReinforcementEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final LivingEntity targetEntity;
    private double chance;

    public ZombieReinforcementEvent(Entity sourceZombie, LivingEntity targetEntity, double chance) {
        super(sourceZombie);
        this.targetEntity = targetEntity;
        this.chance = chance;
    }


    public LivingEntity getTargetEntity() {
        return targetEntity;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
