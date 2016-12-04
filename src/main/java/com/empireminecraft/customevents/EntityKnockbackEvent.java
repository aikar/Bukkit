package com.empireminecraft.customevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EntityKnockbackEvent extends Event {
    private final LivingEntity attackingEntity;
    private final LivingEntity targetEntity;
    private int level;

    public EntityKnockbackEvent(LivingEntity attackingEntity, LivingEntity targetEntity, int level) {
        this.attackingEntity = attackingEntity;
        this.targetEntity = targetEntity;
        this.level = level;
    }

    public LivingEntity getAttackingEntity() {
        return attackingEntity;
    }

    public LivingEntity getTargetEntity() {
        return targetEntity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
