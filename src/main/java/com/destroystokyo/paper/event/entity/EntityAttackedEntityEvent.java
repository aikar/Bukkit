/*
 * Copyright (c) 2017 Daniel Ennis (Aikar) MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.destroystokyo.paper.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityEvent;

public class EntityAttackedEntityEvent extends EntityEvent implements Cancellable {
    private final Entity victim;
    private final DamageCause cause;
    private final double damage;

    public EntityAttackedEntityEvent(Entity attacker, Entity victim, final DamageCause cause, final double damage) {
        super(attacker);
        this.victim = victim;
        this.cause = cause;
        this.damage = damage;
    }

    public Entity getVictim() {
        return victim;
    }

    public DamageCause getCause() {
        return cause;
    }

    public double getDamage() {
        return damage;
    }

    private static final HandlerList handlers = new HandlerList();

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

    public static boolean callEvent(Entity attacker, Entity victim, DamageCause cause, double damage) {
        EntityAttackedEntityEvent event;
        if (attacker instanceof Player) {
            event = new PlayerAttackedEntityEvent((Player) attacker, victim, cause, damage);
        } else if (victim instanceof Player) {
            event = new EntityAttackedPlayerEvent(attacker, (Player) victim, cause, damage);
        } else {
            event = new EntityAttackedEntityEvent(attacker, victim, cause, damage);
        }
        return event.callEvent();
    }
}
