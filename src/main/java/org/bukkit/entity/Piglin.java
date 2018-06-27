package org.bukkit.entity;

import com.destroystokyo.paper.entity.RangedEntity; // Paper

/**
 * Represents a Piglin.
 */
public interface Piglin extends PiglinAbstract, RangedEntity { // Paper

    /**
     * Get whether the piglin is able to hunt hoglins.
     *
     * @return Whether the piglin is able to hunt hoglins
     */
    public boolean isAbleToHunt();

    /**
     * Sets whether the piglin is able to hunt hoglins.
     *
     * @param flag Whether the piglin is able to hunt hoglins.
     */
    public void setIsAbleToHunt(boolean flag);
}
