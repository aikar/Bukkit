package com.destroystokyo.paper.entity.villager;

import com.google.common.base.Preconditions;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/**
 * A reputation score for a player on a villager.
 */
public final class Reputation {
    private static final ReputationType[] REPUTATION_TYPES = ReputationType.values(); // Avoid allocation
    @NotNull
    private final int[] reputation;

    public Reputation() {
        this(new int[REPUTATION_TYPES.length]);
    }

    // Package level to avoid plugins creating reputations with "magic values".
    Reputation(@NotNull int[] reputation) {
        this.reputation = reputation;
    }

    public Reputation(@NotNull final Map<ReputationType, Integer> reputation) {
        this();
        Preconditions.checkNotNull(reputation, "reputation cannot be null");

        for (Map.Entry<ReputationType, Integer> entry : reputation.entrySet()) {
            setReputation(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Gets the reputation value for a specific {@link ReputationType}.
     *
     * @param type The {@link ReputationType type} of reputation to get.
     * @return The value of the {@link ReputationType type}.
     */
    public int getReputation(@NotNull ReputationType type) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        return reputation[type.ordinal()];
    }

    /**
     * Sets the reputation value for a specific {@link ReputationType}.
     *
     * @param type The {@link ReputationType type} of reputation to set.
     * @param value The value of the {@link ReputationType type}.
     */
    public void setReputation(@NotNull ReputationType type, int value) {
        Preconditions.checkNotNull(type, "the reputation type cannot be null");
        reputation[type.ordinal()] = value;
    }
}
