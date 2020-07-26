package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an instance of a lightning strike. May or may not do damage.
 */
public interface LightningStrike extends Entity {

    /**
     * Returns whether the strike is an effect that does no damage.
     *
     * @return whether the strike is an effect
     */
    public boolean isEffect();

    // Spigot start
    public class Spigot extends Entity.Spigot {

        /*
         * Returns whether the strike is silent.
         *
         * @return whether the strike is silent.
         */
        public boolean isSilent() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    @Override
    Spigot spigot();
    // Spigot end

    // Paper start
    /**
     * Returns the amount of flash iterations that will be done before the lightning dies.
     *
     * @see #getLifeTicks() for how long the current flash will last
     * @return amount of flashes that will be shown before the lightning dies
     */
    int getFlashCount();

    /**
     * Sets the amount of life iterations that will be done before the lightning dies.
     * Default number of flashes on creation is between 1-3.
     *
     * @param flashes amount of iterations that will be done before the lightning dies, must to be a positive number
     */
    void setFlashCount(int flashes);

    /**
     * Returns the amount of ticks the current flash will do damage for.
     * Starts with 2 by default, will damage while it is equal to or above 0, with the next flash beginning somewhere between 0 and -9.
     *
     * @return ticks the current flash will do damage for
     */
    int getLifeTicks();

    /**
     * Sets the amount of ticks the current flash will do damage/fire for.
     * Default is 2 for each flash, on which the sound and effect will also be played.
     *
     * @param lifeTicks ticks the current flash will do damage for
     */
    void setLifeTicks(int lifeTicks);
    // Paper end
}
