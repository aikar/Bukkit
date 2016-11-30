package org.bukkit;

/**
 * Represents an Identifier in Minecraft to represent things like Block States and Entities
 *
 * Object form of minecraft:granite style identifiers
 * Group is the left hand side of : and name is the right
 *
 * "minecraft" is the default group name
 */
public interface Identifier {
    /**
     * Group name representing this Identifier, typically "minecraft"
     * @return The group for this identifier, lowercase
     */
    String getGroup();

    /**
     * Name representing this Identifier.
     * @return The name for this identifier, lowercase
     */
    String getName();
}
