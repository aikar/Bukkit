package org.bukkit.event.inventory;

import com.destroystokyo.paper.event.inventory.PrepareResultEvent;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when an item is put in a slot for repair by an anvil.
 */
// Paper start - extend PrepareResultEvent
public class PrepareAnvilEvent extends PrepareResultEvent {

    //private static final HandlerList handlers = new HandlerList();
    //private ItemStack result;

    public PrepareAnvilEvent(@NotNull InventoryView inventory, @Nullable ItemStack result) {
        super(inventory, result);
        //this.result = result;
        // Paper end
    }

    @NotNull
    @Override
    public AnvilInventory getInventory() {
        return (AnvilInventory) super.getInventory();
    }

    /**
     * Get result item, may be null.
     *
     * @return result item
     */
    @Nullable
    public ItemStack getResult() {
        return super.getResult(); // Paper
    }

    public void setResult(@Nullable ItemStack result) {
        super.setResult(result); // Paper
    }

    /* // Paper - comment out
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
    */ // Paper
}
