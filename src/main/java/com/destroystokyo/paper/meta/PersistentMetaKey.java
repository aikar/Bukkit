package com.destroystokyo.paper.meta;

public class PersistentMetaKey extends MetaKey {
    PersistentMetaKey(String namespace, String key) {
        super(namespace, key);
    }

    public PersistentMetaKey append(String suffix) {
        return new PersistentMetaKey(namespace(), key() + suffix);
    }
}
