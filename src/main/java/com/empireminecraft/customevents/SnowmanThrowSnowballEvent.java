/*
 * Copyright (c) 2015. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public class SnowmanThrowSnowballEvent extends EntityEvent implements Cancellable {
    private final Snowman snowman;
    private final Snowball snowball;
    private final LivingEntity target;

    private static final HandlerList handlers = new HandlerList();

    public SnowmanThrowSnowballEvent(Snowman snowman, Snowball snowball, LivingEntity target) {
        super(snowman);
        this.snowman = snowman;
        this.snowball = snowball;
        this.target = target;
    }

    public Snowman getSnowman() {
        return snowman;
    }

    public Snowball getSnowball() {
        return snowball;
    }

    public LivingEntity getTarget() {
        return target;
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
