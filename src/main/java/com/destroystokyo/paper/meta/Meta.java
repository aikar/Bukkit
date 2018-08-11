package com.destroystokyo.paper.meta;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("WeakerAccess")
public class Meta {

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean isValidPersistentMeta(Object value) {
        return (value instanceof String) || (value instanceof Long) ||
            (value instanceof Integer) || (value instanceof ItemStack) ||
            (value instanceof Float) || (value instanceof Double) ||
            (value instanceof PersistentMetaMap) || (value instanceof PersistentMetaList) ||
            (value instanceof PersistentMetaSet);
        // TODO: ConfigurationSerializable
    }

    public static TempMetaKey createTempKey(String key) {
        return new TempMetaKey(null, key);
    }

    public static PersistentMetaKey createPersistentKey(String key) {
        return new PersistentMetaKey(null, key);
    }

    public static TempMetaKey createTempKey(Plugin plugin, String key) {
        return new TempMetaKey(plugin.getName(), key);
    }

    public static PersistentMetaKey createPersistentKey(Plugin plugin, String key) {
        return new PersistentMetaKey(plugin.getName(), key);
    }

    public static TempMetaKey createTempKey(NamespacedKey key) {
        return new TempMetaKey(key.getNamespace(), key.getKey());
    }

    public static PersistentMetaKey createPersistentKey(NamespacedKey key) {
        return new PersistentMetaKey(key.getNamespace(), key.getKey());
    }
}
