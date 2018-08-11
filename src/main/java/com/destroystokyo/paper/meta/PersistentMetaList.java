package com.destroystokyo.paper.meta;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PersistentMetaList<T> extends ArrayList<T> {

    private PersistentMetaList() {
        super(0);
    }

    private PersistentMetaList(List<T> copy) {
        super(copy);
    }

    public static <T extends Number> PersistentMetaList<T> newNumberList() {
        return new PersistentMetaList<>();
    }

    public static <T extends Number> PersistentMetaList<T> newNumberList(List<T> list) {
        return new PersistentMetaList<>(list);
    }

    public static <T extends ItemStack> PersistentMetaList<T> newItemStackList() {
        return new PersistentMetaList<>();
    }

    public static <T extends ItemStack> PersistentMetaList<T> newItemStackList(List<T> list) {
        return new PersistentMetaList<>(list);
    }

    public static <T extends String> PersistentMetaList<T> newStringList() {
        return new PersistentMetaList<>();
    }

    public static PersistentMetaList<String> newStringList(List<String> list) {
        return new PersistentMetaList<>(list);
    }

    // TODO: ConfigurationSerializable

    public PersistentMetaList<T> clone() {
        return new PersistentMetaList<>(this);
    }
}
