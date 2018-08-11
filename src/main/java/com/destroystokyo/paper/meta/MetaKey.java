package com.destroystokyo.paper.meta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MetaKey {

    private static final Map<String, Integer> idMap = new ConcurrentHashMap<>();
    private static final Map<Integer, MetaKey> idReverseMap = new ConcurrentHashMap<>();
    private static final AtomicInteger idPool = new AtomicInteger(1);
    private final String namespace;
    private final String key;
    private final String label;
    private final int id;

    static MetaKey getMetaKey(int id) {
        return idReverseMap.get(id);
    }

    MetaKey(@Nullable String namespace, @Nonnull String key) {
        this.namespace = namespace;
        this.key = key;
        this.label = namespace != null ? namespace + ":" + key : key;
        this.id = idMap.computeIfAbsent(label, (label) -> {
            int id = idPool.getAndIncrement();
            idReverseMap.put(id, this);
            return id;
        });
    }

    /**
     * Namespace to bucket meta under. Can be null for root (Vanilla data)
     *
     * @return The key
     */
    @Nullable
    public final String namespace() {
        return namespace;
    }

    /**
     * Key name of where to store meta
     *
     * @return The key
     */
    @Nonnull
    public final String key() {
        return key;
    }

    final int getId() {
        return id;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaKey that = (MetaKey) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
