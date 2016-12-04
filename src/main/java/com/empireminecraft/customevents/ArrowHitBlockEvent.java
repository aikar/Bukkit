package com.empireminecraft.customevents;

import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArrowHitBlockEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;

    final Arrow entity;
    final Block block;

    public ArrowHitBlockEvent(Entity entity, Block block) {
        this.entity = (Arrow) entity;
        this.block = block;
    }

    public Arrow getEntity() {
        return entity;
    }

    public Block getBlock() {
        return block;
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
