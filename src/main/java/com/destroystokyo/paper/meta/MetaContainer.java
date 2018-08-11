package com.destroystokyo.paper.meta;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents an object that can contain metadata.
 * <p>
 * This is abstract from the Persistent vs temporary context
 * <p>
 * This API is not thread safe!
 */
@SuppressWarnings({"unchecked", "unused"})
public interface MetaContainer {

    MetaMap getMetaMap(MetaKey key, boolean isWrite);

    TempMetaMap getTempMetaMap(TempMetaKey key, boolean isWrite);

    default <T> T getMeta(TempMetaKey key) {
        final MetaMap metaMap = getTempMetaMap(key, false);
        //noinspection unchecked
        return metaMap != null ? (T) metaMap.getObject0(key, null) : null;
    }

    default <T> T getMeta(TempMetaKey key, T def) {
        final MetaMap metaMap = getTempMetaMap(key, false);
        //noinspection unchecked
        return metaMap != null ? (T) metaMap.getObject0(key, def) : null;
    }

    default <T> T setMeta(TempMetaKey key, T val) {
        TempMetaMap metaMap = getTempMetaMap(key, true);
        return metaMap != null ? metaMap.setValue(key, val) : null;
    }


    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default <K, V> Map<K, V> getMapMeta(TempMetaKey key) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default <K, V> Map<K, V> getMapMeta(TempMetaKey key, Map<K, V> def) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default <K, V> Map<K, V> setMapMeta(TempMetaKey key, Map<K, V> value) {
        return setMeta(key, value);
    }

    /**
     * @param key Meta Key
     * @param <Z> Expected type of the list items
     * @return Current value or null if it was not set
     */
    default <Z> List<Z> getListMeta(TempMetaKey key) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @param <Z> Expected type of the list items
     * @return Current value or specified default if it was not set
     */
    default <Z> List<Z> getListMeta(TempMetaKey key, List<Z> def) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @param <Z> Expected type of the list items
     * @return Previous value or null if it was not set
     */
    default <Z> List<Z> setListMeta(TempMetaKey key, List<Z> value) {
        return setMeta(key, value);
    }

    /**
     * @param key Meta Key
     * @param <Z> Expected type of the list items
     * @return Current value or null if it was not set
     */
    default <Z> Set<Z> getSetMeta(TempMetaKey key) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @param <Z> Expected type of the list items
     * @return Current value or specified default if it was not set
     */
    default <Z> Set<Z> getSetMeta(TempMetaKey key, Set<Z> def) {
        return getMeta(key);
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @param <Z> Expected type of the list items
     * @return Previous value or null if it was not set
     */
    default <Z> Set<Z> setSetMeta(TempMetaKey key, Set<Z> value) {
        return setMeta(key, value);
    }

    /**
     * @param key Meta Key
     * @return If the object has meta specified by this key
     */
    default boolean hasMeta(MetaKey key) {
        final MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null && !metaMap.isEmpty() && metaMap.containsKey(key);
    }

    /**
     * Removes metadata at the specified key, and returns previous value
     * @param key Meta Key
     * @param <T> Expected type
     * @return Previous value or null if it was not set
     */
    default <T> T removeMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? (T) metaMap.remove(key) : null;
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Integer getIntegerMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getInteger(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Integer getIntegerMeta(MetaKey key, Integer def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getInteger(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Integer setIntegerMeta(MetaKey key, Integer value) {
        return getMetaMap(key, true).setInteger(key, value);
    }

    /**
     * Gets the current value, defaulting to 0 if not set, and adjusts it
     * and sets and returns the new value.
     *
     * @param key Meta Key
     * @param amount Amount to adjust the number by
     * @return The new value after adjustment
     */
    default Integer adjustIntegerMeta(MetaKey key, int amount) {
        return getMetaMap(key, true).adjustInteger(key, amount);
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Long getLongMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getLong(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Long getLongMeta(MetaKey key, Long def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getLong(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Long setLongMeta(MetaKey key, Long value) {
        return getMetaMap(key, true).setLong(key, value);
    }

    /**
     * Gets the current value, defaulting to 0 if not set, and adjusts it
     * and sets and returns the new value.
     *
     * @param key Meta Key
     * @param amount Amount to adjust the number by
     * @return The new value after adjustment
     */
    default Long adjustLongMeta(MetaKey key, long amount) {
        return getMetaMap(key, true).adjustLong(key, amount);
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Double getDoubleMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getDouble(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Double getDoubleMeta(MetaKey key, Double def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getDouble(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Double setDoubleMeta(MetaKey key, Double value) {
        return getMetaMap(key, true).setDouble(key, value);
    }

    /**
     * Gets the current value, defaulting to 0 if not set, and adjusts it
     * and sets and returns the new value.
     *
     * @param key Meta Key
     * @param amount Amount to adjust the number by
     * @return The new value after adjustment
     */
    default Double adjustDoubleMeta(MetaKey key, double amount) {
        return getMetaMap(key, true).adjustDouble(key, amount);
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Float getFloatMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getFloat(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Float getFloatMeta(MetaKey key, Float def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getFloat(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Float setFloatMeta(MetaKey key, Float value) {
        return getMetaMap(key, true).setFloat(key, value);
    }

    /**
     * Gets the current value, defaulting to 0 if not set, and adjusts it
     * and sets and returns the new value.
     *
     * @param key Meta Key
     * @param amount Amount to adjust the number by
     * @return The new value after adjustment
     */
    default Float adjustFloatMeta(MetaKey key, float amount) {
        return getMetaMap(key, true).adjustFloat(key, amount);
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Short getShortMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getShort(key, null) : null;
    }

    /**
     *
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Short getShortMeta(MetaKey key, Short def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getShort(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Short setShortMeta(MetaKey key, Short value) {
        return getMetaMap(key, true).setShort(key, value);
    }

    /**
     * Gets the current value, defaulting to 0 if not set, and adjusts it
     * and sets and returns the new value.
     *
     * @param key Meta Key
     * @param amount Amount to adjust the number by
     * @return The new value after adjustment
     */
    default Short adjustShortMeta(MetaKey key, short amount) {
        return getMetaMap(key, true).adjustShort(key, amount);
    }

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default Boolean getBooleanMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getBoolean(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default Boolean getBooleanMeta(MetaKey key, Boolean def) {
        MetaMap metaMap = getMetaMap(key, false);
        return metaMap != null ? metaMap.getBoolean(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default Boolean setBooleanMeta(MetaKey key, Boolean value) {
        MetaMap metaMap = getMetaMap(key, true);
        return metaMap != null ? metaMap.setBoolean(key, value) : null;
    }

    /**
     * @param key Meta Key
     * @param <T> Expected Type of the ItemStack (incase Custom Stacks are used)
     * @return Current value or null if it was not set
     */
    default <T extends ItemStack> T getItemStackMeta(MetaKey key) {
        MetaMap metaMap = getMetaMap(key, true);
        return metaMap != null ? (T) metaMap.getItemStack(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @param <T> Expected Type of the ItemStack (incase Custom Stacks are used)
     * @return Current value or specified default if it was not set
     */
    default <T extends ItemStack> T getItemStackMeta(MetaKey key, T def) {
        MetaMap metaMap = getMetaMap(key, true);
        return metaMap != null ? (T) metaMap.getItemStack(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @param <T> Expected Type of the ItemStack (incase Custom Stacks are used)
     * @return Previous value or null if it was not set
     */
    default <T extends ItemStack> T setItemStackMeta(MetaKey key, ItemStack value) {
        MetaMap metaMap = getMetaMap(key, true);
        return metaMap != null ? (T) metaMap.setItemStack(key, value) : null;
    }

    // TODO: ConfigurationSerializeable
}
