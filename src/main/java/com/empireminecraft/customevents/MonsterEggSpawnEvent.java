/*
 * Copyright (c) 2016. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;


import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class MonsterEggSpawnEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;


    private final Player player;
    private LivingEntity entity;
    private final ItemStack item;

    public MonsterEggSpawnEvent(HumanEntity player, LivingEntity entity, ItemStack item) {
        this.player = (Player) player;
        this.entity = entity;
        this.item = item;
    }

    public Player getPlayer() {
        return player;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public void setEntity(LivingEntity entity) {
        if (entity == null) {
            canceled = true;
            return;
        }
        this.entity = entity;
    }

    public ItemStack getItem() {
        return item;
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
