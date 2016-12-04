package com.empireminecraft.customevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public class LivingEntityArmorProtectEvent extends EntityEvent {

    private static final HandlerList handlers = new HandlerList();
    private final LivingEntity entity;

    private double armorValue = 0;

    public LivingEntityArmorProtectEvent(LivingEntity entity, double armorValue) {
        super(entity);
        this.entity = entity;
        this.armorValue = armorValue;
    }
    public double getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(double armorValue) {
        this.armorValue = armorValue;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
