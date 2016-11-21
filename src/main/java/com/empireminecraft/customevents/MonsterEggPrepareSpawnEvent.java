/*
 * Copyright (c) 2016. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MonsterEggPrepareSpawnEvent extends Event implements Cancellable {
    private final HumanEntity player;
    private NamespacedKey typeKey;
    private final ItemStack item;

    public MonsterEggPrepareSpawnEvent(HumanEntity player, NamespacedKey typeKey, ItemStack item) {
        this.player = player;
        this.typeKey = typeKey;
        this.item = item;
    }

    @Nullable public HumanEntity getPlayer() {
        return player;
    }

    @Nonnull
    public NamespacedKey getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(@Nonnull NamespacedKey typeKey) {
        this.typeKey = typeKey;
    }

    @Nullable public ItemStack getItem() {
        return item;
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
}
