package com.destroystokyo.paper.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when processing a player's attack on an entity when the player's attack strength cooldown is reset
 */
public class PlayerAttackEntityCooldownResetEvent extends PlayerEvent implements Cancellable {

    private final float cooledAttackStrength;
    private boolean cancel = false;
    private static final HandlerList handlers = new HandlerList();
    @NotNull private final Entity attackedEntity;

    public PlayerAttackEntityCooldownResetEvent(@NotNull Player who, @NotNull Entity attackedEntity, float cooledAttackStrength) {
        super(who);
        this.attackedEntity = attackedEntity;
        this.cooledAttackStrength = cooledAttackStrength;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     * <p>
     * If an attack cooldown event is cancelled, the players attack strength will remain at the same value instead of being reset.
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Cancelling this event will prevent the target player from having their cooldown reset from attacking this entity
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Get the value of the players cooldown attack strength when they initiated the attack
     *
     * @return returns the original player cooldown value
     */
    public float getCooledAttackStrength() {
        return cooledAttackStrength;
    }

    /**
     * Returns the entity attacked by the player
     *
     * @return the entity attacked by the player
     */
    @NotNull
    public Entity getAttackedEntity() {
        return attackedEntity;
    }
}
