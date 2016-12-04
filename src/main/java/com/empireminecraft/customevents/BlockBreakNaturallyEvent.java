package com.empireminecraft.customevents;

import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;

public class BlockBreakNaturallyEvent extends BlockEvent {
    private final Item item;
    public BlockBreakNaturallyEvent(Location pos, Item item) {
        super(pos.getBlock());
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
