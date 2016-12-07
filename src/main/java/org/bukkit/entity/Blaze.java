package org.bukkit.entity;

/**
 * Represents a Blaze monster
 */
public interface Blaze extends Monster {
    // EMC start
    void setFireballs(int num);
    int getNumFireballs();
    int getTimeBetweenFireballs();
    void setTimeBetweenFireballs(int timeBetweenFireballs);
    // EMC end
}
