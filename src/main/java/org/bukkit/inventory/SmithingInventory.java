package org.bukkit.inventory;

import org.jetbrains.annotations.Nullable; // Paper

/**
 * Interface to the inventory of a Smithing table.
 */
public interface SmithingInventory extends Inventory {

    // Paper start
    /**
     * Gets the input equipment (first slot).
     *
     * @return input equipment item
     */
    @Nullable
    default ItemStack getInputEquipment() {
        return getItem(0);
    }

    /**
     * Sets the input equipment (first slot).
     *
     * @param itemStack item to set
     */
    default void setInputEquipment(@Nullable ItemStack itemStack) {
        setItem(0, itemStack);
    }

    /**
     * Gets the input mineral (second slot).
     *
     * @return input mineral item
     */
    @Nullable
    default ItemStack getInputMineral() {
        return getItem(1);
    }

    /**
     * Sets the input mineral (second slot).
     *
     * @param itemStack item to set
     */
    default void setInputMineral(@Nullable ItemStack itemStack) {
        setItem(1, itemStack);
    }

    /**
     * Gets the result item.
     *
     * @return result
     */
    @Nullable
    default ItemStack getResult() {
        return getItem(2);
    }

    /**
     * Sets the result item.
     *
     * @param itemStack item to set
     */
    default void setResult(@Nullable ItemStack itemStack) {
        setItem(2, itemStack);
    }
    // Paper end
}
