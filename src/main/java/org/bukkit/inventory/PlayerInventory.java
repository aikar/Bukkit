package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;

/**
 * Interface to the inventory of a Player, including the four armor slots and any extra slots.
 */
public interface PlayerInventory extends Inventory {

    /**
     * Get all ItemStacks from the armor slots
     *
     * @return All the ItemStacks from the armor slots
     */
    public ItemStack[] getArmorContents();

    /**
     * Get all additional ItemStacks stored in this inventory.
     * <br>
     * NB: What defines an extra slot is up to the implementation, however it
     * will not be contained within {@link #getStorageContents()} or
     * {@link #getArmorContents()}
     *
     * @return All additional ItemStacks
     */
    public ItemStack[] getExtraContents();

    /**
     * Return the ItemStack from the helmet slot
     *
     * @return The ItemStack in the helmet slot
     */
    public ItemStack getHelmet();

    /**
     * Return the ItemStack from the chestplate slot
     *
     * @return The ItemStack in the chestplate slot
     */
    public ItemStack getChestplate();

    /**
     * Return the ItemStack from the leg slot
     *
     * @return The ItemStack in the leg slot
     */
    public ItemStack getLeggings();

    /**
     * Return the ItemStack from the boots slot
     *
     * @return The ItemStack in the boots slot
     */
    public ItemStack getBoots();

    /**
     * Stores the ItemStack at the given index of the inventory.
     * <p>
     * Indexes 0 through 8 refer to the hotbar. 9 through 35 refer to the main inventory, counting up from 9 at the top
     * left corner of the inventory, moving to the right, and moving to the row below it back on the left side when it
     * reaches the end of the row. It follows the same path in the inventory like you would read a book.
     * <p>
     * Indexes 36 through 39 refer to the armor slots. Though you can set armor with this method using these indexes,
     * you are encouraged to use the provided methods for those slots.
     * <p>
     * If you attempt to use this method with an index less than 0 or greater than 39, an ArrayIndexOutOfBounds
     * exception will be thrown.
     *
     * @param index The index where to put the ItemStack
     * @param item The ItemStack to set
     * @throws ArrayIndexOutOfBoundsException when index &lt; 0 || index &gt; 39
     * @see #setBoots(ItemStack)
     * @see #setChestplate(ItemStack)
     * @see #setHelmet(ItemStack)
     * @see #setLeggings(ItemStack)
     */
    @Override
    public void setItem(int index, ItemStack item);

    /**
     * Put the given ItemStacks into the armor slots
     *
     * @param items The ItemStacks to use as armour
     */
    public void setArmorContents(ItemStack[] items);

    /**
     * Put the given ItemStacks into the extra slots
     * <br>
     * See {@link #getExtraContents()} for an explanation of extra slots.
     *
     * @param items The ItemStacks to use as extra
     */
    public void setExtraContents(ItemStack[] items);

    /**
     * Put the given ItemStack into the helmet slot. This does not check if
     * the ItemStack is a helmet
     *
     * @param helmet The ItemStack to use as helmet
     */
    public void setHelmet(ItemStack helmet);

    /**
     * Put the given ItemStack into the chestplate slot. This does not check
     * if the ItemStack is a chestplate
     *
     * @param chestplate The ItemStack to use as chestplate
     */
    public void setChestplate(ItemStack chestplate);

    /**
     * Put the given ItemStack into the leg slot. This does not check if the
     * ItemStack is a pair of leggings
     *
     * @param leggings The ItemStack to use as leggings
     */
    public void setLeggings(ItemStack leggings);

    /**
     * Put the given ItemStack into the boots slot. This does not check if the
     * ItemStack is a boots
     *
     * @param boots The ItemStack to use as boots
     */
    public void setBoots(ItemStack boots);

    /**
     * Gets a copy of the item the player is currently holding
     * in their main hand.
     *
     * @return the currently held item
     */
    ItemStack getItemInMainHand();

    /**
     * Sets the item the player is holding in their main hand.
     *
     * @param item The item to put into the player's hand
     */
    void setItemInMainHand(ItemStack item);

    /**
     * Gets a copy of the item the player is currently holding
     * in their off hand.
     *
     * @return the currently held item
     */
    ItemStack getItemInOffHand();

    /**
     * Sets the item the player is holding in their off hand.
     *
     * @param item The item to put into the player's hand
     */
    void setItemInOffHand(ItemStack item);

    /**
     * Gets a copy of the item the player is currently holding
     *
     * @deprecated players can duel wield now use the methods for the
     *      specific hand instead
     * @see #getItemInMainHand()
     * @see #getItemInOffHand()
     * @return the currently held item
     */
    @Deprecated
    public ItemStack getItemInHand();

    /**
     * Sets the item the player is holding
     *
     * @deprecated players can duel wield now use the methods for the
     *      specific hand instead
     * @see #setItemInMainHand(ItemStack)
     * @see #setItemInOffHand(ItemStack)
     * @param stack The item to put into the player's hand
     */
    @Deprecated
    public void setItemInHand(ItemStack stack);

    /**
     * Get the slot number of the currently held item
     *
     * @return Held item slot number
     */
    public int getHeldItemSlot();

    /**
     * Set the slot number of the currently held item.
     * <p>
     * This validates whether the slot is between 0 and 8 inclusive.
     *
     * @param slot The new slot number
     * @throws IllegalArgumentException Thrown if slot is not between 0 and 8
     *     inclusive
     */
    public void setHeldItemSlot(int slot);

    public HumanEntity getHolder();

    // Paper start
    /**
     * Gets the {@link ItemStack} found in the slot.
     *
     * @param slot The slot
     * @return The item stack in the slot
     */
    ItemStack getItem(EquipmentSlot slot);

    /**
     * Sets the {@link ItemStack} at the given {@link EquipmentSlot}.
     *
     * @param slot The slot for the stack
     * @param stack The item stack to set
     */
    void setItem(EquipmentSlot slot, ItemStack stack);
    // Paper end
}
