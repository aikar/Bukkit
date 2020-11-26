package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a Target Block is hit by a projectile.
 * <p>
 * Cancelling this event will stop the Target from emitting a redstone signal,
 * and in the case that the shooter is a player, will stop them from receiving
 * advancement criteria.
 */
public class TargetHitEvent extends ProjectileHitEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private int signalStrength;

    public TargetHitEvent(@NotNull Projectile projectile, @NotNull Block block, @NotNull BlockFace blockFace, int signalStrength) {
        super(projectile, null, block, blockFace);
        this.signalStrength = signalStrength;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the strength of the redstone signal to be emitted by the Target block
     *
     * @return the strength of the redstone signal to be emitted
     */
    public int getSignalStrength() {
        return signalStrength;
    }

    /**
     * Sets the strength of the redstone signal to be emitted by the Target block
     *
     * @param signalStrength the strength of the redstone signal to be emitted
     */
    public void setSignalStrength(int signalStrength) {
        if (signalStrength < 0 || signalStrength > 15) {
            throw new IllegalArgumentException("Signal strength out of range (" + signalStrength + "), must be in range [0,15]");
        }
        this.signalStrength = signalStrength;
    }
}
