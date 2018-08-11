package com.destroystokyo.paper.meta;

import com.google.common.collect.AbstractIterator;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"unchecked", "WeakerAccess", "unused"})
public abstract class MetaMap<K extends MetaKey> implements Cloneable {

    private final Int2ObjectOpenHashMap<MetaEntry> map = new Int2ObjectOpenHashMap<>(0);

    MetaMap() {

    }

    MetaMap(MetaMap<K> map) {
        this.map.putAll(map.map);
    }

    public String getString(@Nonnull K key) {
        return getString(key, null);
    }

    public String getString(@Nonnull K key, String def) {
        String val = getObject0(key);
        return val != null ? val : def;
    }

    public String setString(@Nonnull K key, String val) {
        return putObject0(key, val);
    }

    public Integer getInteger(@Nonnull K key) {
        return getInteger(key, null);
    }

    public Integer getInteger(@Nonnull K key, Integer def) {
        Number number = getObject0(key);
        return number != null ? number.intValue() : def;
    }

    public Integer setInteger(@Nonnull K key, int val) {
        Number prev = putObject0(key, val);
        return prev != null ? prev.intValue() : null;
    }

    public Integer adjustInteger(@Nonnull K key, int amount) {
        Integer value = getInteger(key, 0) + amount;
        putObject0(key, value);
        return value;
    }

    public Long getLong(@Nonnull K key) {
        return getLong(key, null);
    }

    public Long getLong(@Nonnull K key, Long def) {
        Number number = getObject0(key);
        return number != null ? number.longValue() : def;
    }

    public Long setLong(@Nonnull K key, Long val) {
        Number prev = putObject0(key, val);
        return prev != null ? prev.longValue() : null;
    }

    public Long adjustLong(@Nonnull K key, long amount) {
        Long value = getLong(key, 0L) + amount;
        putObject0(key, value);
        return value;
    }

    public Double getDouble(@Nonnull K key) {
        return getDouble(key, null);
    }

    public Double getDouble(@Nonnull K key, Double def) {
        Number number = getObject0(key);
        return number != null ? number.doubleValue() : def;
    }

    public Double setDouble(@Nonnull K key, Double val) {
        Number prev = putObject0(key, val);
        return prev != null ? prev.doubleValue() : null;
    }

    public Double adjustDouble(@Nonnull K key, double amount) {
        Double value = getDouble(key, 0D) + amount;
        putObject0(key, value);
        return value;
    }

    public Float getFloat(@Nonnull K key) {
        return getFloat(key, null);
    }

    public Float getFloat(@Nonnull K key, Float def) {
        Number number = getObject0(key);
        return number != null ? number.floatValue() : def;
    }

    public Float setFloat(@Nonnull K key, Float val) {
        Number prev = putObject0(key, val);
        return prev != null ? prev.floatValue() : null;
    }

    public Float adjustFloat(@Nonnull K key, float amount) {
        Float value = getFloat(key, 0F) + amount;
        putObject0(key, value);
        return value;
    }

    public Short getShort(@Nonnull K key) {
        return getShort(key, null);
    }

    public Short getShort(@Nonnull K key, Short def) {
        Number number = getObject0(key);
        return number != null ? number.shortValue() : def;
    }

    public Short setShort(@Nonnull K key, Short val) {
        Number prev = putObject0(key, val);
        return prev != null ? prev.shortValue() : null;
    }

    public Short adjustShort(@Nonnull K key, short amount) {
        Number value = getShort(key, (short) 0) + amount;
        putObject0(key, value);
        return value.shortValue();
    }

    public Boolean getBoolean(@Nonnull K key) {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(@Nonnull K key, Boolean def) {
        Number number = getObject0(key);
        return number != null ? number.intValue() != 0 : def;
    }

    public Boolean setBoolean(@Nonnull K key, boolean val) {
        Number prev = putObject0(key, val ? 1 : 0);
        return prev != null ? prev.intValue() != 0 : null;
    }

    public <T extends ItemStack> T setItemStack(@Nonnull K key, ItemStack value) {
        return (T) putObject0(key, value);
    }

    public <T extends ItemStack> T getItemStack(@Nonnull K key) {
        return (T) getObject0(key, null);
    }

    public <T extends ItemStack> T getItemStack(@Nonnull K key, T def) {
        return getObject0(key, def);
    }

    // TODO: ConfigurationSerializeable

    public Set<MetaKey> getKeys() {
        return new AbstractSet<MetaKey>() {
            @Nonnull
            @Override
            public Iterator<MetaKey> iterator() {
                return new Iterator<MetaKey>() {
                    private final Iterator<MetaEntry> iterator = map.values().iterator();

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public MetaKey next() {
                        return iterator.next().getKey();
                    }

                    @Override
                    public void remove() {
                        iterator.remove();
                    }
                };
            }

            @Override
            public int size() {
                return map.size();
            }
        };
    }

    /**
     * For saving
     */
    public Set<MetaEntry> getEntries() {
        return new AbstractSet<MetaEntry>() {
            @Nonnull
            @Override
            public Iterator<MetaEntry> iterator() {
                return map.values().iterator();
            }

            @Override
            public int size() {
                return map.size();
            }
        };
    }


    public boolean containsKey(K key) {
        return map.containsKey(key.getId());
    }

    public boolean containsValue(Object object) {
        //noinspection SuspiciousMethodCalls
        return map.containsValue(object);
    }


    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int size() {
        return map.size();
    }

    public <T> T remove(K k) {
        //noinspection unchecked
        return (T) map.remove(k.getId());
    }

    public void clear() {
        map.clear();
    }

    // Raw access to map is package private so we can control scope access in persistent

    <T> T getObject0(K key) {
        if (map.isEmpty()) {
            return null;
        }
        //noinspection unchecked
        return (T) map.get(key.getId());
    }

    <T> T getObject0(K key, T def) {
        if (map.isEmpty()) {
            return def;
        }
        //noinspection unchecked
        MetaEntry metaEntry = map.get(key.getId());
        return metaEntry != null ? (T) metaEntry.value : def;
    }

    <T> T putObject0(K key, T value) {
        //noinspection unchecked
        MetaEntry prev = map.put(key.getId(), new MetaEntry(key, value));
        return prev != null ? (T) prev.value : null;
    }

    public static class MetaEntry {
        private MetaKey key;
        private Object value;

        public MetaEntry(MetaKey key, Object value) {
            this.key = key;
            this.value = value;
        }

        public MetaKey getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MetaEntry metaEntry = (MetaEntry) o;
            return key.getId() == metaEntry.key.getId() && Objects.equals(value, metaEntry.value);
        }
    }
}
