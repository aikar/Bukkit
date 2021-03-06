package com.destroystokyo.paper.event.player;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player clicks a recipe in the recipe book
 */
public class PlayerRecipeBookClickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    @NotNull private NamespacedKey recipe;
    private boolean makeAll;

    public PlayerRecipeBookClickEvent(@NotNull Player player, @NotNull NamespacedKey recipe, boolean makeAll) {
        super(player);
        this.recipe = recipe;
        this.makeAll = makeAll;
    }

    /**
     * Gets the namespaced key of the recipe that was clicked by the player
     *
     * @return The namespaced key of the recipe
     */
    @NotNull
    public NamespacedKey getRecipe() {
        return recipe;
    }

    /**
     * Changes what recipe is requested. This sets the requested recipe to the recipe with the given key
     *
     * @param recipe The key of the recipe that should be requested
     */
    public void setRecipe(@NotNull NamespacedKey recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets a boolean which indicates whether or not the player requested to make the maximum amount of results. This is
     * true if shift is pressed while the recipe is clicked in the recipe book
     *
     * @return {@code true} if shift is pressed while the recipe is clicked
     */
    public boolean isMakeAll() {
        return makeAll;
    }

    /**
     * Sets whether or not the maximum amount of results should be made. If this is true, the request is handled as if
     * the player had pressed shift while clicking on the recipe
     *
     * @param makeAll {@code true} if the request should attempt to make the maximum amount of results
     */
    public void setMakeAll(boolean makeAll) {
        this.makeAll = makeAll;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
}
