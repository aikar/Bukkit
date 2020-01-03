package com.destroystokyo.paper.entity.ai;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

import org.bukkit.entity.Mob;

/**
 * Represents a part of the "brain" of a mob. It tracks all tasks (running or not), allows adding and removing goals
 */
public interface MobGoals {

    <T extends Mob> void addGoal(@NotNull T mob, int priority, @NotNull Goal<T> goal);

    <T extends Mob> void removeGoal(@NotNull T mob, @NotNull Goal<T> goal);

    <T extends Mob> void removeAllGoals(@NotNull T mob);

    <T extends Mob> void removeAllGoals(@NotNull T mob, @NotNull GoalType type);

    <T extends Mob> void removeGoal(@NotNull T mob, @NotNull GoalKey<T> key);

    <T extends Mob> boolean hasGoal(@NotNull T mob, @NotNull GoalKey<T> key);

    @Nullable
    <T extends Mob> Goal<T> getGoal(@NotNull T mob, @NotNull GoalKey<T> key);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getGoals(@NotNull T mob, @NotNull GoalKey<T> key);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getAllGoals(@NotNull T mob);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getAllGoals(@NotNull T mob, @NotNull GoalType type);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getAllGoalsWithout(@NotNull T mob, @NotNull GoalType type);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getRunningGoals(@NotNull T mob);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getRunningGoals(@NotNull T mob, @NotNull GoalType type);

    @NotNull
    <T extends Mob> Collection<Goal<T>> getRunningGoalsWithout(@NotNull T mob, @NotNull GoalType type);
}
