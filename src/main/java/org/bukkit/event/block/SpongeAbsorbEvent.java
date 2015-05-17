package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpongeAbsorbEvent extends Event implements Cancellable {
    private final Block spongeBlock;
    private final Block absorbedBlock;
    private final int currentAbsorptionLevel;

    public SpongeAbsorbEvent(Block spongeBlock, Block absorbedBlock, int currentAbsorptionLevel) {
        this.spongeBlock = spongeBlock;
        this.absorbedBlock = absorbedBlock;
        this.currentAbsorptionLevel = currentAbsorptionLevel;
    }

    public Block getSpongeBlock() {
        return spongeBlock;
    }

    public Block getAbsorbedBlock() {
        return absorbedBlock;
    }

    public int getCurrentAbsorptionLevel() {
        return currentAbsorptionLevel;
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
