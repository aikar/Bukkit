package com.empireminecraft.customevents;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class FlowerPotPlantEvent extends Event {
    private final Block block;
    private final ItemStack item;
    public FlowerPotPlantEvent(Location loc, ItemStack itemstack) {
        this.block = loc.getBlock();
        this.item = itemstack;
    }

    public Block getBlock() {
        return block;
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
}
