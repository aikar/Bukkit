package com.destroystokyo.paper.meta;

/**
 * Represents an object that has the capability of storing metadata and
 * able to persist it between object reloads such as server restarts or chunk reloads.
 * <p>
 * Limited to data formats that can be serialized.
 * <p>
 * Use the Bukkit {@link org.bukkit.configuration.serialization.ConfigurationSerializable} API to make
 * your custom data objects safe for persistence.
 * <p>
 * This data will not be removed if your plugin is removed. You must handle clean up on your own.
 * <p>
 * This API is not thread safe!
 */
public interface PersistentMetaContainer extends MetaContainer {

    @Override
    default MetaMap getMetaMap(MetaKey key, boolean isWrite) {
        if (key instanceof TempMetaKey) {
            return getTempMetaMap((TempMetaKey) key, isWrite);
        } else if (key instanceof PersistentMetaKey) {
            return getPersistentMetaMap((PersistentMetaKey) key, isWrite);
        } else {
            throw new IllegalArgumentException("Unknown Key Type");
        }
    }

    PersistentMetaMap getPersistentMetaMap(PersistentMetaKey key, boolean isWrite);

    /**
     * @param key Meta Key
     * @return Current value or null if it was not set
     */
    default PersistentMetaMap getPersistentMapMeta(PersistentMetaKey key) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentMap(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @return Current value or specified default if it was not set
     */
    default PersistentMetaMap getPersistentMapMeta(PersistentMetaKey key, PersistentMetaMap def) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentMap(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @return Previous value or null if it was not set
     */
    default PersistentMetaMap setPersistentMapMeta(PersistentMetaKey key, PersistentMetaMap value) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, true);
        return metaMap != null ? metaMap.setPersistentMap(key, value) : null;
    }

    /**
     * @param key Meta Key
     * @param <Z> Expected type of the list items
     * @return Current value or null if it was not set
     */
    default <Z> PersistentMetaList<Z> getPersistentListMeta(PersistentMetaKey key) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentList(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @param <Z> Expected type of the list items
     * @return Current value or specified default if it was not set
     */
    default <Z> PersistentMetaList<Z> getPersistentListMeta(PersistentMetaKey key, PersistentMetaList<Z> def) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentList(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @param <Z> Expected type of the list items
     * @return Previous value or null if it was not set
     */
    default <Z> PersistentMetaList<Z> setPersistentListMeta(PersistentMetaKey key, PersistentMetaList<Z> value) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, true);
        return metaMap != null ? metaMap.setPersistentList(key, value) : null;
    }


    /**
     * @param key Meta Key
     * @param <Z> Expected type of the set items
     * @return Current value or null if it was not set
     */
    default <Z> PersistentMetaSet<Z> getPersistentSetMeta(PersistentMetaKey key) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentSet(key, null) : null;
    }

    /**
     * @param key Meta Key
     * @param def Default value to return if not set
     * @param <Z> Expected type of the set items
     * @return Current value or specified default if it was not set
     */
    default <Z> PersistentMetaSet<Z> getPersistentSetMeta(PersistentMetaKey key, PersistentMetaSet<Z> def) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, false);
        return metaMap != null ? metaMap.getPersistentSet(key, def) : null;
    }

    /**
     * @param key Meta Key
     * @param value The value to set
     * @param <Z> Expected type of the set items
     * @return Previous value or null if it was not set
     */
    default <Z> PersistentMetaSet<Z> setPersistentSetMeta(PersistentMetaKey key, PersistentMetaSet<Z> value) {
        PersistentMetaMap metaMap = getPersistentMetaMap(key, true);
        return metaMap != null ? metaMap.setPersistentSet(key, value) : null;
    }

}
