package com.destroystokyo.paper.loottable;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.loot.LootTable;

/**
 * Defines an object that has a Loot Table and seed associated with it.
 * <p>
 * How the Loot Table and seed are used may vary based on Minecraft Versions
 * and what type of object is using the Loot Table
 *
 * @deprecated Use {@link org.bukkit.loot.Lootable}
 */
@Deprecated
public interface Lootable extends org.bukkit.loot.Lootable {

    /**
     * Gets the name of the Loot Table to be used in the World Folder
     *
     * @return The name, or null if no loot table exists
     * @deprecated Use {@link org.bukkit.loot.Lootable#getLootTable()}
     */
    @Deprecated
    default String getLootTableName() {
        LootTable lootTable = getLootTable();
        return lootTable != null && lootTable.getKey() != null ? lootTable.getKey().toString() : null;
    }

    /**
     * Sets the name of the Loot Table to be used in the World Folder
     * Will use a random seed (0)
     *
     * @param name name in either foo or minecraft:foo format
     * @return The previous Loot Table before the change
     * @deprecated Use {@link org.bukkit.loot.Lootable#setLootTable(LootTable)}
     */
    @Deprecated
    default String setLootTable(String name) {
        return setLootTable(name, 0);
    }

    /**
     * Sets the name of the Loot Table to be used in the World Folder
     * Uses supplied Seed
     *
     * @param name name in either foo or minecraft:foo format
     * @param seed seed for the loot table. If 0, seed will be random
     * @return The previous Loot Table before the change
     * @deprecated Use {@link org.bukkit.loot.Lootable#setSeed(long)}
     */
    @Deprecated
    default String setLootTable(String name, long seed) {
        String prev = getLootTableName();
        LootTable lootTable = Bukkit.getLootTable(NamespacedKey.minecraft(name));
        setLootTable(lootTable, seed);
        return prev;
    }

    /**
     * Gets the current seed associated to the Loot Table on this object
     *
     * @return The seed, or 0 for random
     * @deprecated Use {@link org.bukkit.loot.Lootable#getSeed()}
     */
    @Deprecated
    default long getLootTableSeed() {
        return getSeed();
    }

    /**
     * Changes the current seed associated with the Loot Table on this object.
     * <p>
     * The seed will have no affect if this object does not have a Loot Table
     * associated with it.
     *
     * @param seed The seed to use, or 0 for random
     * @return The previous seed
     * @throws IllegalStateException If called when this object does not have a loot table
     * @deprecated Use {@link org.bukkit.loot.Lootable#setSeed(long)}
     */
    @Deprecated
    default long setLootTableSeed(long seed) {
        final String lootTableName = getLootTableName();
        if (lootTableName == null) {
            throw new IllegalStateException("This object does not currently have a Loot Table.");
        }

        long prev = getSeed();
        setSeed(seed);
        return prev;
    }
}
