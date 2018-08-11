package com.destroystokyo.paper.meta;

import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PersistentMetaSet<T> extends HashSet<T> {

    private PersistentMetaSet() {
        super(0);
    }

    private PersistentMetaSet(Set<T> copy) {
        super(copy);
    }

    public static <T extends Number> PersistentMetaSet<T> newNumberSet() {
        return new PersistentMetaSet<>();
    }

    public static <T extends Number> PersistentMetaSet<T> newNumberSet(Set<T> list) {
        return new PersistentMetaSet<>(list);
    }

    public static <T extends ItemStack> PersistentMetaSet<T> newItemStackSet() {
        return new PersistentMetaSet<>();
    }

    public static <T extends ItemStack> PersistentMetaSet<T> newItemStackSet(Set<T> list) {
        return new PersistentMetaSet<>(list);
    }

    public static <T extends String> PersistentMetaSet<T> newStringSet() {
        return new PersistentMetaSet<>();
    }

    public static PersistentMetaSet<String> newStringSet(Set<String> list) {
        return new PersistentMetaSet<>(list);
    }

    // TODO: ConfigurationSerializable

    public PersistentMetaSet<T> clone() {
        return new PersistentMetaSet<>(this);
    }
}
