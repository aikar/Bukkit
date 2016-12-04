package com.empireminecraft.customevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.potion.PotionEffect;

public class EntityEffectAddedEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;

    private final LivingEntity entity;
    private PotionEffect effect;

    public EntityEffectAddedEvent(LivingEntity entity, PotionEffect effect) {
        this.entity = entity;
        this.effect = effect;
    }

    public PotionEffect getEffect() {
        return effect;
    }

    public void setEffect(PotionEffect effect) {
        this.effect = effect;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public boolean isCancelled() {
        return canceled;
    }

    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
