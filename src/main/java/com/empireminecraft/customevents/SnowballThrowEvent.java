package com.empireminecraft.customevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class SnowballThrowEvent extends Event implements Cancellable {
    private final ItemStack item;
    private final Snowball entity;
    private final Player player;
    private boolean consumeOnThrow = true;
    public SnowballThrowEvent(HumanEntity player, ItemStack item, Entity entity, boolean consumeOnThrow) {
        this.player = (Player) player;
        this.entity = (Snowball) entity;
        this.item = item;
        this.consumeOnThrow = consumeOnThrow;
    }

    public boolean shouldConsumeOnThrow() {
        return consumeOnThrow;
    }

    public void setConsumeOnThrow(boolean consumeOnThrow) {
        this.consumeOnThrow = consumeOnThrow;
    }

    public Player getPlayer() {
        return player;
    }

    public Snowball getEntity() {
        return entity;
    }

    public ItemStack getItem() {
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
