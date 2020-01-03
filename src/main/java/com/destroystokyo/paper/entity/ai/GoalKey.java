package com.destroystokyo.paper.entity.ai;

import com.google.common.base.Objects;

import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Mob;

/**
 *
 * Used to identify a Goal. Consists of a {@link NamespacedKey} and the type of mob the goal can be applied to
 *
 * @param <T> the type of mob the goal can be applied to
 */
public class GoalKey<T extends Mob> {

    private final Class<T> entityClass;
    private final NamespacedKey namespacedKey;

    private GoalKey(@NotNull Class<T> entityClass, @NotNull NamespacedKey namespacedKey) {
        this.entityClass = entityClass;
        this.namespacedKey = namespacedKey;
    }

    @NotNull
    public Class<T> getEntityClass() {
        return entityClass;
    }

    @NotNull
    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoalKey<?> goalKey = (GoalKey<?>) o;
        return Objects.equal(entityClass, goalKey.entityClass) &&
               Objects.equal(namespacedKey, goalKey.namespacedKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entityClass, namespacedKey);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GoalKey.class.getSimpleName() + "[", "]")
            .add("entityClass=" + entityClass)
            .add("namespacedKey=" + namespacedKey)
            .toString();
    }

    @NotNull
    public static <A extends Mob> GoalKey<A> of(@NotNull Class<A> entityClass, @NotNull NamespacedKey namespacedKey) {
        return new GoalKey<>(entityClass, namespacedKey);
    }
}
